package com.unad.empleados.mapper;

import com.unad.empleados.entrypoint.dto.EmpleadoDto;
import com.unad.empleados.repository.EmpleadoEntity;
import org.springframework.stereotype.Component;

@Component
public class EmpleadoMapper {

    public EmpleadoDto convertirDto(EmpleadoEntity entity) {
        return new EmpleadoDto();
    }

    public EmpleadoEntity convertirEntidad(EmpleadoDto dto) {
        return new EmpleadoEntity();
    }

}
