package com.example.demo.Service;

import com.example.demo.Model.ProductoModel;
import com.example.demo.Repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // Obtener todos los productos
    public List<ProductoModel> obtenerProductos() {
        return productoRepository.findAll();
    }

    // Obtener un producto por ID
    public Optional<ProductoModel> obtenerProductoPorId(Long id) {
        return productoRepository.findById(id);
    }

    // Guardar un nuevo producto o actualizar uno existente
    public ProductoModel guardarProducto(ProductoModel producto) {
        return productoRepository.save(producto);
    }

    // Eliminar un producto por ID
    public boolean eliminarProducto(Long id) {
        try {
            productoRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
