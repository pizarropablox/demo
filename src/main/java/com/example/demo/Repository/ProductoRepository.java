package com.example.demo.Repository;

import com.example.demo.Model.ProductoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoModel, Long> {
    // Aquí puedes definir métodos de consulta personalizados si los necesitas
}
