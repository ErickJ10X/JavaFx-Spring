package com.prog.fx.producto;

import javafx.fxml.Initializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public class productoController implements Initializable {

    @Autowired
    private ProductoRepository productoRepository;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
