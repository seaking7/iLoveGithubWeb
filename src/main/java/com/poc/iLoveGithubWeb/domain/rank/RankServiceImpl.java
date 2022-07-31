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
    public Page<SourceRankInfo> getGlobalSourceRank(Pageable pageable, String languageBy) {
        if(languageBy.equals("All"))
            return rankStore.getGlobalSourceRank(pageable);
        else
            return rankStore.getGlobalSourceRankLanguageBy(pageable, languageBy);
    }

    @Override
    public Page<SourceRankInfo> getKoreanSourceRank(Pageable pageable, String languageBy) {
        if(languageBy.equals("All"))
            return rankStore.getKoreanSourceRank(pageable);
        else
            return rankStore.getKoreanSourceRankLanguageBy(pageable, languageBy);
    }

    @Override
    public Page<UserRankInfo> getKoreanUserRankIndex2(Pageable pageable) {
        return rankStore.getKoreanUserRankIndex2(pageable);
    }
}
