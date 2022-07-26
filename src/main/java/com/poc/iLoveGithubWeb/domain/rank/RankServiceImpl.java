package com.poc.iLoveGithubWeb.domain.rank;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class RankServiceImpl implements RankService {
    private final RankStore rankStore;

    @Override
    public List<RankInfo> getUserRankIndex() {
        return rankStore.getUserRankIndex();
    }

    @Override
    public List<RankInfo> getOrgRankIndex() {
        return rankStore.getOrgRankIndex();
    }

    @Override
    public List<SourceRankInfo> getSourceRankIndex() {
        return rankStore.getSourceRankIndex();
    }
}
