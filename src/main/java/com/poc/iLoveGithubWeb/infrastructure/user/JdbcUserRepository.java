package com.poc.iLoveGithubWeb.infrastructure.user;

import com.poc.iLoveGithubWeb.domain.user.UserDetailInfo;
import com.poc.iLoveGithubWeb.domain.user.UserRepoInfo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class JdbcUserRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Optional<UserDetailInfo> findUserDetailById(int id) {
        String query = "select id, login, status, name, type, blog, company, location, email, bio, " +
                "public_repos, followers, following, updated_at, " +
                "(select sum(stargazers_count) from g_repository gr where gr.login = a.login ) star \n " +
                "from g_user a where id = ?";
        List<UserDetailInfo> result = jdbcTemplate.query(query, userDetailRowMapper(), id);
        return result.stream().findFirst();
    }

    public Optional<UserDetailInfo> findUserDetailByLogin(String login) {
        String query = "select id, login, status, name, type, blog, company, location, email, bio, " +
                "public_repos, followers, following, updated_at, " +
                "(select sum(stargazers_count) from g_repository gr where gr.login = a.login ) star \n " +
                "from g_user a where login = ?";
        List<UserDetailInfo> result = jdbcTemplate.query(query, userDetailRowMapper(), login);
        return result.stream().findFirst();
    }


    public List<UserRepoInfo> findUserRepoById(int id) {
        String query = "select id, login, name, size, stargazers_count , language, created_at , updated_at , pushed_at " +
                "from g_repository gr \n" +
                "where login in (select login from g_user where id = ?) \n" +
                "order by stargazers_count desc";

        List<UserRepoInfo> result = jdbcTemplate.query(query, userRepoRowMapper(), id);
        return result;
    }

    public List<UserRepoInfo> findUserRepoByLogin(String login) {
        String query = "select id, login, name, size, stargazers_count , language, created_at , updated_at , pushed_at " +
                "from g_repository gr \n" +
                "where login = ? \n" +
                "order by stargazers_count desc";

        List<UserRepoInfo> result = jdbcTemplate.query(query, userRepoRowMapper(), login);
        return result;
    }

    public void deleteByContentId(String contentId){
        jdbcTemplate.update("delete from executeLog where content_id = ?", contentId);
    }


    private RowMapper<UserRepoInfo> userRepoRowMapper() {
        return (rs, rowNum) -> {
            UserRepoInfo userRepoInfo = new UserRepoInfo();
            userRepoInfo.setId(rs.getInt("id"));
            userRepoInfo.setLogin(rs.getString("login"));
            userRepoInfo.setName(rs.getString("name"));
            userRepoInfo.setSize(rs.getInt("size"));
            userRepoInfo.setStargazersCount(rs.getInt("stargazers_count"));
            userRepoInfo.setLanguage(rs.getString("language"));
            userRepoInfo.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
            userRepoInfo.setUpdatedAt(rs.getTimestamp("updated_at") == null ? null : rs.getTimestamp("updated_at").toLocalDateTime());
            userRepoInfo.setPushedAt(rs.getTimestamp("pushed_at") == null ? null : rs.getTimestamp("pushed_at").toLocalDateTime());
            return userRepoInfo;
        };
    }

    private RowMapper<UserDetailInfo> userDetailRowMapper() {
        return (rs, rowNum) -> {
            UserDetailInfo userDetailInfo = new UserDetailInfo();
            userDetailInfo.setId(rs.getInt("id"));
            userDetailInfo.setLogin(rs.getString("login"));
            userDetailInfo.setStatus(rs.getString("status"));
            userDetailInfo.setName(rs.getString("name"));
            userDetailInfo.setType(rs.getString("type"));
            userDetailInfo.setBlog(rs.getString("blog"));
            userDetailInfo.setCompany(rs.getString("company"));
            userDetailInfo.setLocation(rs.getString("location"));
            userDetailInfo.setEmail(rs.getString("email"));
            userDetailInfo.setBio(rs.getString("bio"));
            userDetailInfo.setPublic_repos(rs.getInt("public_repos"));
            userDetailInfo.setFollowers(rs.getInt("followers"));
            userDetailInfo.setFollowing(rs.getInt("following"));
            userDetailInfo.setStar(rs.getInt("star"));
            userDetailInfo.setUpdatedAt(rs.getTimestamp("updated_at") == null ? null : rs.getTimestamp("updated_at").toLocalDateTime());
            return userDetailInfo;
        };
    }

}
