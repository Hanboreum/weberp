package controller;

import entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import repository.BookDAO;
import java.util.List;

@Controller //web.xml의 scan이 인지, 메모리에 올린다.
public class BookController { //new BookController() : spring container 에서 관리
//책 관련 컨트롤러 -
    //GET bookList - FC - Handler Mapping: POJO 연결 시킨다.
    //http://localhost:8081/weberp/bookList
    @RequestMapping("/bookList")
    public String list(Model model){
        //db에서 책 가져오기
        //View : list
        BookDAO dao = new BookDAO();
        List<Book> list = dao.bookList();
        model.addAttribute("list",list);

        return "list"; //view의 논리적인 이름, web.xml에게 전달 -> list.jsp에게 전달 ${}forward
    }
    @GetMapping("/register") //get등록화면
    public String registerGET(){
        return "register"; //register.jsp: forward
    }

    @PostMapping("/register") //post 등록
    public String registerPOST(Book book){
        BookDAO dao = new BookDAO();
        dao.bookRegister(book); //등록
        //등록 성공 시 다시 list 이동 = redirect
        return "redirect:/bookList";
    }
}
//과제 : 등록과 화면 보기