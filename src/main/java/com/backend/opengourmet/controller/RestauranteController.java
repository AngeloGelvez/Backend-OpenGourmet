package com.backend.opengourmet.controller;

import com.backend.opengourmet.assets.ResponseApi;
import com.backend.opengourmet.repository.entity.RestauranteEntity;
import com.backend.opengourmet.service.RestauranteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @GetMapping()
    public ResponseEntity<Object> todosRestaurantes() {
        try{
            ResponseApi.setResponseJson("Estado", HttpStatus.OK);
            ResponseApi.setResponseJson("Mensaje", "Restaurantes listas");
            ResponseApi.setResponseJson("Contenido", this.restauranteService.todos());

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
    public ResponseEntity<Object> restaurantePorId(@PathVariable Long id) {
        try {
            ResponseApi.setResponseJson("Estado", HttpStatus.OK);
            ResponseApi.setResponseJson("Mensaje", "Restaurante ID");
            ResponseApi.setResponseJson("Contenido", this.restauranteService.buscarPorId(id));

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ResponseApi.responseJson);
        }catch(Error err) {
            ResponseApi.setResponseJson("Estado", HttpStatus.EXPECTATION_FAILED);
            ResponseApi.setResponseJson("Mensaje", err.getMessage());
            ResponseApi.setResponseJson("Contenido", null);

            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(ResponseApi.responseJson);
        }
    }

    @PostMapping()
    public ResponseEntity<Object> crearRestaurante(@RequestBody RestauranteEntity restauranteEntity) {
        try {
            ResponseApi.setResponseJson("Estado", HttpStatus.CREATED);
            ResponseApi.setResponseJson("Mensaje", "El restaurante ha sido creado éxitosamente.");
            ResponseApi.setResponseJson("Contenido", this.restauranteService.crear(restauranteEntity));

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(ResponseApi.responseJson);
        }catch(Error err) {
            ResponseApi.setResponseJson("Estado", HttpStatus.EXPECTATION_FAILED);
            ResponseApi.setResponseJson("Mensaje", err.getMessage());
            ResponseApi.setResponseJson("Contenido", null);

            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(ResponseApi.responseJson);
        }
    }

    @PutMapping()
    public ResponseEntity<Object> actualizarRestaurante(@RequestBody RestauranteEntity restauranteEntity) {
        try {
            ResponseApi.setResponseJson("Estado", HttpStatus.OK);
            ResponseApi.setResponseJson("Mensaje", "El restaurante ha sido actualizado éxitosamente.");
            ResponseApi.setResponseJson("Contenido", this.restauranteService.actualizar(restauranteEntity));

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
    public ResponseEntity<Object> eliminarRestaurantePorId(@PathVariable Long id) {
        try {
            ResponseApi.setResponseJson("Estado", HttpStatus.OK);
            ResponseApi.setResponseJson("Mensaje", this.restauranteService.eliminarPorId(id));
            ResponseApi.setResponseJson("Contenido", null);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(ResponseApi.responseJson);
        }catch(Error err) {
            ResponseApi.setResponseJson("Estado", HttpStatus.EXPECTATION_FAILED);
            ResponseApi.setResponseJson("Mensaje", err.getMessage());
            ResponseApi.setResponseJson("Contenido", null);

            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(ResponseApi.responseJson);
        }
    }
}
