package kr.co.fastcampus.eatgo.application;

import kr.co.fastcampus.eatgo.domain.Restaurant;
import kr.co.fastcampus.eatgo.domain.User;
import kr.co.fastcampus.eatgo.domain.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class UserServiceTest {

    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
        userService = new UserService(userRepository);
    }

    @Test
    public void registerUser(){
        String email = "tester@example.com";
        String name = "Tester";
        String password = "test";

        userService.registerUser(email, name, password);

        verify(userRepository).save(any());
    }

    @Test
    public void registerUserWithExistedEmail(){
        assertThrows(EmailExistedExecption.class, () -> {
            String email = "tester@example.com";
            String name = "Tester";
            String password = "test";

            User mockUser = User.builder().build();
            given(userRepository.findByEmail(email)).willReturn(Optional.of(mockUser));

            userService.registerUser(email, name, password);

            verify(userRepository, never()).save(any());
        });
    }
}