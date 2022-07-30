package com.poc.iLoveGithubWeb.infrastructure.rank;

import com.poc.iLoveGithubWeb.domain.rank.UserRank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class KoreanRankRepository {

    private final EntityManager em;

    public List<UserRank> findKoreanUserAll(){
       return em.createQuery("select u from UserRank u where u.isKorean = :isKorean", UserRank.class)
               .setParameter("isKorean", true)
                .getResultList();
    }

}
