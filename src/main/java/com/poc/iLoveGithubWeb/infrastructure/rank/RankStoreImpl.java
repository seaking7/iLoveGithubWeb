package com.poc.iLoveGithubWeb.infrastructure.rank;

import com.poc.iLoveGithubWeb.domain.rank.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    private final SourceRankRepository sourceRankRepository;


    @Override
    public Page<UserRankInfo> getUserRankIndex(Pageable pageable) {
        return userRankRepository.findByTypeEquals("User", pageable)
                .map(UserRankInfo::from);
    }

    @Override
    public List<RankInfo> getOrgRankIndex() {
        return globalRankRepository.findOrgRankAll();
    }


    @Override
    public List<UserRank> getKoreanUserRankIndex(String type, Boolean isKorean) {
        return koreanRankRepository.findKoreanUserAll(type, isKorean);
    }

    @Override
    public Page<SourceRankInfo> getGlobalSourceRank(Pageable pageable) {
        return sourceRankRepository.findBy(pageable).map(SourceRankInfo::from);
    }



    @Override
    public Page<SourceRankInfo> getKoreanSourceRank(Pageable pageable) {
        return sourceRankRepository.findByIsKoreanTrue(pageable)
                .map(SourceRankInfo::from);
    }

    @Override
    public Page<UserRankInfo> getKoreanUserRankIndex2(Pageable pageable) {
        return userRankRepository.findByTypeEqualsAndIsKoreanIsTrue("User", pageable)
                .map(UserRankInfo::from);
    }

    @Override
    public Page<SourceRankInfo> getGlobalSourceRankLanguageBy(Pageable pageable, String languageBy) {
        return sourceRankRepository.findByLanguageEquals(languageBy, pageable).map(SourceRankInfo::from);
    }

    @Override
    public Page<SourceRankInfo> getKoreanSourceRankLanguageBy(Pageable pageable, String languageBy) {
        return sourceRankRepository.findByLanguageEqualsAndIsKoreanTrue(languageBy, pageable)
                .map(SourceRankInfo::from);
    }
}
