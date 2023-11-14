package com.worldinpictures.repositories;

import com.worldinpictures.domain.entities.User;
import com.worldinpictures.domain.repositories.UserRepository;
import java.util.Optional;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Tsvetoslav Tsvetanov - Delta Source Bulgaria on 13.11.23
 */
@DataJpaTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    private User user;

    @Before
    public void setUp() {
        user = createUser();
    }

    @Test
    public void persistUser() {
        User user = createUser();
        userRepository.save(user);
        assertThat(userRepository.findById(1L).get(), equalTo(user));
    }

    @Test
    public void deleteUser() {
        userRepository.delete(user);
        assertThat(userRepository.findById(1L), equalTo(Optional.empty()));
    }

    private User createUser() {
        return User.builder()
                   .email("ceco_cvetanov@yahoo.com")
                   .firstName("Cecko")
                   .lastName("Cvetanov")
                   .password("abvgd")
                   .username("loshko")
                   .build();
    }
}
