package com.poc.ilovegithubweb.infrastructure.member;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.ilovegithubweb.domain.member.MemberHistory;

public interface MemberHistoryRepository extends JpaRepository<MemberHistory, Integer> {

}
