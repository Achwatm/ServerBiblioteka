package com.example.demo.controller;



import com.example.demo.dao.*;
import com.example.demo.dto.BooksDto;
import com.example.demo.dto.CommentsDto;
import com.example.demo.dto.LoanDto;
import com.example.demo.dto.ReviewsDto;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
public class BooksController {


    final
    BooksRepository booksRepository;
    CommentsRepository commentsRepository;
    ReviewsRepository reviewsRepository;
    CopyRepository copyRepository;
    LoanRepository loanRepository;

    @Autowired
    public BooksController(BooksRepository booksRepository, CommentsRepository commentsRepository, ReviewsRepository reviewsRepository, CopyRepository copyRepository, LoanRepository loanRepository) {
        this.booksRepository = booksRepository;
        this.commentsRepository = commentsRepository;
        this.reviewsRepository = reviewsRepository;
        this.copyRepository = copyRepository;
        this.loanRepository = loanRepository;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value ="/showBooks",method = RequestMethod.GET)
    public List<Books> getBooks(){

        return booksRepository.showBooks();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @RequestMapping(value ="/addBook",method = RequestMethod.POST)
    public ResponseEntity  addNewBook(@RequestBody final BooksDto booksDto){
        Books book = new Books(booksDto.getTitle(),booksDto.getDescription(),booksDto.getType(),booksDto.getIdAuthor());
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
        Comments comment = new Comments(commentsDto.getContentComment(),commentsDto.getIdUser(),commentsDto.getIdBook());
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
        Reviews review = new Reviews(reviewsDto.getContentReview(),reviewsDto.getIdUser(),reviewsDto.getIdBook());
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
