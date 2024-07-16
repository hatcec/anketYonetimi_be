package com.example.AnketYonetimi.core.utilities.mapping;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
    ModelMapper forRequest();
    ModelMapper forResponse();
}
