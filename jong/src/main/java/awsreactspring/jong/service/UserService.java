package awsreactspring.jong.service;

import awsreactspring.jong.domain.SiteUser;
import awsreactspring.jong.repository.UserRepository;
import jakarta.transaction.Transactional;

@Transactional
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //회원가입
    public String join(SiteUser user){
        try{
            //중복확인
            validateDuplicatiteUser(user);
            userRepository.save(user);
            return "회원 가입 완료";
        }
        catch(IllegalStateException e){
            return e.getMessage();
        }
    }

    //로그인
    // public String login(User user){
    //     try{
            
    //     }
    // }

    public void validateDuplicatiteUser(SiteUser user){
        userRepository.findByEmail(user.getEmail())
            .ifPresent(m -> {throw new IllegalStateException("이미 존재하는 이메일입니다.");});
        userRepository.findByPhone(user.getPhone())
            .ifPresent(m -> {throw new IllegalStateException("이미 존재하는 전화번호입니다.");});
    }

    public void loginCheck(SiteUser user){
        if(userRepository.findByEmail(user.getEmail()).isEmpty()){            
            throw new IllegalStateException("이메일이 없습니다.");
        }
    }

}
