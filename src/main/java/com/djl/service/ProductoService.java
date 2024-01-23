package com.djl.service;

import com.djl.dto.request.ProductoRequest;
import com.djl.dto.response.ProductoResponse;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    Optional<ProductoResponse> save(ProductoRequest productoRequest);

    List<ProductoResponse> findAll();

    Optional<ProductoResponse> findById(Long pid);

    Optional<ProductoResponse> update(Long pid, ProductoRequest productoRequest);

    void delete(Long pid);
}
