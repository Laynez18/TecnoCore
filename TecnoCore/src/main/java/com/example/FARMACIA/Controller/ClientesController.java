package com.example.FARMACIA.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClientesController {
    @GetMapping
    public String listarClientes() {
        return "Listado de clientes";
    }
}
