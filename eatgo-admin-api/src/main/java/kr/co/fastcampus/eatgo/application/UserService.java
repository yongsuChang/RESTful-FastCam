package kr.co.fastcampus.eatgo.application;

import java.util.ArrayList;
import java.util.List;

import kr.co.fastcampus.eatgo.domain.User;
import kr.co.fastcampus.eatgo.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        List<User> users = userRepository.findAll();
        users.add(User.builder()
                .email("tester@example.com")
                .name("테스터")
                .level(1L)
                .build());

        return users;
    }
}
