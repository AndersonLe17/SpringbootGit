package com.djl.service.producto;

import com.djl.domain.producto.Producto;
import com.djl.domain.producto.dto.ProductoSaveReq;
import com.djl.domain.producto.dto.ProductoUpdateReq;
import com.djl.domain.producto.dto.ProductoRes;
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
    public Optional<ProductoRes> save(ProductoSaveReq productoSaveReq) {
        Producto producto = modelMapper.map(productoSaveReq, Producto.class);
        producto = productoRepository.save(producto);

        return Optional.ofNullable(modelMapper.map(producto, ProductoRes.class));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductoRes> findAll() {
        return productoRepository.findAll().stream()
                .map(producto -> modelMapper.map(producto, ProductoRes.class))
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProductoRes> findById(Long pid) {
        Optional<Producto> producto = productoRepository.findById(pid);

        if (producto.isPresent()) return Optional.of(modelMapper.map(producto.get(), ProductoRes.class));

        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<ProductoRes> update(Long pid, ProductoUpdateReq productoUpdateReq) {
        Optional<Producto> productoOpt = productoRepository.findById(pid);

        if (productoOpt.isPresent()) {
            Producto producto = productoOpt.get();
            modelMapper.map(productoUpdateReq, producto);

            producto = productoRepository.save(producto);
            return Optional.of(modelMapper.map(producto, ProductoRes.class));
        }

        return Optional.empty();
    }

    @Override
    @Transactional
    public void delete(Long pid) {
        productoRepository.deleteById(pid);
    }
}
