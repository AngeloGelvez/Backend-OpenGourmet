package com.backend.opengourmet.controller;

import com.backend.opengourmet.assets.ResponseApi;
import com.backend.opengourmet.repository.entity.MesaEntity;
import com.backend.opengourmet.service.MesaService;
import com.backend.opengourmet.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/mesas")
public class MesaController {

    @Autowired
    private MesaService mesaService;

    @Autowired
    private RestauranteService restauranteService;

    @GetMapping()
    public ResponseEntity<Object> todasMesas() {
        try{
            ResponseApi.setResponseJson("Estado", HttpStatus.OK);
            ResponseApi.setResponseJson("Contenido", this.mesaService.todos());

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ResponseApi.responseJson);
        }catch (Error err) {
            ResponseApi.setResponseJson("Estado", HttpStatus.EXPECTATION_FAILED);
            ResponseApi.setResponseJson("Contenido", err.getMessage());

            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(ResponseApi.responseJson);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> mesaPorId(@PathVariable Long id) {
        try{
            ResponseApi.setResponseJson("Estado", HttpStatus.OK);
            ResponseApi.setResponseJson("Contenido", this.mesaService.buscarPorId(id));

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ResponseApi.responseJson);
        }catch (Error err) {
            ResponseApi.setResponseJson("Estado", HttpStatus.EXPECTATION_FAILED);
            ResponseApi.setResponseJson("Contenido", err.getMessage());

            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(ResponseApi.responseJson);
        }
    }

    @PostMapping("/{idRestaurante}")
    public ResponseEntity<Object> crearMesa(@PathVariable Long idRestaurante, @RequestBody MesaEntity mesaEntity) {
        try {
            mesaEntity.setRestauranteEntity(this.restauranteService.buscarPorId(idRestaurante));
            ResponseApi.setResponseJson("Estado", HttpStatus.CREATED);
            ResponseApi.setResponseJson("Mensaje", "La mesa ha sido creada éxitosamente.");
            ResponseApi.setResponseJson("Contenido", this.mesaService.crear(mesaEntity));

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(ResponseApi.responseJson);
        }catch(Error err) {
            ResponseApi.setResponseJson("Estado", HttpStatus.EXPECTATION_FAILED);
            ResponseApi.setResponseJson("Contenido", err.getMessage());

            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(ResponseApi.responseJson);
        }
    }

    @PutMapping()
    public ResponseEntity<Object> actualizarMesa(@RequestBody MesaEntity mesaEntity) {
        try {
            ResponseApi.setResponseJson("Estado", HttpStatus.OK);
            ResponseApi.setResponseJson("Mensaje", "La mesa ha sido actualizada éxitosamente.");
            ResponseApi.setResponseJson("Contenido", this.mesaService.actualizar(mesaEntity));

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ResponseApi.responseJson);
        }catch(Error err) {
            ResponseApi.setResponseJson("Estado", HttpStatus.EXPECTATION_FAILED);
            ResponseApi.setResponseJson("Contenido", err.getMessage());

            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(ResponseApi.responseJson);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminarMesaPorId(@PathVariable Long id) {
        try{
            ResponseApi.setResponseJson("Estado", HttpStatus.OK);
            ResponseApi.setResponseJson("Mensaje", this.mesaService.eliminarPorId(id));

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ResponseApi.responseJson);
        }catch (Error err) {
            ResponseApi.setResponseJson("Estado", HttpStatus.EXPECTATION_FAILED);
            ResponseApi.setResponseJson("Contenido", err.getMessage());

            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(ResponseApi.responseJson);
        }
    }
}
