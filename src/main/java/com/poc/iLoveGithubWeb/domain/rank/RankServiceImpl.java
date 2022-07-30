package com.poc.iLoveGithubWeb.domain.rank;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public List<RankInfo> getKoreanUserRankIndex() {
        List<UserRank> koreanUserRankIndex = rankStore.getKoreanUserRankIndex();
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
}
