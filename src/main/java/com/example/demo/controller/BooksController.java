package com.example.demo.controller;



import com.example.demo.dao.*;
import com.example.demo.dto.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
public class BooksController {


    private final
    BooksRepository booksRepository;
    private CommentsRepository commentsRepository;
    private ReviewsRepository reviewsRepository;
    private CopyRepository copyRepository;
    private LoanRepository loanRepository;
    private AuthorsRepository authorsRepository;
    private UsersRepository usersRepository;

    @Autowired
    public BooksController(BooksRepository booksRepository, CommentsRepository commentsRepository, ReviewsRepository reviewsRepository, CopyRepository copyRepository, LoanRepository loanRepository, AuthorsRepository authorsRepository, UsersRepository usersRepository) {
        this.booksRepository = booksRepository;
        this.commentsRepository = commentsRepository;
        this.reviewsRepository = reviewsRepository;
        this.copyRepository = copyRepository;
        this.loanRepository = loanRepository;
        this.authorsRepository = authorsRepository;
        this.usersRepository = usersRepository;
    }
    public Users user(int id){
        Users user = new Users();
        for (Users users : usersRepository.showUsers()) {
            if (users.getIdUser().equals(id)) {
                user = users;
                break;
            }
        }
        return user;
    }
    public Books book(int id){
        Books book = new Books();
        for (Books books : booksRepository.showBooks()) {
            if (books.getIdBook().equals(id)) {
                book = books;
                break;
            }
        }
        return book;
    }
    public Copy copy(int id){
        Copy copy = new Copy();
        for (Copy copys : copyRepository.showCopy()) {
            if (copys.getIdCopy().equals(id)) {
                copy = copys;
                break;
            }
        }
        return copy;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value ="/showBooks",method = RequestMethod.GET)
    public List<Books> getBooks(){

        return booksRepository.findAll();
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value ="/showBook/{id}",method = RequestMethod.GET)
    public Books getBook(@PathVariable int id){
        Books sbook = new Books();
        int i = 0;
        boolean confirm=false;
        for (Books book : booksRepository.showBooks()) {
            if (book.getIdBook().equals(id)) {
               i=1;
               sbook = book;
               break;
            }
        }
        if(i==1){
            return sbook;
        }
        else
            return null;

    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value ="/comments/{id}",method = RequestMethod.GET)
    public List<Comments> getComments(@PathVariable int id){
        List<Comments> comments = new ArrayList<>();
        int i = 0;
        boolean confirm=false;
        for (Comments comment : commentsRepository.showComments()) {
            if (comment.getIdBook().getIdBook().equals(id)) {
                confirm= true;
                comments.add(comment);
            }
            i++;
        }
        if(confirm){
            return comments;
        }
        else
            return null;

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value ="/addBooks",method = RequestMethod.POST)
    public ResponseEntity  addNewBook(@RequestBody final BooksDto booksDto){
        Authors author = new Authors();
        for (Authors authors : authorsRepository.showAuthors()) {
            if (authors.getIdAuthor().equals(booksDto.getIdAuthor())) {
                author = authors;
                break;
            }
        }
        Books book = new Books(booksDto.getTitle(),booksDto.getDescription(),booksDto.getType(),author);
        booksRepository.save(book);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value ="/addKrzysiek",method = RequestMethod.POST)
    public ResponseEntity  addKrzysiek(@RequestBody final KrzysiekDTO krzysiekDTO){
//        Books book = new Books(booksDto.getTitle(),booksDto.getDescription(),booksDto.getType(),booksDto.getIdAuthor());
//        booksRepository.save(book);
        Optional<Authors> authors = authorsRepository.findById(krzysiekDTO.getIdAuthor());
        System.out.println(authors.get().getLastName());
        Books books = new Books();
        books.setDescription(krzysiekDTO.getDescription());
        books.setTitle(krzysiekDTO.getTitle());
        books.setType(krzysiekDTO.getType());
        books.setIdAuthor(new Authors(authors.get().getName(),authors.get().getLastName()));
        booksRepository.save(books);


        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value ="/showComments",method = RequestMethod.GET)
    public List<Comments> getComments(){

        return commentsRepository.showComments();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value ="/addComment",method = RequestMethod.POST)
    public ResponseEntity  addComment(@RequestBody final CommentsDto commentsDto){
        Comments comment = new Comments(commentsDto.getContentComment(),user(commentsDto.getIdUser()),book(commentsDto.getIdBook()));
        commentsRepository.save(comment);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value ="/showReviews",method = RequestMethod.GET)
    public List<Reviews> getReviews(){

        return reviewsRepository.showReviews();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value ="/addReview",method = RequestMethod.POST)
    public ResponseEntity  addReview(@RequestBody final ReviewsDto reviewsDto){
        Reviews review = new Reviews(reviewsDto.getContentReview(),user(reviewsDto.getIdUser()),book(reviewsDto.getIdBook()));
        reviewsRepository.save(review);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value ="/showCopys",method = RequestMethod.GET)
    public List<Copy> getCopys(){

        return copyRepository.showCopy();
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value ="/addCopy",method = RequestMethod.POST)
    public ResponseEntity  addCopy(@RequestBody final CopyDto copyDto){
        Copy copy = new Copy(book(copyDto.getIdBook()));
        copyRepository.save(copy);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value ="/showLoan",method = RequestMethod.GET)
    public List<Loan> getLoan(){

        return loanRepository.showLoan();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value ="/loanBook",method = RequestMethod.POST)
    public ResponseEntity  loanBook(@RequestBody final LoanDto loanDto){
        Loan loan = new Loan(loanDto.getDataLoan(), loanDto.getDataReturn(), user(loanDto.getIdUser()), copy(loanDto.getIdCopy()));
        loanRepository.save(loan);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
