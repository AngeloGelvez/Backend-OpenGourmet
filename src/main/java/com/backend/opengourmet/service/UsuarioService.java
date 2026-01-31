package com.backend.opengourmet.service;

import com.backend.opengourmet.repository.UsuarioRepository;
import com.backend.opengourmet.repository.entity.UsuarioEntity;
import com.backend.opengourmet.service.impl.ServiceCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements ServiceCrud<UsuarioEntity> {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public List<UsuarioEntity> todos() {
        List<UsuarioEntity> listUsuario = this.usuarioRepository.findAll();

        if(!listUsuario.isEmpty()) {
            return listUsuario;
        }else {
            throw new Error("La lista esta vacia, no hay nada para mostrar");
        }
    }

    @Override
    public UsuarioEntity buscarPorId(Long id) {
        Optional<UsuarioEntity> userById = this.usuarioRepository.findById(id);

        if(userById.isPresent()) {
            return userById.get();
        }else {
            throw new Error("El usuario no existe.");
        }
    }

    @Override
    public UsuarioEntity crear(UsuarioEntity entidad) {
        return this.usuarioRepository.save(entidad);
    }

    @Override
    public UsuarioEntity actualizar(UsuarioEntity entidad) {
        return this.usuarioRepository.save(entidad);
    }

    @Override
    public String eliminarPorId(Long id) {
        Optional<UsuarioEntity> userById = this.usuarioRepository.findById(id);

        if(userById.isPresent()) {
            this.usuarioRepository.deleteById(id);
            return "Usuario eliminado correctamente.";
        }else {
            throw new Error("El usuario no existe.");
        }
    }
}
