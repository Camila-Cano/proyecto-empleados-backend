package com.unad.empleados.services;

import com.unad.empleados.entrypoint.dto.EmpleadoDto;
import com.unad.empleados.exceptions.EmpleadoExistenteException;
import com.unad.empleados.exceptions.EmpleadoNoEncotradoException;
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

    private final EmpleadosRepository repository;
    private final EmpleadoMapper mapper;

    public EmpleadoDto buscarEmpleado(String documentoIdentidad)  {
        Optional<EmpleadoEntity> optional = repository.findById(documentoIdentidad);
        return mapper.convertirDto(optional.orElseThrow(() -> new EmpleadoNoEncotradoException("No se encontro empleado: " + documentoIdentidad)));
    }

    public EmpleadoDto crearEmpleado(EmpleadoDto request)  {
        repository.findById(request.getDocumentoIdentidad())
                .ifPresent(e -> {
                    throw new EmpleadoExistenteException(String.format("El empleado %s ya existe", request.getDocumentoIdentidad()));
                });
        EmpleadoEntity entity = mapper.convertirEntidad(request);
        repository.save(entity);
        return request;
    }

    public EmpleadoDto actualizarEmpleado(EmpleadoDto request)  {
        repository.findById(request.getDocumentoIdentidad())
                .orElseThrow(() -> new EmpleadoNoEncotradoException(String.format("El empleado %s no existe",
                        request.getDocumentoIdentidad())));
        EmpleadoEntity entity = mapper.convertirEntidad(request);
        repository.save(entity);
        return request;
    }

    public Map<String, String> eliminarEmpleado(String documentoIdentidad)  {
        repository.deleteById(documentoIdentidad);
        return Map.of("estado", "eliminado");
    }

}
