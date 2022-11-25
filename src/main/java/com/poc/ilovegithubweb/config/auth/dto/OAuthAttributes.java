package com.poc.ilovegithubweb.config.auth.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.poc.ilovegithubweb.domain.member.Member;
import com.poc.ilovegithubweb.domain.member.MemberHistory;
import com.poc.ilovegithubweb.domain.member.Role;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
public class OAuthAttributes {

	private Logger reportLogger = LoggerFactory.getLogger("logReportFile");
	private Map<String, Object> attributes;
	private String nameAttributeKey;

	private int id;
	private String login;
	private String status;
	private String type;
	private String name;
	private String blog;
	private String company;
	private String location;
	private String email;
	private String bio;
	private int publicRepos;
	private int followers;
	private int following;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private LocalDateTime joinedAt;
	private LocalDateTime lastLoginAt;

	@Builder
	public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey,
		int id, String login, String name, Role role, String type, String blog, String company, String location,
		String email, String bio, int publicRepos, int followers, int following,
		LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime joinedAt, LocalDateTime lastLoginAt) {
		this.attributes = attributes;
		this.nameAttributeKey = nameAttributeKey;
		this.id = id;
		this.login = login;
		this.name = name;
		this.type = type;
		this.blog = blog;
		this.company = company;
		this.location = location;
		this.email = email;
		this.bio = bio;
		this.publicRepos = publicRepos;
		this.followers = followers;
		this.following = following;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.joinedAt = joinedAt;
		this.lastLoginAt = lastLoginAt;
	}

	//registrationId : github, google, naver 등 인증주체, userNameAttributeName : 인증방법(id 등)
	public static OAuthAttributes of(String registrationId, String userNameAttributeName,
		Map<String, Object> attributes) {

		return ofGithub(userNameAttributeName, attributes);

	}

	private static OAuthAttributes ofGithub(String userNameAttributeName, Map<String, Object> attributes) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

		return OAuthAttributes.builder()
			.id((int)attributes.get("id"))
			.login((String)attributes.get("login"))
			.name((String)attributes.get("name"))
			.type((String)attributes.get("type"))
			.blog((String)attributes.get("blog"))
			.company((String)attributes.get("company"))
			.location((String)attributes.get("location"))
			.email((String)attributes.get("email"))
			.bio((String)attributes.get("bio"))
			.publicRepos((int)attributes.get("public_repos"))
			.followers((int)attributes.get("followers"))
			.following((int)attributes.get("following"))
			.createdAt(LocalDateTime.parse((String)attributes.get("created_at"), formatter))
			.updatedAt(LocalDateTime.parse((String)attributes.get("updated_at"), formatter))
			.attributes(attributes)
			.nameAttributeKey(userNameAttributeName)
			.build();
	}

	// 회원가입 Entity 생성
	public Member toEntity() {

		return Member.builder()
			.id(id)
			.login(login)
			.status("INIT")
			.name(name)
			.role(Role.MEMBER)
			.type(type)
			.blog(blog)
			.company(company)
			.location(location)
			.email(email)
			.bio(bio)
			.publicRepos(publicRepos)
			.followers(followers)
			.following(following)
			.createdAt(createdAt)
			.updatedAt(updatedAt)
			.joinedAt(LocalDateTime.now())
			.lastLoginAt(LocalDateTime.now())
			.build();
	}

	public MemberHistory toHistoryEntity() {
		return MemberHistory.builder()
			.id(id)
			.login(login)
			.loginAt(LocalDateTime.now())
			.build();
	}
}
