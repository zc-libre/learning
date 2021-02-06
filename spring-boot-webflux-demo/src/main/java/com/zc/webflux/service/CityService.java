package com.zc.webflux.service;

import com.zc.webflux.dao.CityRepository;
import com.zc.webflux.pojo.City;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author zhao.cheng
 * @date 2020/10/12 9:32
 */
@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public Mono<Long> save(City city) {
        return Mono.create(cityMonoSink -> cityMonoSink.success(cityRepository.save(city)));
    }

    public Mono<City> findById(Long id) {
        return Mono.justOrEmpty(cityRepository.findCityById(id));
    }

    public Flux<City> findAllCity() {
        return Flux.fromIterable(cityRepository.findAll());
    }
}
