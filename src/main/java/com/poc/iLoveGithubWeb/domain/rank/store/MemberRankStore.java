package com.poc.iLoveGithubWeb.domain.rank.store;


import com.poc.iLoveGithubWeb.domain.rank.MemberRankInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MemberRankStore {

    public Page<MemberRankInfo> getMemberRank(Pageable pageable);

    public Page<MemberRankInfo> getMemberRankLanguageBy(String languageBy, Pageable pageable);

}
