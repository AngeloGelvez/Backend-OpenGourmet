package com.backend.opengourmet.controller;

import com.backend.opengourmet.assets.ResponseApi;
import com.backend.opengourmet.repository.entity.ResenaEntity;
import com.backend.opengourmet.service.ResenaService;
import com.backend.opengourmet.service.RestauranteService;
import com.backend.opengourmet.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resenas")
public class ResenaController {

    @Autowired
    private ResenaService resenaService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RestauranteService restauranteService;

    @GetMapping()
    public ResponseEntity<Object> todasResenas() {
        try{
            ResponseApi.setResponseJson("Estado", HttpStatus.OK);
            ResponseApi.setResponseJson("Mensaje", "Resenas Listas");
            ResponseApi.setResponseJson("Contenido", this.resenaService.todos());

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

    @PostMapping("/{idUsuario}/{idRestaurante}")
    public ResponseEntity<Object> crearResena(@PathVariable Long idUsuario, @PathVariable Long idRestaurante, @RequestBody ResenaEntity resena) {
        try{
            resena.setUsuarioEntity(this.usuarioService.buscarPorId(idUsuario));
            resena.setRestauranteEntity(this.restauranteService.buscarPorId(idRestaurante));
            ResponseApi.setResponseJson("Estado", HttpStatus.CREATED);
            ResponseApi.setResponseJson("Mensaje", "La Resena ha sido creada éxitosamente.");
            ResponseApi.setResponseJson("Contenido", this.resenaService.crear(resena));

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
    public ResponseEntity<Object> crearResena(@RequestBody ResenaEntity resena) {
        try{
            ResponseApi.setResponseJson("Estado", HttpStatus.OK);
            ResponseApi.setResponseJson("Mensaje", "La Resena ha sido actualizada éxitosamente.");
            ResponseApi.setResponseJson("Contenido", this.resenaService.actualizar(resena));

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
    public ResponseEntity<Object> eliminarResenaPorId(@PathVariable Long id) {
        try {
            ResponseApi.setResponseJson("Estado", HttpStatus.OK);
            ResponseApi.setResponseJson("Mensaje", this.resenaService.eliminarPorId(id));
            ResponseApi.setResponseJson("Contenido", null);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ResponseApi.responseJson);
        } catch (Error err) {
            ResponseApi.setResponseJson("Estado", HttpStatus.EXPECTATION_FAILED);
            ResponseApi.setResponseJson("Mensaje", err.getMessage());
            ResponseApi.setResponseJson("Contenido", null);

            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(ResponseApi.responseJson);
        }

    }
}
