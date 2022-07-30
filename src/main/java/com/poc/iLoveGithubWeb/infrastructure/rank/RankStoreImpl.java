package com.poc.iLoveGithubWeb.infrastructure.rank;

import com.poc.iLoveGithubWeb.domain.rank.RankInfo;
import com.poc.iLoveGithubWeb.domain.rank.RankStore;
import com.poc.iLoveGithubWeb.domain.rank.SourceRankInfo;
import com.poc.iLoveGithubWeb.domain.rank.UserRank;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@Component
@RequiredArgsConstructor
public class RankStoreImpl implements RankStore {

    private final GlobalRankRepository globalRankRepository;
    private final KoreanRankRepository koreanRankRepository;


    @Override
    public List<RankInfo> getUserRankIndex() {
        return globalRankRepository.findUserRankAll();
    }

    @Override
    public List<RankInfo> getOrgRankIndex() {
        return globalRankRepository.findOrgRankAll();
    }

    @Override
    public List<SourceRankInfo> getSourceRankIndex() {
        return globalRankRepository.findSourceRankAll();
    }

    @Override
    public List<UserRank> getKoreanUserRankIndex() {
        return koreanRankRepository.findKoreanUserAll();
    }
}
