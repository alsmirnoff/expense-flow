package com.learning.expense_flow;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.learning.expense_flow.domain.user.User;
import com.learning.expense_flow.infrastructure.persistence.UserRepository;

@SpringBootTest
@Transactional
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void shouldSaveAndFindByTelegramId() {
        User user = User.create(123456789L, "test_user");
        userRepository.save(user);

        Optional<User> found = userRepository.findByTelegramId(123456789L);
        assertTrue(found.isPresent());
        assertEquals("test_user", found.get().getUserName());
    }

}
