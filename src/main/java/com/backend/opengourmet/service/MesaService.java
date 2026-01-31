package com.backend.opengourmet.service;

import com.backend.opengourmet.repository.MesaRepository;
import com.backend.opengourmet.repository.entity.MesaEntity;
import com.backend.opengourmet.service.impl.ServiceCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MesaService implements ServiceCrud<MesaEntity> {

    @Autowired
    private MesaRepository mesaRepository;

    @Override
    public List<MesaEntity> todos() {
        List<MesaEntity> listMesa = this.mesaRepository.findAll();

        if(!listMesa.isEmpty()) {
            return listMesa;
        }else {
            throw new Error("La lista esta vacia, no hay nada que mostrar");
        }
    }

    @Override
    public MesaEntity buscarPorId(Long id) {
        Optional<MesaEntity> mesaOptional = this.mesaRepository.findById(id);

        if(mesaOptional.isPresent()) {
            return mesaOptional.get();
        }else {
            throw new Error("La mesa no existe");
        }
    }

    @Override
    public MesaEntity crear(MesaEntity entidad) {
        return this.mesaRepository.save(entidad);
    }

    @Override
    public MesaEntity actualizar(MesaEntity entidad) {
        return this.mesaRepository.save(entidad);
    }

    @Override
    public String eliminarPorId(Long id) {
        Optional<MesaEntity> mesaOptional = this.mesaRepository.findById(id);

        if(mesaOptional.isPresent()) {
            this.mesaRepository.deleteById(id);
            return "La mesa fue elimina con éxito";
        }else {
            throw new Error("La mesa no existe");
        }
    }
}
