package com.kurly.demo.service;

import com.kurly.demo.domain.Goods;
import com.kurly.demo.repository.GoodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class GoodsServie {

    private final GoodsRepository goodsRepository;

    @Transactional
    public void saveGoods(Goods goods) {
        goodsRepository.save(goods);
    }

    public Goods findOne(Long goodsId){
        return goodsRepository.findOne(goodsId);
    }

    public List<Goods> findPaging(int n){
        return goodsRepository.findPaging(n);
    }
}
