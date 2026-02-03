package com.backend.opengourmet.controller;

import com.backend.opengourmet.assets.ResponseApi;
import com.backend.opengourmet.repository.entity.UsuarioEntity;
import com.backend.opengourmet.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping()
    public ResponseEntity<Object> todosUsuarios() {
        try{
            ResponseApi.setResponseJson("Estado", HttpStatus.OK);
            ResponseApi.setResponseJson("Contenido", this.usuarioService.todos());

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
    public ResponseEntity<Object> usuarioPorId(@PathVariable Long id) {
        try {
            ResponseApi.setResponseJson("Estado", HttpStatus.OK);
            ResponseApi.setResponseJson("Contenido", this.usuarioService.buscarPorId(id));

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

    @PostMapping()
    public ResponseEntity<Object> crearUsuario(@RequestBody UsuarioEntity usuarioEntity) {
        try {
            ResponseApi.setResponseJson("Estado", HttpStatus.CREATED);
            ResponseApi.setResponseJson("Mensaje", "El usuario ha sido creado éxitosamente.");
            ResponseApi.setResponseJson("Contenido", this.usuarioService.crear(usuarioEntity));

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
    public ResponseEntity<Object> actualizarUsuario(@RequestBody UsuarioEntity usuarioEntity) {
        try {
            ResponseApi.setResponseJson("Estado", HttpStatus.OK);
            ResponseApi.setResponseJson("Mensaje", "El usuario ha sido actualizado éxitosamente.");
            ResponseApi.setResponseJson("Contenido", this.usuarioService.actualizar(usuarioEntity));

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

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminarUsuarioPorId(@PathVariable Long id) {
        try {
            ResponseApi.setResponseJson("Estado", HttpStatus.OK);
            ResponseApi.setResponseJson("Mensaje", this.usuarioService.eliminarPorId(id));

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
}
