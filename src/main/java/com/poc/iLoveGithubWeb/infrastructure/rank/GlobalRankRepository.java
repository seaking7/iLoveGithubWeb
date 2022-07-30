package com.poc.iLoveGithubWeb.infrastructure.rank;

import com.poc.iLoveGithubWeb.domain.rank.RankInfo;
import com.poc.iLoveGithubWeb.domain.rank.SourceRankInfo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class GlobalRankRepository {

    private final JdbcTemplate jdbcTemplate;

    public GlobalRankRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public Optional<RankInfo> findByContentId(String contentId) {
        List<RankInfo> result
                = jdbcTemplate.query("select login, followers, following, size, stargazers_count, updated_at from g_user_rank order by followers desc",
                rankRowMapper(),
                contentId);
        return result.stream().findAny();
    }

    public List<RankInfo> findUserRankAll(){
        String query = "select id, login, followers, following, size, stargazers_count, updated_at " +
                "from g_user_rank " +
                "where type = 'User' " +
                "order by stargazers_count desc limit 30";
        List<RankInfo> result = jdbcTemplate.query(query, rankRowMapper());
        return result;
    }

    public List<RankInfo> findOrgRankAll(){
        String query = "select id, login, followers, following, size, stargazers_count, updated_at " +
                "from g_user_rank " +
                "where type = 'Organization' " +
                "order by stargazers_count desc limit 30";
        List<RankInfo> result = jdbcTemplate.query(query, rankRowMapper());
        return result;
    }

    public List<SourceRankInfo> findSourceRankAll(){
        String query = "select id, login, name, size, stargazers_count, language, pushed_at " +
                "from g_source_rank " +
                "order by stargazers_count desc limit 30";
        List<SourceRankInfo> result = jdbcTemplate.query(query, sourceRawMapper());
        return result;
    }

    public void deleteByContentId(String contentId){
        jdbcTemplate.update("delete from executeLog where content_id = ?", contentId);
    }


    private RowMapper<RankInfo> rankRowMapper() {
        return (rs, rowNum) -> {
            RankInfo rankInfo = new RankInfo();
            rankInfo.setId(rs.getInt("id"));
            rankInfo.setLogin(rs.getString("login"));
            rankInfo.setFollowers(rs.getInt("followers"));
            rankInfo.setFollowing(rs.getInt("following"));
            rankInfo.setSize(rs.getInt("size"));
            rankInfo.setStargazersCount(rs.getInt("stargazers_count"));
            rankInfo.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());

            return rankInfo;
        };
    }

    private RowMapper<SourceRankInfo> sourceRawMapper() {
        return (rs, rowNum) -> {
            SourceRankInfo rankInfo = new SourceRankInfo();
            rankInfo.setId(rs.getInt("id"));
            rankInfo.setLogin(rs.getString("login"));
            rankInfo.setName(rs.getString("name"));
            rankInfo.setSize(rs.getInt("size"));
            rankInfo.setStargazersCount(rs.getInt("stargazers_count"));
            rankInfo.setLanguage(rs.getString("language"));
            rankInfo.setPushedAt(rs.getTimestamp("pushed_at").toLocalDateTime());

            return rankInfo;
        };
    }

}
