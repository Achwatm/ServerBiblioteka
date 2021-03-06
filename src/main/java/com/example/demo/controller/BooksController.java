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


@RestController
public class BooksController {


    final
    BooksRepository booksRepository;
    CommentsRepository commentsRepository;
    ReviewsRepository reviewsRepository;
    CopyRepository copyRepository;
    LoanRepository loanRepository;
    AuthorsRepository authorsRepository;
    UsersRepository usersRepository;

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

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value ="/showBooks",method = RequestMethod.GET)
    public List<Books> getBooks(){

        return booksRepository.showBooks();
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
    @RequestMapping(value ="/addBook",method = RequestMethod.POST)
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
    @RequestMapping(value ="/showLoan",method = RequestMethod.GET)
    public List<Loan> getLoan(){

        return loanRepository.showLoan();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value ="/loanBook",method = RequestMethod.POST)
    public ResponseEntity  loanBook(@RequestBody final LoanDto loanDto){
        Loan loan = new Loan(loanDto.getDataLoan(), loanDto.getDataReturn(), loanDto.getIdUser(), loanDto.getIdCopy());
        loanRepository.save(loan);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
