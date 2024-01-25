package com.djl.controller;

import com.djl.config.exceptions.ResourceNotFoundException;
import com.djl.domain.producto.dto.ProductoSaveReq;
import com.djl.domain.producto.dto.ProductoUpdateReq;
import com.djl.domain.producto.dto.ProductoRes;
import com.djl.service.producto.ProductoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/producto")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoService productoService;

    @GetMapping("/")
    public ResponseEntity<?> findAllProductos() {
        return ResponseEntity.ok(productoService.findAll());
    }

    @GetMapping("/{pid}")
    public ResponseEntity<?> findProductoById(@PathVariable("pid") Long pid) {
        Optional<ProductoRes> productoResponse = productoService.findById(pid);

        if (productoResponse.isPresent()) return ResponseEntity.ok(productoResponse.get());

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<?> saveProducto(@Valid @RequestBody ProductoSaveReq productoSaveReq) {
        ProductoRes response = productoService.save(productoSaveReq).orElseThrow();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{pid}")
    public ResponseEntity<?> updateProducto(@PathVariable("pid") Long pid,
                                           @Valid @RequestBody ProductoUpdateReq productoUpdateReq) {
        Optional<ProductoRes> productoResponse = productoService.update(pid, productoUpdateReq);

        if (productoResponse.isPresent()) return ResponseEntity.ok(productoResponse.get());

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{pid}")
    public ResponseEntity<?> deleteProducto(@PathVariable("pid") Long pid) {
        Optional<ProductoRes> productoResponse = productoService.findById(pid);

        if (productoResponse.isPresent()) {
            productoService.delete(pid);
            return ResponseEntity.noContent().build();
        }

        throw new ResourceNotFoundException("Producto", "ID", pid);
    }

}
