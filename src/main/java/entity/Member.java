package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    private Long id;//일련번호
    private String username; //id
    private String password;
    private String name;// 실제이름
    private String email;

}
