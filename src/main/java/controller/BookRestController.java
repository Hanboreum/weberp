package controller;

import entity.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import repository.BookMapper;

import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController
@RequestMapping("/api")

public class BookRestController {

    @Autowired
    private BookMapper mapper;

    @GetMapping("/books")
    public ResponseEntity<?>list( ){
        List<Book> list = mapper.bookList();
        return new ResponseEntity<>(list, HttpStatus.OK);
        //Data(Json)의 응답 상태 코드를 같이 보냄
    }

    @DeleteMapping("/books/{num}")
    public ResponseEntity<?> delete(@PathVariable int num){
        mapper.bookDelete(num);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("text", "plain", StandardCharsets.UTF_8));
        return new ResponseEntity<>("성공", HttpStatus.OK);
    }
    @PostMapping("/books") //get등록화면
    public ResponseEntity<?> register( @RequestBody Book book){
        int cnt = mapper.bookRegister(book);
        return new ResponseEntity<>(cnt, HttpStatus.OK);
    }
    //상세보기
    @GetMapping("/books/{num}")
    public ResponseEntity<?> getByNum(@PathVariable int num){
        Book book = mapper.getByNum(num);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    //수정
    @PutMapping("/books/{num}") //수정
    public ResponseEntity<?> update(@PathVariable int num, @RequestBody Book book){
        //book.setNum(num);
        mapper.bookUpdate(num,book);
        return new ResponseEntity<>("success",HttpStatus.OK);
    }
}
