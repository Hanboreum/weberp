package repository;

import entity.Book;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

//JDBC -> MyBatis -> Spring My Batis -> Hibernate(OPM) -> JPA
//JDBC -> Java + SQL = 유지보수 어려움. 생산성 떨어짐
//MyBatis -> SQL과 JAVA를 분리, 매핑 시켜준다.
public interface BookMapper { //repository

    //CRUD
    public List<Book> bookList(); //추상 메서드로 변환.

    public int bookRegister(Book book);
    public void bookDelete(int num);
    public Book getByNum( int num);
    public void bookUpdate(@Param("num") int num, @Param("book") Book book);//(title, price, author, page, num=5)

}



/*

public interface BookDAO { //new BookDAO
    /*private static SqlSessionFactory sqlSessionFactory; //객체 하나만 만들어 사용하는 싱글톤 패턴
    //API: sqlSessionFactoryBuilder -> config.xml -> Connection Pool(connection(sql session) 5~7개의 connection을 만든다.)
    //db 연결. root-context.xml이 해줌
    //초기화 블록
    static {
        try{
            String resource = "mybatis-config/config.xml"; //config.xml 경로
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
public class SqlSessionFactoryBean구현체 ()implements BookDAO{
 이 구현체를 스프링이 제공해준다

 public List<Book> bookList() {
    코드가 자동으로 만들어 진다.
 }
 public int bookRegister(Book book){
       자동으로
 }
}

BookDAO dao = new SqlSessionFactoryBean();


mybatis는 connection pool 이라는 말 대신 sql session이라는 말을 쓴다.
SqlSessionFactory : connection pool 들이 모여있는 객체
config.xml을 sqlsessionfactory에 넘겨준다.

*/