package com.example.FARMACIA.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productos")
public class ProductosController {
   @GetMapping  
    public String listarProductos() {
          return "Listado de productos";
     }
}
