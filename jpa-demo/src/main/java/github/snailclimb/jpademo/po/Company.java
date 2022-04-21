package github.snailclimb.jpademo.po;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor  //生成无参构造函数
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String companyName;

    private String description;

    public Company(String name,String description){
        this.companyName=name;
        this.description=description;
    }
}
