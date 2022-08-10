package com.poc.iLoveGithubWeb.application;

import com.poc.iLoveGithubWeb.domain.rank.OrgRankInfo;
import com.poc.iLoveGithubWeb.domain.rank.RankService;
import com.poc.iLoveGithubWeb.domain.rank.SourceRankInfo;
import com.poc.iLoveGithubWeb.domain.rank.UserRankInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class RankFacade {
    private final RankService rankService;

    public Page<OrgRankInfo> getGlobalOrgRank(Pageable pageable) {
        return rankService.getOrgRankIndex(pageable);
    }

    public Page<SourceRankInfo> getSourceRankIndex(String languageBy, Pageable pageable) {
        return rankService.getGlobalSourceRank(languageBy, pageable);
    }

    public Page<OrgRankInfo> getKoreanOrgRank(Pageable pageable) {
        return rankService.getKoreanOrgRankIndex(pageable);
    }

    public Page<SourceRankInfo> getKoreanSourceRank(String languageBy, Pageable pageable) {
        return rankService.getKoreanSourceRank(languageBy, pageable);
    }

    public Page<UserRankInfo> getKoreanUserRank(Pageable pageable) {
        return rankService.getKoreanUserRank(pageable);
    }

    public Page<UserRankInfo> getGlobalUserRank(Pageable pageable) {
        return rankService.getGlobalUserRank(pageable);
    }
}
