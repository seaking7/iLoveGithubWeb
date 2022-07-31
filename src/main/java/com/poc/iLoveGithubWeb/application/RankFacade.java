package com.poc.iLoveGithubWeb.application;

import com.poc.iLoveGithubWeb.domain.rank.RankInfo;
import com.poc.iLoveGithubWeb.domain.rank.RankService;
import com.poc.iLoveGithubWeb.domain.rank.SourceRankInfo;
import com.poc.iLoveGithubWeb.domain.rank.UserRankInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RankFacade {
    private final RankService rankService;

    public List<RankInfo> getOrgRankIndex() {
        return rankService.getOrgRankIndex();
    }

    public List<SourceRankInfo> getSourceRankIndex() {
        return rankService.getSourceRankIndex();
    }

    public List<RankInfo> getKoreanUserRankIndex() {
        return rankService.getKoreanUserRankIndex();
    }

    public List<RankInfo> getKoreanOrgRankIndex() {
        return rankService.getKoreanOrgRankIndex();
    }

    public List<SourceRankInfo> getKoreanSourceRankIndex() {
        return rankService.getKoreanSourceRankIndex();
    }

    public Page<UserRankInfo> getKoreanUserRankIndex(Pageable pageable) {
        return rankService.getKoreanUserRankIndex2(pageable);
    }

    public Page<UserRankInfo> getGlobalUserRankIndex(Pageable pageable) {
        return rankService.getGlobalUserRank(pageable);
    }
}
