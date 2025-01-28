package com.prog.fx.producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class productoController {

    @Autowired
    private ProductoRepository productoRepository;

    public void guardarProducto(Productos producto) {
        productoRepository.save(producto);
    }

}
