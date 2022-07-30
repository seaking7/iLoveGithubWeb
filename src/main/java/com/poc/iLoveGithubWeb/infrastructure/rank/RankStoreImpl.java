package com.poc.iLoveGithubWeb.infrastructure.rank;

import com.poc.iLoveGithubWeb.domain.rank.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@Component
@RequiredArgsConstructor
public class RankStoreImpl implements RankStore {

    private final GlobalRankRepository globalRankRepository;
    private final KoreanRankRepository koreanRankRepository;

    private final UserRankRepository userRankRepository;


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
    public List<UserRank> getKoreanUserRankIndex(String type, Boolean isKorean) {
        return koreanRankRepository.findKoreanUserAll(type, isKorean);
//        PageRequest pageRequest = new PageRequest(0, 10, new Sort(Sort.Direction.DESC, "stargazersCount"));


    }

    @Override
    public List<SourceRank> getKoreanSourceRankIndex() {
        return koreanRankRepository.findSourceRankAll();
    }
}
