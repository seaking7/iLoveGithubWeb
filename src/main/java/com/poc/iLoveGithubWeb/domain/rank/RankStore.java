package com.poc.iLoveGithubWeb.domain.rank;


import java.util.List;

public interface RankStore {

    List<RankInfo> getUserRankIndex();

    List<RankInfo> getOrgRankIndex();

    List<SourceRankInfo> getSourceRankIndex();
}
