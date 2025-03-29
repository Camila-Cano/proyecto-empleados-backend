package com.unad.empleados.mapper;

import com.unad.empleados.entrypoint.dto.EmpleadoDto;
import com.unad.empleados.repository.EmpleadoEntity;
import org.springframework.stereotype.Component;

@Component
public class EmpleadoMapper {

    public EmpleadoDto convertirDto(EmpleadoEntity entity) {
        return EmpleadoDto.builder()
                .fechaNacimiento(entity.getFechaNacimiento())
                .nombre(entity.getNombre())
                .telefono(entity.getTelefono())
                .codigo(entity.getCodigo())
                .direccion(entity.getDireccion())
                .documentoIdentidad(entity.getDocumentoIdentidad())
                .apellido(entity.getApellido())
                .build();
    }

    public EmpleadoEntity convertirEntidad(EmpleadoDto dto) {
        return EmpleadoEntity.builder()
                .telefono(dto.getTelefono())
                .apellido(dto.getApellido())
                .codigo(dto.getCodigo())
                .direccion(dto.getDireccion())
                .documentoIdentidad(dto.getDocumentoIdentidad())
                .fechaNacimiento(dto.getFechaNacimiento())
                .nombre(dto.getNombre())
                .build();
    }

}
