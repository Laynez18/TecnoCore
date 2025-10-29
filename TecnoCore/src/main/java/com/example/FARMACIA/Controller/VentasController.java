package com.example.FARMACIA.Controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FARMACIA.Model.Clientes;
import com.example.FARMACIA.Model.Metodos_pago;
import com.example.FARMACIA.Model.Usuarios;
import com.example.FARMACIA.Model.Ventas;
import com.example.FARMACIA.Repository.ClientesRepository;
import com.example.FARMACIA.Repository.MetodosPagoRepository;
import com.example.FARMACIA.Repository.UsuarioRepository;
import com.example.FARMACIA.Repository.VentasRepository;

@RestController
@RequestMapping("/ventas")
public class VentasController {

    @Autowired
    private VentasRepository ventasRepository;
    @Autowired
    private ClientesRepository clientesRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MetodosPagoRepository metodosPagoRepository;

    @GetMapping
    public Ventas listarVentas() {
        // Crear datos de ejemplo
        Clientes cliente = new Clientes(); // Asegúrate de que Clientes tenga un constructor vacío o valores de prueba
        cliente.setId(1L);
        cliente.setNombre("franno");
        cliente.setApellido("gomez");
        cliente.setTelefono("987654321");

        Usuarios usuario = new Usuarios(); // Asegúrate de que Usuarios tenga un constructor vacío o valores de prueba
        usuario.setId(1L);
        usuario.setNombre("Usuario Ejemplo");
        usuario.setEmail("usuario@example.com");
        usuario.setPassword("password");
        usuario.setRol("CLIENTE");
        usuario.setFecha_registro(LocalDate.EPOCH);

        Metodos_pago metodoPago = new Metodos_pago(); // Asegúrate de que Metodos_pago tenga un constructor vacío o valores de prueba
        metodoPago.setId(1L);
        metodoPago.setNombre("Efectivo");

        return new Ventas(cliente, usuario, metodoPago, LocalDateTime.now(), new BigDecimal("100.50"));
    }

    @PostMapping
    public ResponseEntity<?> crearVenta(@RequestBody Ventas venta) {
        if (venta.getCliente() == null || venta.getCliente().getId() == null) {
            return ResponseEntity.badRequest().body("El cliente es obligatorio.");
        }
        if (venta.getUsuario() == null || venta.getUsuario().getId() == null) {
            return ResponseEntity.badRequest().body("El usuario es obligatorio.");
        }
        if (venta.getMetodoPago() == null || venta.getMetodoPago().getId() == null) {
            return ResponseEntity.badRequest().body("El método de pago es obligatorio.");
        }

        // Cargar los objetos relacionados desde la base de datos
        Clientes cliente = clientesRepository.findById(venta.getCliente().getId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado."));
        Usuarios usuario = usuarioRepository.findById(venta.getUsuario().getId())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado."));
        Metodos_pago metodoPago = metodosPagoRepository.findById(venta.getMetodoPago().getId())
                .orElseThrow(() -> new RuntimeException("Método de pago no encontrado."));

        // Asignar los objetos cargados a la venta
        venta.setCliente(cliente);
        venta.setUsuario(usuario);
        venta.setMetodoPago(metodoPago);

        // Guardar la venta en la base de datos
        Ventas nuevaVenta = ventasRepository.save(venta);
        return ResponseEntity.ok(nuevaVenta);
    }
}
