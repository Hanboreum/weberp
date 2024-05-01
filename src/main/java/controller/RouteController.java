package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouteController { //경로변경 컨트롤러

    //책 리스트 보기
    @GetMapping("/restlist")
    public String restlist(){
        //책 리스트를 가져와야 함
        return  "restlist";
        //restlist.jsp서  --요청 --> /weberp/api/booksfh
        //              <--응답 --(json)
        //동적인 뷰를 만들어낸다.
    }

    @GetMapping("/restregister")
    public String restregister(){
        return "restregister"; // restregister.jsp
    }
}
