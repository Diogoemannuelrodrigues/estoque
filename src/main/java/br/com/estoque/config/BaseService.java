package br.com.estoque.config;

import org.modelmapper.ModelMapper;

public class BaseService {

    public ModelMapper getConverter() {
        return new ModelMapper();
    }
}
