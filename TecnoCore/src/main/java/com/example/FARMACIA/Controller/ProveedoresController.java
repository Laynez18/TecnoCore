package com.example.FARMACIA.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proveedores")
public class ProveedoresController {
    @GetMapping
    public String listarProveedores() {
        return "Listado de proveedores";
    }
}
