package com.grandvauxc.companyutility.mapper;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class MapperService {

    private final ModelMapper mapper;

    @Autowired
    public MapperService(List<Converter<?, ?>> converters){
        super();
        this.mapper = new ModelMapper();
        this.mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        converters.forEach(this.mapper::addConverter);
    }

    public <S, D> D map(S source, Class<D> clazz) {
        return this.mapper.map(source, clazz);
    }

    public <S, D> List<D> map(Collection<S> source, Class<D> clazz) {
        return source.stream().map(src -> this.map(src, clazz))
                .collect(Collectors.toList());
    }
}
