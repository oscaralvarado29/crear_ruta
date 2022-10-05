package com.rutas.conductor.creacion_de_rutas.applicaton.handler;

import com.rutas.conductor.creacion_de_rutas.applicaton.dto.RouteRequest;
import com.rutas.conductor.creacion_de_rutas.applicaton.dto.RouteResponse;
import com.rutas.conductor.creacion_de_rutas.applicaton.mapper.DatesRouteDtoMapper;
import com.rutas.conductor.creacion_de_rutas.applicaton.mapper.RouteNeighborhoodDtoMapper;
import com.rutas.conductor.creacion_de_rutas.applicaton.mapper.RouteRequestMapper;
import com.rutas.conductor.creacion_de_rutas.applicaton.mapper.RouteResponseMapper;
import com.rutas.conductor.creacion_de_rutas.domain.api.IDatesRouteServicePort;
import com.rutas.conductor.creacion_de_rutas.domain.api.INeighborhoodServicePort;
import com.rutas.conductor.creacion_de_rutas.domain.api.IRouteNeighborhoodServicePort;
import com.rutas.conductor.creacion_de_rutas.domain.api.IRouteServicePort;
import com.rutas.conductor.creacion_de_rutas.domain.model.DatesRoute;
import com.rutas.conductor.creacion_de_rutas.domain.model.Route;
import com.rutas.conductor.creacion_de_rutas.domain.model.RouteNeighborhood;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RouteHandler implements IRouteHandler {
    private final IRouteServicePort routeServicePort;
    private final IDatesRouteServicePort datesRouteServicePort;
    private final IRouteNeighborhoodServicePort routeNeighborhoodServicePort;
    private final RouteRequestMapper routeRequestMapper;
    private final RouteResponseMapper routeResponseMapper;
    private final RouteNeighborhoodDtoMapper routeNeighborhoodDtoMapper;
    private final DatesRouteDtoMapper datesRouteDtoMapper;
    @Override
    public void saveRouteInDB(RouteRequest routeRequest) {
        Route route = routeServicePort.saveRoute(routeRequestMapper.toRoute(routeRequest));
        List<RouteNeighborhood> neighborhoodList = routeRequestMapper.toRouteNeighborhoodList(routeRequest);
        List<DatesRoute> datesRouteList = routeRequestMapper.toDatesRouteList(routeRequest);
        for (RouteNeighborhood routeNeighborhood : neighborhoodList) {
            routeNeighborhood.setRouteId(route.getRouteId());
            routeNeighborhoodServicePort.saveRouteNeighborhood(routeNeighborhood);
        }
        for (DatesRoute dateRoute : datesRouteList) {
            dateRoute.setRouteId(route.getRouteId());
            datesRouteServicePort.saveDatesRoute(dateRoute);
        }
    }

    @Override
    public List<RouteResponse> getAllRoutesFromDB() {
        return null;
    }

    @Override
    public RouteResponse getRouteFromDB(Long id) {
        return null;
    }

    @Override
    public void deleteRouteInDB(Long id) {

    }

    @Override
    public void updateRouteInDB(RouteRequest routeRequest) {

    }
}
