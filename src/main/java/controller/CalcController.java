package controller;

import service.MyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calc")
public class CalcController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 클라이언트 폼에서 넘어온 파라메터(su1, su2)를 얻기(가져오기)  : get~~~
        int su1=Integer.parseInt(req.getParameter("su1")); // "50" --> 50
        int su2=Integer.parseInt(req.getParameter("su2"));
        //비즈니스 로직 담당 부분 model = service
        int sum=MyService.hap(su1, su2);

        //프레젠테이션 담당 부분view . <얘네를 뷰 jsp로 넘ㄱㅕ주자..>
        resp.setContentType("text/html;charset=UTF-8");  // MIME Type
        // 클라이언트에 응답할 출력 스트림(빨대)을 만들어야 한다.
        PrintWriter out=resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<table border='1'>");
        out.println("<tr>");
        out.println("<td>총합</td>");
        out.println("<td>"+sum+"</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}
/*
 //클라이언트 폼에서 넘어온 파라이터를 얻기 (가져오기) req를 사용
        int su1 = Integer.parseInt(req.getParameter("su1")); //숫자가 아니라 문자열로 넘어감 "50" -> 숫자 50으로 바꾸기
        int su2 = Integer.parseInt(req.getParameter("su2"));
        int sum = MyService.hap(su1, su2);
        resp.setContentType("text/html;charset=UTF-8"); // MINE TYPE 보내는 데이터 타입. 한글이고 텍스트이고 html이다.
        PrintWriter out = resp.getWriter(); //응답스트림
        out.println("<html>"); //출력내용
        out.println("<body>"); //뷰를 jsp로 뻬자.
        out.println("<table border ='1'>");
        out.println("<tr>");
        out.println("<td>총합</td>");
        out.println("<td>");
        out.println(sum);
        out.println("</td>");
        out.println("</tr>");
        out.println("<table>");
        out.println("</body>");
        out.println("</html>");
 */