package com.prog.fx.producto;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.prog.fx.FxApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ProductoController {

    ConfigurableApplicationContext context = FxApplication.context;
    ProductoService productoService = context.getBean(ProductoService.class);

    private List<Producto> productosList = new ArrayList<>();

    public List<Producto> getProductsList() {
        return productosList;
    }

    public void saveToList(File selectedFile) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Producto> productos = objectMapper.readValue(selectedFile, new TypeReference<List<Producto>>() {});
            productosList.addAll(productos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteFromList(int id) {
        productosList.remove(id);
    }

    public void updateFromList(long id, int codigo, String nombre, String cantidad, String descripcion) {
        for(Producto producto : productosList) {
            if(producto.getId() == id) {
                producto.setCodigo(codigo);
                producto.setNombre(nombre);
                producto.setCantidad(Integer.parseInt(cantidad));
                producto.setDescripcion(descripcion);
                break;
            }
        }
    }

    public void exportToJson(File selectedFile) {

        List<Producto> productosToExport = productosList.stream()
                .map(p -> new Producto(p.getCodigo(), p.getNombre(), p.getCantidad(), p.getDescripcion()))
                .collect(Collectors.toList());

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(selectedFile, productosToExport);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveProductOnList(int codigo, String nombre, int cantidad, String descripcion) {
        Producto producto = new Producto(codigo, nombre, cantidad, descripcion);
        productosList.add(producto);
    }
}