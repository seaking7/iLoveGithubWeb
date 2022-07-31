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


    public List<RankInfo> findOrgRankAll(){
        String query = "select id, login, followers, following, size, stargazers_count, updated_at " +
                "from g_user_rank " +
                "where type = 'Organization' " +
                "order by stargazers_count desc limit 30";
        List<RankInfo> result = jdbcTemplate.query(query, rankRowMapper());
        return result;
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


}
