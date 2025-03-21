package com.unad.empleados.services;

import com.unad.empleados.entrypoint.dto.EmpleadoDto;
import com.unad.empleados.mapper.EmpleadoMapper;
import com.unad.empleados.repository.EmpleadoEntity;
import com.unad.empleados.repository.EmpleadosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpleadosService {

    private EmpleadosRepository repository;
    private EmpleadoMapper mapper;

    public EmpleadoDto buscarEmpleado(String documentoIdentidad)  {
        Optional<EmpleadoEntity> optional = repository.findById(documentoIdentidad);
        return mapper.convertirDto(optional.orElseThrow(() -> new IllegalArgumentException("empleado no encontrado")));
    }

    public EmpleadoDto crearEmpleado(EmpleadoDto request)  {
        EmpleadoEntity entity = mapper.convertirEntidad(request);
        repository.save(entity);
        return request;
    }

    public EmpleadoDto actualizarEmpleado(EmpleadoDto request)  {
        return crearEmpleado(request);
    }

    public Map<String, String> eliminarEmpleado(String documentoIdentidad)  {
        repository.deleteById(documentoIdentidad);
        return Map.of("estado", "eliminado");
    }

}
