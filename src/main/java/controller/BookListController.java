package controller;

import entity.Book;
import repository.BookDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//http://localhost:8081/bookList
//http://localhost:8081/weberp/bookList
@WebServlet("/bookList") //url처리, GetMapping,PostMapping 역할?
public class BookListController extends HttpServlet { //servlet 상속
//controller(정보를 req, resp에 담는다.) -> Helloservlet. 얘도 req,resp 가 필요함
    @Override //service
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //DB에서 책목록 가져오기: List -> ArrayList
       //req는 메모리다.
        //"list" -->list(번지값)
        BookDAO dao =new BookDAO();
        List<Book> list= dao.bookList();
        req.setAttribute("list",list);// 객체 바인딩(중요). 뷰가 가져가게 하려고.c와 v가 특정 메모리(req) 공유
        //여기서 html 할 수 없으니 view(jsp)와 연동 (forwarding, dispatcher) 컨트롤러와 뷰가 서로 소통
        //요청의뢰 객체를(RequestDispatcher) 얻어오는 방법
        RequestDispatcher rd = req.getRequestDispatcher(ViewResolver.makeView("list")); //이거 만들어서 리턴해줘야함 (/WEB-INF/views/list.jsp")
        rd.forward(req,resp); //포워딩. 요청 의뢰됨. list.jsp.helloservlet로 넘어감
        //뷰를 만들어서 다시 jsp로 넘겨야함 어떻게 보내주나... req를 이용해?
        //forward -> list,jsp로 보내주는 작업
    }
}
