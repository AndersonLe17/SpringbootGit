package com.djl.controller;

import com.djl.dto.request.ProductoRequest;
import com.djl.dto.response.ProductoResponse;
import com.djl.service.ProductoService;
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
        Optional<ProductoResponse> productoResponse = productoService.findById(pid);

        if (productoResponse.isPresent()) return ResponseEntity.ok(productoResponse.get());

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/")
    public ResponseEntity<?> saveProducto(@RequestBody ProductoRequest productoRequest) {
        ProductoResponse response = productoService.save(productoRequest).orElseThrow();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{pid}")
    public ResponseEntity<?> updateProduct(@PathVariable("pid") Long pid,
                                           @RequestBody ProductoRequest productoRequest) {
        Optional<ProductoResponse> productoResponse = productoService.update(pid, productoRequest);

        if (productoResponse.isPresent()) return ResponseEntity.ok(productoResponse.get());

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{pid}")
    public ResponseEntity<?> deleteProduct(@PathVariable("pid") Long pid) {
        Optional<ProductoResponse> productoResponse = productoService.findById(pid);

        if (productoResponse.isPresent()) {
            productoService.delete(pid);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

}
