package com.learning.expense_flow;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.learning.expense_flow.domain.group.ExpenseGroup;
import com.learning.expense_flow.domain.user.User;
import com.learning.expense_flow.infrastructure.persistence.ExpenseGroupRepository;
import com.learning.expense_flow.infrastructure.persistence.GroupMemberRepository;
import com.learning.expense_flow.infrastructure.persistence.UserRepository;

@Testcontainers
@DataJpaTest
public class GroupIntergationTest {

    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:13")
                            .withDatabaseName("testdb")
                            .withUsername("testuser")
                            .withPassword("testpass");

    @DynamicPropertySource
    static void registerPgProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
        registry.add("spring.jpa.hibernate.ddl-auto", () -> "create-drop");
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GroupMemberRepository groupMemberRepository;

    @Autowired
    private ExpenseGroupRepository expenseGroupRepository;

    @Test
    public void createAddAndFindGroupByTgId() {
        User user = User.create(123456789L, "test_user");
        userRepository.save(user);

        //ExpenseGroup group = new ExpenseGroup()

        // TODO: создать static create методы и по ним создать группу/участника
    }

}
