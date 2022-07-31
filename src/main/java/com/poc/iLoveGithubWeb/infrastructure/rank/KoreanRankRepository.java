package com.poc.iLoveGithubWeb.infrastructure.rank;

import com.poc.iLoveGithubWeb.domain.rank.SourceRank;
import com.poc.iLoveGithubWeb.domain.rank.UserRank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class KoreanRankRepository {

    private final EntityManager em;

    public List<UserRank> findKoreanUserAll(String type, Boolean isKorean){
        String query = "select u from UserRank u where u.type = :type and u.isKorean = :isKorean order by u.stargazersCount desc";
        return em.createQuery(query, UserRank.class)
                .setParameter("type", type)
                .setParameter("isKorean", isKorean)
                .getResultList();
    }

    public List<SourceRank> findSourceRankAll(){

        String query = "select s from SourceRank s where s.isKorean = :isKorean order by s.stargazersCount desc";
        return em.createQuery(query, SourceRank.class)
                .setParameter("isKorean", true)
                .getResultList();
    }


}
