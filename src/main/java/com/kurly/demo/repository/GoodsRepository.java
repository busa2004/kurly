package com.kurly.demo.repository;

import com.kurly.demo.domain.Goods;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class GoodsRepository {
    private final EntityManager em;

    public void save(Goods goods) {
            em.persist(goods);
    }

    public Goods findOne(Long id){
        return em.find(Goods.class,id);
    }

    public List<Goods> findPaging(int n){
        return em.createQuery("select g from Goods g",Goods.class)
                .setFirstResult(0)
                .setMaxResults(n)
                .getResultList();
    }
}
