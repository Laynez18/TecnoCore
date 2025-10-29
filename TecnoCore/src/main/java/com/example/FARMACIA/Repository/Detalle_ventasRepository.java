package com.example.FARMACIA.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FARMACIA.Model.Detalle_ventas;

public interface  Detalle_ventasRepository extends JpaRepository<Detalle_ventas, Long> {
    List<Detalle_ventas> findByVentaId(Long idVenta);
}
