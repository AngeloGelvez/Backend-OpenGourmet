package com.backend.opengourmet.service.impl;

import java.util.List;

public interface ServiceCrud<T> {

    //FindAll
    public List<T> todos();

    //FindById
    public T buscarPorId(Long id);

    //Create
    public T crear(T entidad);

    //Update
    public T actualizar(T entidad);

    //Remove
    public String eliminarPorId(Long id);
}
