package github.snailclimb.jpademo.repository;

import github.snailclimb.jpademo.dto.UserDTO;
import github.snailclimb.jpademo.po.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;


@SpringBootTest
@RunWith(SpringRunner.class)   //Test测试类要使用注入的类
public class PersionRepositoryTest02 {

    @Autowired
    private PersonRepository personRepository;

    /*@Sql(scripts = {"classpath:/init.sql"})
    @Test
    public void should_filter_user_info(){
        List<String> personList=new ArrayList<>(Arrays.asList("person1","person2"));
        List<UserDTO> userDTOS = personRepository.filterUserInfo(personList);
        System.out.println(userDTOS);
    }
*/
    @Sql(scripts = {"classpath:/init.sql"})
    @Test
    public void find_person_age_older_than_18(){
        List<Person> personList=personRepository.findByAgeGreaterThan(18);
        assertEquals(1, personList.size());
    }

    @Sql(scripts = {"classpath:/init.sql"})
    @Test
    public void should_get_user_info(){
        //Optional<UserDTO> userInformation=personRepository.getUserInformation(1L);
    }

    @Sql(scripts = {"classpath:/init.sql"})
    @Test
    public void should_get_user_info_list(){
        PageRequest pageRequest = PageRequest.of(0, 3, Sort.Direction.DESC, "age");
        //Page<UserDTO> userInfomationList=personRepository
        Page<UserDTO> userInformationList = personRepository.getUserInformationList((Pageable) pageRequest);
        //查询结果总数
        System.out.println(userInformationList.getTotalElements());// 6
        //按照当前分页大小，总页数
        System.out.println(userInformationList.getTotalPages());// 2
        System.out.println(userInformationList.getContent());
    }



}
