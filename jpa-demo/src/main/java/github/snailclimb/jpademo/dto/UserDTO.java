package github.snailclimb.jpademo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder(toBuilder = true)   //如果加true，可以修改这个对象属性值
@AllArgsConstructor
public class UserDTO {

    private String name;
    private int age;
    private String companyName;
    private String schoolName;
}
