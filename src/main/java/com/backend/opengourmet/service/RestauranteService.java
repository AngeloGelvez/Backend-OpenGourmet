package com.backend.opengourmet.service;

import com.backend.opengourmet.repository.RestauranteRepository;
import com.backend.opengourmet.repository.entity.RestauranteEntity;
import com.backend.opengourmet.service.impl.ServiceCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestauranteService implements ServiceCrud<RestauranteEntity> {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Override
    public List<RestauranteEntity> todos() {
        List<RestauranteEntity> listRestaurante = this.restauranteRepository.findAll();

        if(!listRestaurante.isEmpty()) {
            return listRestaurante;
        }else {
            throw new Error("La lista esta vacia, no hay nada que mostrar");
        }
    }

    @Override
    public RestauranteEntity buscarPorId(Long id) {
        Optional<RestauranteEntity> restauranteEntity = this.restauranteRepository.findById(id);

        if(restauranteEntity.isPresent()) {
            return restauranteEntity.get();
        }else {
            throw new Error("El restaurante no existe.");
        }
    }

    @Override
    public RestauranteEntity crear(RestauranteEntity entidad) {
        return this.restauranteRepository.save(entidad);
    }

    @Override
    public RestauranteEntity actualizar(RestauranteEntity entidad) {
        return this.restauranteRepository.save(entidad);
    }

    @Override
    public String eliminarPorId(Long id) {
        Optional<RestauranteEntity> restauranteEntity = this.restauranteRepository.findById(id);

        if(restauranteEntity.isPresent()) {
            this.restauranteRepository.deleteById(id);
            return "El restaurante ha sido eliminado correctamente.";
        }else {
            throw new Error("El restaurante no existe.");
        }
    }
}
