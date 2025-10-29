package com.example.FARMACIA.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FARMACIA.Model.Categorias;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {
    @GetMapping
    public Categorias listarCategorias() {
        return new Categorias(1L, "Antibioticos");
    }
}