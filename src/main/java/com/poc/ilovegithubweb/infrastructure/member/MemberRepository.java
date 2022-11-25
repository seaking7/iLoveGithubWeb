package com.poc.ilovegithubweb.infrastructure.member;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.ilovegithubweb.domain.member.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

	Optional<Member> findByLogin(String login);
}
