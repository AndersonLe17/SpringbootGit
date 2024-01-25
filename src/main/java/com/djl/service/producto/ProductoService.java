package com.djl.service.producto;

import com.djl.domain.producto.dto.ProductoSaveReq;
import com.djl.domain.producto.dto.ProductoUpdateReq;
import com.djl.domain.producto.dto.ProductoRes;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    Optional<ProductoRes> save(ProductoSaveReq productoSaveReq);

    List<ProductoRes> findAll();

    Optional<ProductoRes> findById(Long pid);

    Optional<ProductoRes> update(Long pid, ProductoUpdateReq productoUpdateReq);

    void delete(Long pid);
}
