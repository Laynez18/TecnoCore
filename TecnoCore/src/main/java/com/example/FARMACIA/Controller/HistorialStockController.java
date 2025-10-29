package com.example.FARMACIA.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/historial-stock")
public class HistorialStockController {
   @GetMapping
   public String listarHistorialStock() {
       return "Listado de historial de stock";
   }
}
