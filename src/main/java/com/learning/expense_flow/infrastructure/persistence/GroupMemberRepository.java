package com.learning.expense_flow.infrastructure.persistence;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.expense_flow.domain.group.GroupMember;

@Repository
public interface GroupMemberRepository extends JpaRepository<GroupMember, UUID> {

    List<GroupMember> findByTelegramId(Long telegramId);

    Optional<GroupMember> findByGroupIdAndTelegramId(UUID groupId, Long telegramId);
    
    List<GroupMember> findByGroupId(UUID groupId);
}
