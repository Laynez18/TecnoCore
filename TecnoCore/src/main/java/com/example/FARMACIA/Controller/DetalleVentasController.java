package com.example.FARMACIA.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/detalle-ventas")
public class DetalleVentasController {
    @GetMapping
    public String listarDetalleVentas() {
        return "Listado de detalles de ventas";
    }
}
