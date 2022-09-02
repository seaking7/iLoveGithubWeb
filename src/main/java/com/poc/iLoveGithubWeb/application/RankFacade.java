package com.poc.iLoveGithubWeb.application;

import com.poc.iLoveGithubWeb.domain.rank.*;
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

    public Page<OrgRankInfo> getGlobalOrgRank(String languageBy, Pageable pageable) {
        return rankService.getOrgRankIndex(languageBy, pageable);
    }

    public Page<SourceRankInfo> getSourceRankIndex(String languageBy, Pageable pageable) {
        return rankService.getGlobalSourceRank(languageBy, pageable);
    }

    public Page<OrgRankInfo> getKoreanOrgRank(String languageBy, Pageable pageable) {
        return rankService.getKoreanOrgRank(languageBy, pageable);
    }

    public Page<SourceRankInfo> getKoreanSourceRank(String languageBy, Pageable pageable) {
        return rankService.getKoreanSourceRank(languageBy, pageable);
    }

    public Page<UserRankInfo> getKoreanUserRank(String languageBy, Pageable pageable) {
        return rankService.getKoreanUserRank(languageBy, pageable);
    }

    public Page<UserRankInfo> getGlobalUserRank(String languageBy, Pageable pageable) {
        return rankService.getGlobalUserRank(languageBy, pageable);
    }

    public Page<MemberRankInfo> getMemberRank(String languageBy, Pageable pageable) {
        return rankService.getMemberRank(languageBy, pageable);
    }
}
