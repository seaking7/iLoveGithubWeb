package com.poc.iLoveGithubWeb.domain.rank;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class RankServiceImpl implements RankService {
    private final RankStore rankStore;

    @Override
    public Page<UserRankInfo> getGlobalUserRank(Pageable pageable) {
        return rankStore.getUserRankIndex(pageable);
    }

    @Override
    public List<RankInfo> getOrgRankIndex() {
        return rankStore.getOrgRankIndex();
    }

    @Override
    public List<SourceRankInfo> getSourceRankIndex() {
        return rankStore.getSourceRankIndex();
    }

    @Override
    public List<RankInfo> getKoreanUserRankIndex() {
        List<UserRank> koreanUserRankIndex = rankStore.getKoreanUserRankIndex("User", true);
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        List<RankInfo> result = new ArrayList<>();
        for (UserRank userRankIndex : koreanUserRankIndex) {
            RankInfo rankInfo = new RankInfo();
            mapper.map(userRankIndex, rankInfo);
            result.add(rankInfo);
        }

        return result;
    }

    @Override
    public List<RankInfo> getKoreanOrgRankIndex() {
        List<UserRank> koreanUserRankIndex = rankStore.getKoreanUserRankIndex("Organization", true);
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        List<RankInfo> result = new ArrayList<>();
        for (UserRank userRankIndex : koreanUserRankIndex) {
            RankInfo rankInfo = new RankInfo();
            mapper.map(userRankIndex, rankInfo);
            result.add(rankInfo);
        }

        return result;
    }

    @Override
    public List<SourceRankInfo> getKoreanSourceRankIndex() {

        List<SourceRank> koreanSourceRank = rankStore.getKoreanSourceRankIndex();
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        List<SourceRankInfo> result = new ArrayList<>();
        for (SourceRank sourceRank : koreanSourceRank) {
            SourceRankInfo rankInfo = new SourceRankInfo();
            mapper.map(sourceRank, rankInfo);
            result.add(rankInfo);
        }
        return result;
    }

    @Override
    public Page<UserRankInfo> getKoreanUserRankIndex2(Pageable pageable) {
        return rankStore.getKoreanUserRankIndex2(pageable);
    }
}
