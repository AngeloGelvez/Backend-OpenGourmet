package com.backend.opengourmet.controller;

import com.backend.opengourmet.assets.ResponseApi;
import com.backend.opengourmet.repository.entity.ReservaEntity;
import com.backend.opengourmet.service.MesaService;
import com.backend.opengourmet.service.ReservaService;
import com.backend.opengourmet.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resevas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private MesaService mesaService;

    @GetMapping()
    public ResponseEntity<Object> todasReservas() {
        try {
            ResponseApi.setResponseJson("Estado", HttpStatus.OK);
            ResponseApi.setResponseJson("Mensaje", "Reservas listas");
            ResponseApi.setResponseJson("Contenido", this.reservaService.todos());

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ResponseApi.responseJson);
        }catch (Error err) {
            ResponseApi.setResponseJson("Estado", HttpStatus.EXPECTATION_FAILED);
            ResponseApi.setResponseJson("Mensaje", err.getMessage());
            ResponseApi.setResponseJson("Contenido", null);

            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(ResponseApi.responseJson);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> reservaPorId(@PathVariable Long id) {
        try {
            ResponseApi.setResponseJson("Estado", HttpStatus.OK);
            ResponseApi.setResponseJson("Mensaje", "Reserva ID");
            ResponseApi.setResponseJson("Contenido", this.reservaService.buscarPorId(id));

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ResponseApi.responseJson);
        }catch (Error err) {
            ResponseApi.setResponseJson("Estado", HttpStatus.EXPECTATION_FAILED);
            ResponseApi.setResponseJson("Mensaje", err.getMessage());
            ResponseApi.setResponseJson("Contenido", null);

            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(ResponseApi.responseJson);
        }
    }

    @PostMapping("/{idUsuario}/{idMesa}")
    public ResponseEntity<Object> crearReserva(@PathVariable Long idUsuario, @PathVariable Long idMesa, @RequestBody ReservaEntity reserva) {
        try {
            reserva.setUsuarioEntity(this.usuarioService.buscarPorId(idUsuario));
            reserva.setMesaEntity(this.mesaService.buscarPorId(idMesa));
            ResponseApi.setResponseJson("Estado", HttpStatus.CREATED);
            ResponseApi.setResponseJson("Mensaje", "La Reserva ha sido creada éxitosamente.");
            ResponseApi.setResponseJson("Contenido", this.reservaService.crear(reserva));

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(ResponseApi.responseJson);
        }catch (Error err) {
            ResponseApi.setResponseJson("Estado", HttpStatus.EXPECTATION_FAILED);
            ResponseApi.setResponseJson("Mensaje", err.getMessage());
            ResponseApi.setResponseJson("Contenido", null);

            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(ResponseApi.responseJson);
        }
    }

    @PutMapping()
    public ResponseEntity<Object> crearReserva(@RequestBody ReservaEntity reserva) {
        try {
            ResponseApi.setResponseJson("Estado", HttpStatus.OK);
            ResponseApi.setResponseJson("Mensaje", "La Reserva ha sido actualizada éxitosamente.");
            ResponseApi.setResponseJson("Contenido", this.reservaService.actualizar(reserva));

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ResponseApi.responseJson);
        }catch (Error err) {
            ResponseApi.setResponseJson("Estado", HttpStatus.EXPECTATION_FAILED);
            ResponseApi.setResponseJson("Mensaje", err.getMessage());
            ResponseApi.setResponseJson("Contenido", null);

            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(ResponseApi.responseJson);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> EliminarReservaPorId(@PathVariable Long id) {
        try {
            ResponseApi.setResponseJson("Estado", HttpStatus.OK);
            ResponseApi.setResponseJson("Mensaje", this.reservaService.eliminarPorId(id));
            ResponseApi.setResponseJson("Contenido", null);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ResponseApi.responseJson);
        }catch (Error err) {
            ResponseApi.setResponseJson("Estado", HttpStatus.EXPECTATION_FAILED);
            ResponseApi.setResponseJson("Mensaje", err.getMessage());
            ResponseApi.setResponseJson("Contenido", null);

            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(ResponseApi.responseJson);
        }
    }
}
