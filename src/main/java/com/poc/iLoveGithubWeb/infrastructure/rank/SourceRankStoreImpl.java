package com.poc.iLoveGithubWeb.infrastructure.rank;

import com.poc.iLoveGithubWeb.domain.rank.source.SourceRankInfo;
import com.poc.iLoveGithubWeb.domain.rank.store.SourceRankStore;
import com.poc.iLoveGithubWeb.infrastructure.rank.repo.SourceRankRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class SourceRankStoreImpl implements SourceRankStore {

    private final SourceRankRepository sourceRankRepository;


    @Override
    public Page<SourceRankInfo> getGlobalSourceRank(Pageable pageable) {
        return sourceRankRepository.findBy(pageable).map(SourceRankInfo::from);
    }


    @Override
    public Page<SourceRankInfo> getGlobalSourceRankLanguageBy(String languageBy, Pageable pageable) {
        return sourceRankRepository.findByLanguageEquals(languageBy, pageable).map(SourceRankInfo::from);
    }

    @Override
    public Page<SourceRankInfo> getKoreanSourceRank(Pageable pageable) {
        return sourceRankRepository.findByIsKoreanTrue(pageable)
                .map(SourceRankInfo::from);
    }

    @Override
    public Page<SourceRankInfo> getKoreanSourceRankLanguageBy(String languageBy, Pageable pageable) {
        return sourceRankRepository.findByLanguageEqualsAndIsKoreanTrue(languageBy, pageable)
                .map(SourceRankInfo::from);
    }
}
