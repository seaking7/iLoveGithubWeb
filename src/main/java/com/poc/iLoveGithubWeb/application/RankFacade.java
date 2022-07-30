package com.poc.iLoveGithubWeb.application;

import com.poc.iLoveGithubWeb.domain.rank.RankInfo;
import com.poc.iLoveGithubWeb.domain.rank.RankService;
import com.poc.iLoveGithubWeb.domain.rank.SourceRankInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class RankFacade {
    private final RankService rankService;

    public List<RankInfo> getUserRankIndex() {
        return rankService.getUserRankIndex();
    }

    public List<RankInfo> getOrgRankIndex() {
        return rankService.getOrgRankIndex();
    }

    public List<SourceRankInfo> getSourceRankIndex() {
        return rankService.getSourceRankIndex();
    }

    public List<RankInfo> getKoreanUserRankIndex() {
        return rankService.getKoreanUserRankIndex();
    }
}
