package controller;

import entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import repository.BookMapper;
import java.util.List;

@Controller //web.xml의 scan이 인지, 메모리에 올린다.
public class BookController { //new BookController() : spring container 에서 관리
//책 관련 컨트롤러 -
    //GET bookList - FC - Handler Mapping: POJO 연결 시킨다.
    //http://localhost:8081/weberp/bookList

    @Autowired //DI의존성 주입
    private BookMapper mapper;
    @RequestMapping("/bookList") //handler mapping이 연결
    public String list(Model model){
        List<Book> list = mapper.bookList();
        model.addAttribute("list",list);
        return "list"; //view의 논리적인 이름, web.xml에게 전달 -> list.jsp에게 전달 ${}forward
    }

    @RequestMapping("/bookJson")
    public @ResponseBody List<Book> list( ){
        List<Book> list = mapper.bookList();
        return list;
    }

    @GetMapping("/register") //get등록화면
    public String registerGET(){
        return "register"; //register.jsp: forward
    }

    @PostMapping("/register") //post 등록
    public String registerPOST(Book book){
        //등록 성공 시 다시 list 이동 = redirect
        mapper.bookRegister(book);
        return "redirect:/bookList";
    }

    @GetMapping("/remove/{num}")
    public String remove(@PathVariable int num){
        mapper.bookDelete(num);
        return "redirect:/bookList";
    }
}
//과제 : 등록과 화면 보기