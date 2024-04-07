package awsreactspring.jong.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import awsreactspring.jong.domain.SiteUser;
import awsreactspring.jong.repository.UserRepository;

@SpringBootTest
@Transactional
public class UserServiceIntegrationTest {

    @Autowired UserService userService;
    @Autowired UserRepository userRepository;

    @Test
    // @Commit
    void 회원가입() throws Exception {
        //given
        SiteUser user = new SiteUser();
        user.setEmail("jong@naver.com");
        user.setPassword("1234");
        user.setName("jong");
        user.setPhone("010-1234-1234");
        user.setBirth("2000.04.29");
        user.setAddress("충주시");               

        //when
        String Check = userService.join(user);

        //then
        System.out.println(Check);
    }

    @Test
    void 로그인() throws Exception {

    }
}
