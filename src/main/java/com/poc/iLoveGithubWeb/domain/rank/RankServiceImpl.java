package com.poc.iLoveGithubWeb.domain.rank;

import com.poc.iLoveGithubWeb.domain.rank.store.OrgRankStore;
import com.poc.iLoveGithubWeb.domain.rank.store.SourceRankStore;
import com.poc.iLoveGithubWeb.domain.rank.store.UserRankStore;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class RankServiceImpl implements RankService {
    private final UserRankStore userRankStore;
    private final OrgRankStore orgRankStore;
    private final SourceRankStore sourceRankStore;

    @Override
    public Page<UserRankInfo> getGlobalUserRank(Pageable pageable) {
        return userRankStore.getUserRankIndex(pageable);
    }

    @Override
    public Page<OrgRankInfo> getOrgRankIndex(Pageable pageable) {
        return orgRankStore.getOrgRankIndex(pageable);
    }


    @Override
    public Page<OrgRankInfo> getKoreanOrgRankIndex(Pageable pageable) {
        return orgRankStore.getKoreanOrgRank(pageable);
    }

    @Override
    public Page<UserRankInfo> getKoreanUserRank(Pageable pageable) {
        return userRankStore.getKoreanUserRank(pageable);
    }

    @Override
    public Page<SourceRankInfo> getGlobalSourceRank(String languageBy, Pageable pageable) {
        if(languageBy.equals("All"))
            return sourceRankStore.getGlobalSourceRank(pageable);
        else
            return sourceRankStore.getGlobalSourceRankLanguageBy(languageBy, pageable);
    }

    @Override
    public Page<SourceRankInfo> getKoreanSourceRank(String languageBy, Pageable pageable) {
        if(languageBy.equals("All"))
            return sourceRankStore.getKoreanSourceRank(pageable);
        else
            return sourceRankStore.getKoreanSourceRankLanguageBy(languageBy, pageable);
    }


}
