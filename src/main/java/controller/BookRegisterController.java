package controller;

import entity.Book;
import repository.BookDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class BookRegisterController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //title, price, author, page : form parameter -> (받아서DTo에 담아) = 파라미터 수집 -> 스프링은 이걸 자동으로
        //파라미터 수집은  DTO에
        //파라미터는 req가 받는다
        req.setCharacterEncoding("UTF-8");
        String title = req.getParameter("title");
        int price = Integer.parseInt(req.getParameter("price"));
        String author = req.getParameter("author");
        int page= Integer.parseInt(req.getParameter("page"));

        Book dto = new Book();
        dto.setTitle(title);
        dto.setAuthor(author);
        dto.setPage(page);
        dto.setPage(page);

        BookDAO dao = new BookDAO();
        int cnt = dao.bookRegister(dto);
        //성공시 다시 리스트 페이지로 감
        // 실패시 예외 발생
    }
}
