package controller;

import entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import repository.BookMapper;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private BookMapper bookMapper;

    @PostMapping("/login") //username, password
    public String login(Member member, HttpSession session){
        if( member.getUsername().equals("admin") &&
        member.getPassword().equals("admin")){ //인증 성공시에-> 객체 바인딩 HttpSession
            //세션 생성시 고유한 아이디값이 생성됨. 클라이언트를 식별하기 위한, 중복 불가.
            //인증 성공한 것을 서버, 메모리에 올려둬야함
            Member dbmem = new Member();
            dbmem.setUsername(member.getUsername());// admin
            dbmem.setName("관리자");
            dbmem.setEmail("rfw@gmail.com");
            session.setAttribute("dbmem", dbmem); //인증 성공시 ,객체 바인딩. ${! empty dbmem} -> ${dbmem.name}
         }
        return "redirect:/bookList"; //시작 페이지로
    }

    @PostMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate(); //무효화. 세셩 끊기
        return "redirect:/bookList";
    }
}
