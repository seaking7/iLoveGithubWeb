package com.poc.iLoveGithubWeb.infrastructure.rank;

import com.poc.iLoveGithubWeb.domain.rank.RankInfo;
import com.poc.iLoveGithubWeb.domain.rank.RankStore;
import com.poc.iLoveGithubWeb.domain.rank.SourceRankInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@Component
@RequiredArgsConstructor
public class RankStoreImpl implements RankStore {

    private final RankRepository rankRepository;


    @Override
    public List<RankInfo> getUserRankIndex() {
        return rankRepository.findUserRankAll();
    }

    @Override
    public List<RankInfo> getOrgRankIndex() {
        return rankRepository.findOrgRankAll();
    }

    @Override
    public List<SourceRankInfo> getSourceRankIndex() {
        return rankRepository.findSourceRankAll();
    }
}
