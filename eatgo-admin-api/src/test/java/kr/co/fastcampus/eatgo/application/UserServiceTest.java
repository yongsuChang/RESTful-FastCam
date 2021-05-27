package kr.co.fastcampus.eatgo.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import kr.co.fastcampus.eatgo.domain.User;
import kr.co.fastcampus.eatgo.domain.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

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
    public void getUsers(){
        List<User> mockUsers = new ArrayList<>();
        given(userRepository.findAll()).willReturn(mockUsers);

        List<User> users = userService.getUsers();

        User user = users.get(0);

        assertThat(user.getName(), is("테스터"));
    }

    @Test
    public void addUser(){
        String email = "admin@example.com";
        String name = "Administrator";

        User mockUser = userService.addUser(email, name);

        given(userRepository.save(any())).willReturn(mockUser);

        User user = userService.addUser(email, name);
        assertThat(user.getName(), is(name));
    }

    @Test
    public void updateUser(){
        Long id = 1004L;
        String email = "admin@example.com";
        String name = "Superman";
        Long level = 100L;

        User mockUser = User.builder()
                .id(id)
                .email(email)
                .name("Administrator")
                .level(1L)
                .build();

        given(userRepository.findById(id)).willReturn(Optional.of(mockUser));
        User user = userService.updateUser(id, email, name, level);

        verify(userRepository).findById(eq(id));

        assertThat(user.getName(), is("Superman"));
        assertThat(user.isAdmin(), is(true));
    }
}