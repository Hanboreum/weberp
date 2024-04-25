package controller;

public class ViewResolver {
    public static String makeView(String view){  // list
        return "/WEB-INF/views/"+view+".jsp";
    }
}
