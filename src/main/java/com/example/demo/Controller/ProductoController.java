package com.example.demo.Controller;

import com.example.demo.Model.ProductoModel;
import com.example.demo.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // Obtener todos los productos
    @GetMapping
    public List<ProductoModel> obtenerProductos() {
        return productoService.obtenerProductos();
    }

    // Obtener un producto por ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductoModel> obtenerProductoPorId(@PathVariable Long id) {
        Optional<ProductoModel> producto = productoService.obtenerProductoPorId(id);
        return producto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear un nuevo producto
    @PostMapping
    public ResponseEntity<ProductoModel> crearProducto(@RequestBody ProductoModel producto) {
        ProductoModel nuevoProducto = productoService.guardarProducto(producto);
        return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
    }

    // Actualizar un producto existente
    @PutMapping("/{id}")
    public ResponseEntity<ProductoModel> actualizarProducto(@PathVariable Long id, @RequestBody ProductoModel producto) {
        if (!productoService.obtenerProductoPorId(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        producto.setId(id);
        ProductoModel productoActualizado = productoService.guardarProducto(producto);
        return ResponseEntity.ok(productoActualizado);
    }

    // Eliminar un producto
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        if (productoService.eliminarProducto(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
