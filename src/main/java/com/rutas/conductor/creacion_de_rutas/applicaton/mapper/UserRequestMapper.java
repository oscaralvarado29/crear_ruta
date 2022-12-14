package com.rutas.conductor.creacion_de_rutas.applicaton.mapper;

import com.rutas.conductor.creacion_de_rutas.applicaton.dto.UserRequest;
import com.rutas.conductor.creacion_de_rutas.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserRequestMapper {
    User toUser(UserRequest userRequest);
}

