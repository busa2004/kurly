package com.kurly.demo.service;

import com.kurly.demo.domain.Goods;
import com.kurly.demo.repository.GoodsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GoodsServie {

    private final GoodsRepository goodsRepository;

    @Transactional
    public Goods saveGoods(Goods goods) {
        return goodsRepository.save(goods);
    }

    public Goods findOne(Long goodsId){
        return goodsRepository.findOne(goodsId);
    }

    public List<Goods> findAll(){return goodsRepository.findAll();}
    public List<Goods> findPaging(int n){
        return goodsRepository.findPaging(n);
    }

    public void deleteById(Long id) {
        goodsRepository.deleteById(id);
    }
}
