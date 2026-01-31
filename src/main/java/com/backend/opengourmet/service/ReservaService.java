package com.backend.opengourmet.service;

import com.backend.opengourmet.repository.ReservaRepository;
import com.backend.opengourmet.repository.entity.ReservaEntity;
import com.backend.opengourmet.service.impl.ServiceCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService implements ServiceCrud<ReservaEntity> {

    @Autowired
    private ReservaRepository reservaRepository;

    @Override
    public List<ReservaEntity> todos() {
        List<ReservaEntity> listReserva = this.reservaRepository.findAll();

        if(!listReserva.isEmpty()) {
            return listReserva;
        }else {
            throw new Error("La lista esta vacia, no hay nada que mostrar");
        }
    }

    @Override
    public ReservaEntity buscarPorId(Long id) {
        Optional<ReservaEntity> reservaEntity = this.reservaRepository.findById(id);

        if(reservaEntity.isPresent()) {
            return reservaEntity.get();
        }else {
            throw new Error("La reserva no existe.");
        }
    }

    @Override
    public ReservaEntity crear(ReservaEntity entidad) {
        return this.reservaRepository.save(entidad);
    }

    @Override
    public ReservaEntity actualizar(ReservaEntity entidad) {
        return this.reservaRepository.save(entidad);
    }

    @Override
    public String eliminarPorId(Long id) {
        Optional<ReservaEntity> reservaEntity = this.reservaRepository.findById(id);

        if(reservaEntity.isPresent()) {
            this.reservaRepository.deleteById(id);
            return "Se elimino la reserva correctamente.";
        }else {
            throw new Error("La reserva no existe.");
        }
    }
}
