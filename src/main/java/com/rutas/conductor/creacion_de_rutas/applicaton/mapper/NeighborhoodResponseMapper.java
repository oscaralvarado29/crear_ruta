package com.rutas.conductor.creacion_de_rutas.applicaton.mapper;

import com.rutas.conductor.creacion_de_rutas.applicaton.dto.NeighborhoodResponse;
import com.rutas.conductor.creacion_de_rutas.domain.model.Neighborhood;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface NeighborhoodResponseMapper {
    NeighborhoodResponse toNeighborhoodResponse(Neighborhood neighborhood);
    List<NeighborhoodResponse> toNeighborhoodResponseList(List<Neighborhood> neighborhoodList);
}
