package com.prog.fx.producto;

import javafx.fxml.Initializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class productoController {

    @Autowired
    private ProductoRepository productoRepository;

    public void guardarProducto(Productos producto) {
        productoRepository.save(producto);
    }

}
