package com.poc.iLoveGithubWeb.infrastructure.member;

import com.poc.iLoveGithubWeb.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {

    Optional<Member> findByLogin(String login);
}
