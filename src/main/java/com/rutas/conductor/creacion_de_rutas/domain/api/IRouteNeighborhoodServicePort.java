package com.rutas.conductor.creacion_de_rutas.domain.api;

import com.rutas.conductor.creacion_de_rutas.domain.model.RouteNeighborhood;

import java.util.List;

public interface IRouteNeighborhoodServicePort {
    void saveRouteNeighborhood(List<RouteNeighborhood> routeNeighborhood) ;
    void updateRouteNeighborhood(RouteNeighborhood routeNeighborhood);
    void deleteRouteNeighborhoodByRoute(Long routeId);

    List<RouteNeighborhood> getAllRouteNeighborhoods();
    List<RouteNeighborhood> findRouteNeighborhoodByRoute(Long routeId);

}
