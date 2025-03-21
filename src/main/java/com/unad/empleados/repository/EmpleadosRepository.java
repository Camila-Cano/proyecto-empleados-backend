package com.unad.empleados.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadosRepository extends MongoRepository<EmpleadoEntity, String> {
}
