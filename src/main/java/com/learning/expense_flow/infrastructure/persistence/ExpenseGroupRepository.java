package com.learning.expense_flow.infrastructure.persistence;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.expense_flow.domain.group.ExpenseGroup;

@Repository
public interface ExpenseGroupRepository extends JpaRepository<ExpenseGroup, UUID>{

    List<ExpenseGroup> findAllGroupsByTelegramId(Long telegramId);

    boolean isPresentInGroup(Long telegramId);
}
