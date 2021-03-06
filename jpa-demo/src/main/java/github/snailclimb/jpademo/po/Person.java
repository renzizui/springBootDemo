package github.snailclimb.jpademo.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    private Integer age;

    private Long companyId;

    private Long schoolId;

    public Person(String name,Integer age){
        this.name=name;
        this.age=age;
    }
}
