package com.rutas.conductor.creacion_de_rutas.applicaton.mapper;

import com.rutas.conductor.creacion_de_rutas.applicaton.dto.RouteResponse;
import com.rutas.conductor.creacion_de_rutas.domain.model.Neighborhood;
import com.rutas.conductor.creacion_de_rutas.domain.model.Route;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        uses = {NeighborhoodResponseMapper.class})
public interface RouteResponseMapper{
    default RouteResponse toRouteResponse(Route route){
        RouteResponse routeResponse = new RouteResponse();
        routeResponse.setRouteName(route.getRouteName());
        routeResponse.setRouteDescription(route.getRouteDescription());
        routeResponse.setNeighborhoods(route.getNeighborhoods().stream().map(NeighborhoodResponseMapper::toNeighborhoodResponse).collect(Collectors.toList()));
        return routeResponse;
    }
}
