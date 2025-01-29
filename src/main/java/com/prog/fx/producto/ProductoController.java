package com.prog.fx.producto;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ProductoController {

    private List<Producto> productosList = new ArrayList<>();

    public void init() {
        loadProductosFromJson();
    }

    public List<Producto> getProductosList() {
        return productosList;
    }

    private void loadProductosFromJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            File jsonFile = new File("path/to/your/jsonfile.json");
            productosList = objectMapper.readValue(jsonFile, new TypeReference<List<Producto>>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addProducto(Producto producto) {
        productosList.add(producto);
    }
}