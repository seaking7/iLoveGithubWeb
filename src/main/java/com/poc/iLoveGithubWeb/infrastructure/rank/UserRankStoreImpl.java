package com.poc.iLoveGithubWeb.infrastructure.rank;

import com.poc.iLoveGithubWeb.domain.rank.UserRankInfo;
import com.poc.iLoveGithubWeb.domain.rank.store.UserRankStore;
import com.poc.iLoveGithubWeb.infrastructure.rank.repo.UserRankRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class UserRankStoreImpl implements UserRankStore {

    private final UserRankRepository userRankRepository;

    @Override
    public Page<UserRankInfo> getUserRankIndex(Pageable pageable) {
        return userRankRepository.findBy(pageable)
                .map(UserRankInfo::from);
    }

    @Override
    public Page<UserRankInfo> getKoreanUserRank(Pageable pageable) {
        return userRankRepository.findByIsKoreanIsTrue(pageable)
                .map(UserRankInfo::from);
    }

}
