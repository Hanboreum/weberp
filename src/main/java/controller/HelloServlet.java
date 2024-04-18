package controller;

import repository.service.MyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//javase => jdk 설치시 탑재(API List,Map, Set)
// javaee ->API 필요하다
//httpservlet - web용 api
//http://localhost:8081/weberp/hello
@WebServlet("/hello") //servlet Mapping. hello라는 요청이 왔을 때 맵핑해줌
public class HelloServlet extends HttpServlet { //Servlet : 서버에서 100% 자바로 만들어진 웹프로그래밍

    @Override       //req = 요청객체, resp = 응답 객체
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // <html> tag를 이용해서 응답 코드 작성
        // 1~10까지의 총합이=?
        // 1. 직접구한다. 2. 별도의 클래스에서 처리한다.(O)
        // 객체생성
        int hap=MyService.hap();
        // 응답시 한글 깨짐 처리
        resp.setContentType("text/html;charset=UTF-8");  // MIME Type
        // 클라이언트에 응답할 출력 스트림(빨대)을 만들어야 한다.
        PrintWriter out=resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<table border='1'>");
        out.println("<tr>");
        out.println("<td>총합</td>");
        out.println("<td>"+hap+"</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}

/*
    //1-10까지의 합 =? 응답 resp이용. 여기 안에 클라이언트 정보가 잇다.
        //응답을 하려면 다른쪽의 ip addr,port number를 알아야 한다.
        // 클라이언트에 응답할 출력 스트림 (빨대를 만들어야 한다)
        //응답 빨대 PrintWriter. out을 사용해 데이터를 내보내자

        //1-10의 합을 구하는 방법 1. 직접구한다. 2. 별도의 클래스에서 처리
        int hap = MyService.hap(); //객체 생성. static 이니까 new 필요 없음

        //클라이언트에게 어떻게 요청?
 */