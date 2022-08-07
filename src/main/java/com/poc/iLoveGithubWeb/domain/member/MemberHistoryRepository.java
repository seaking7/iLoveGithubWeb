package com.poc.iLoveGithubWeb.domain.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberHistoryRepository extends JpaRepository<MemberHistory, Integer> {

}
