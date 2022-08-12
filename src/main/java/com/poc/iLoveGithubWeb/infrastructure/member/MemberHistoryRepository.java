package com.poc.iLoveGithubWeb.infrastructure.member;

import com.poc.iLoveGithubWeb.domain.member.MemberHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberHistoryRepository extends JpaRepository<MemberHistory, Integer> {

}
