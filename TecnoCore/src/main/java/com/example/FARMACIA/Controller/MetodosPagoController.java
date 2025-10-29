package com.example.FARMACIA.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FARMACIA.Model.Metodos_pago;
import com.example.FARMACIA.Repository.MetodosPagoRepository;

@RestController
@RequestMapping("/metodos-pago")
public class MetodosPagoController {

    @Autowired
    private MetodosPagoRepository metodosPagoRepository;

    @GetMapping
    public String listarMetodosPago() {
        return "Listado de métodos de pago";
    }

    @PostMapping
    public Metodos_pago agregarMetodoPago(@RequestBody Metodos_pago nuevoMetodo) {
        // Guardar el método de pago en la base de datos
        return metodosPagoRepository.save(nuevoMetodo);
    }
}
