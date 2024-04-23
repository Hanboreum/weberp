package repository;

import entity.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

//JDBC -> MyBatis -> Spring My Batis -> Hibernate(OPM) -> JPA
//JDBC -> Java + SQL = 유지보수 어려움. 생산성 떨어짐
//MyBatis -> SQL과 JAVA를 분리, 매핑 시켜준다.
public class BookDAO { //new BookDAO
    private static SqlSessionFactory sqlSessionFactory; //객체 하나만 만들어 사용하는 싱글톤 패턴
    //API: sqlSessionFactoryBuilder -> config.xml -> Connection Pool(connection(sql session) 5~7개의 connection을 만든다.)

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
    //CRUD
    public List<Book> bookList(){ //이 메소드 이름과 bookmapper select id 이름 통일
        //1. SqlSession 을 가져오기 (sqlfacotry 가 가지고 있음)
        SqlSession session = sqlSessionFactory.openSession();
        //select *from book, sql 구문 전송 (BookMapper.xml)
        List<Book> list = session.selectList("bookList"); //bookmapper의 select id. selectOne 은 하나만 가져올 때
        session.close(); //반납.
        return list;
    }
}


//mybatis는 connection pool 이라는 말 대신 sql session이라는 말을 쓴다.
//SqlSessionFactory : connection pool 들이 모여있는 객체
//config.xml을 sqlsessionfactory에 넘겨준다.