package com.backend.opengourmet.service;

import com.backend.opengourmet.repository.ResenaRepository;
import com.backend.opengourmet.repository.entity.ResenaEntity;
import com.backend.opengourmet.service.impl.ServiceCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ResenaService implements ServiceCrud<ResenaEntity> {

    @Autowired
    private ResenaRepository resenaRepository;

    @Override
    public List<ResenaEntity> todos() {
        List<ResenaEntity> listResena = this.resenaRepository.findAll();

        if(!listResena.isEmpty()) {
            return listResena;
        }else {
            throw new Error("La lista esta vacia, no hay nada que mostrar");
        }
    }

    @Override
    public ResenaEntity buscarPorId(Long id) {
        Optional<ResenaEntity> resenaOptional = this.resenaRepository.findById(id);

        if(resenaOptional.isPresent()) {
            return resenaOptional.get();
        }else {
            throw new Error("La resena no existe");
        }
    }

    @Override
    public ResenaEntity crear(ResenaEntity entidad) {
        entidad.setFecha(LocalDateTime.now().toLocalDate());
        return this.resenaRepository.save(entidad);
    }

    @Override
    public ResenaEntity actualizar(ResenaEntity entidad) {
        return this.resenaRepository.save(entidad);
    }

    @Override
    public String eliminarPorId(Long id) {
        Optional<ResenaEntity> resenaOptional = this.resenaRepository.findById(id);

        if(resenaOptional.isPresent()) {
            this.resenaRepository.deleteById(id);
            return "La resena se ha eliminado correctamente.";
        }else {
            throw new Error("La resena no existe");
        }
    }
}
