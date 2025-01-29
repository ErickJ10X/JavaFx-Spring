package com.prog.fx.producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    public Optional<Producto> findById(Long id) {
        return productoRepository.findById(id);
    }

    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    public void deleteById(Long id) {
        productoRepository.deleteById(id);
    }
}