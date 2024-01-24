package com.djl.service;

import com.djl.domain.Producto;
import com.djl.dto.request.ProductoRequest;
import com.djl.dto.response.ProductoResponse;
import com.djl.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public Optional<ProductoResponse> save(ProductoRequest productoRequest) {
        Producto producto = modelMapper.map(productoRequest, Producto.class);
        producto = productoRepository.save(producto);

        return Optional.ofNullable(modelMapper.map(producto, ProductoResponse.class));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductoResponse> findAll() {
        return productoRepository.findAll().stream()
                .map(producto -> modelMapper.map(producto, ProductoResponse.class))
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProductoResponse> findById(Long pid) {
        Optional<Producto> producto = productoRepository.findById(pid);

        if (producto.isPresent()) return Optional.of(modelMapper.map(producto.get(), ProductoResponse.class));

        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<ProductoResponse> update(Long pid, ProductoRequest productoRequest) {
        Optional<Producto> productoOpt = productoRepository.findById(pid);

        if (productoOpt.isPresent()) {
            Producto producto = productoOpt.get();
            modelMapper.map(productoRequest, producto);

            producto = productoRepository.save(producto);
            return Optional.of(modelMapper.map(producto, ProductoResponse.class));
        }

        return Optional.empty();
    }

    @Override
    @Transactional
    public void delete(Long pid) {
        productoRepository.deleteById(pid);
    }
}
