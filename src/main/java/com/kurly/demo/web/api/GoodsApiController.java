package com.kurly.demo.web.api;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.kurly.demo.domain.Goods;
import com.kurly.demo.domain.GoodsV2;
import com.kurly.demo.service.GoodsServie;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class GoodsApiController {

    private final MessageSource messageSource;
    private final GoodsServie goodsServie;

    //200 : 성공
    @GetMapping("/v1/goods")
    public MappingJacksonValue retrieveAdminAllGoods() {
        List<Goods> goods = goodsServie.findAll();

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("id","name","img","price");

        FilterProvider filters = new SimpleFilterProvider().addFilter("GoodsInfo",filter);

        MappingJacksonValue mapping = new MappingJacksonValue(goods);
        mapping.setFilters(filters);

        return mapping;
    }

    //200 : 성공
    //404 : 존재하지 않는 값
    @GetMapping("/v1/goods/{id}") // URI
//    @GetMapping(value = "/goods/{id}/", params = "version = 1") // PARAMETER
//    @GetMapping(value = "/goods/{id}", headers = "X-API-VERSION=1") // HEADER
//    @GetMapping(value = "/goods/{id}", produces = "application/vnd.company.appv1+json") // MINE
    public MappingJacksonValue retrieveGoods(@PathVariable Long id) {
        Goods goods = goodsServie.findOne(id);
        if(goods == null){

            throw new GoodsNotFoundException(String.format("ID[%s] not found", id));
        }

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("id","name","img","price");

        FilterProvider filters = new SimpleFilterProvider().addFilter("GoodsInfo",filter);

        MappingJacksonValue mapping = new MappingJacksonValue(goods);
        mapping.setFilters(filters);

        return mapping;
    }

    @GetMapping("/v2/goods/{id}")
    //@GetMapping(value = "/goods/{id}/", params = "version = 2")
    //@GetMapping(value = "/goods/{id}", headers = "X-API-VERSION=2")
    //@GetMapping(value = "/goods/{id}", produces = "application/vnd.company.appv2+json")
    public MappingJacksonValue retrieveGoodsV2(@PathVariable Long id) {
        Goods goods = goodsServie.findOne(id);
        if(goods == null){

            throw new GoodsNotFoundException(String.format("ID[%s] not found", id));
        }

        GoodsV2 goodsV2 = new GoodsV2();
        BeanUtils.copyProperties(goods,goodsV2);
        goodsV2.setStorage("상온");

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter
                .filterOutAllExcept("id","name","img","price","storage");

        FilterProvider filters = new SimpleFilterProvider().addFilter("GoodsInfoV2",filter);

        MappingJacksonValue mapping = new MappingJacksonValue(goodsV2);
        mapping.setFilters(filters);

        return mapping;
    }

    //201 : 성공
    @PostMapping("/v1/goods")
    public ResponseEntity<Goods> createGoods(@Valid @RequestBody Goods goods) {
        Goods savedGoods = goodsServie.saveGoods(goods);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedGoods.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/hello")
    public String hello(@RequestHeader(name="Accept-Language",required=false) Locale locale){
        return messageSource.getMessage("greeting.message",null,locale);
    }


}
