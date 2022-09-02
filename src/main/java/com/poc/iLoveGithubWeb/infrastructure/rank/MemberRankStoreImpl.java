package com.poc.iLoveGithubWeb.infrastructure.rank;

import com.poc.iLoveGithubWeb.domain.rank.MemberRankInfo;
import com.poc.iLoveGithubWeb.domain.rank.store.MemberRankStore;
import com.poc.iLoveGithubWeb.infrastructure.rank.repo.MemberRankRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class MemberRankStoreImpl implements MemberRankStore {

    private final MemberRankRepository memberRankRepository;

    @Override
    public Page<MemberRankInfo> getMemberRank(Pageable pageable) {
        return memberRankRepository.findBy(pageable)
                .map(MemberRankInfo::from);
    }

    @Override
    public Page<MemberRankInfo> getMemberRankLanguageBy(String languageBy, Pageable pageable) {
        return memberRankRepository.findByFirstLanguageEquals(languageBy, pageable)
                        .map(MemberRankInfo::from);
    }




}
