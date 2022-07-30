package com.poc.iLoveGithubWeb.domain.rank;


import java.util.List;

public interface RankService {

    List<RankInfo> getUserRankIndex();

    List<RankInfo> getOrgRankIndex();

    List<SourceRankInfo> getSourceRankIndex();

    List<RankInfo> getKoreanUserRankIndex();
}
