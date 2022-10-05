package com.rutas.conductor.creacion_de_rutas.domain.api;

import com.rutas.conductor.creacion_de_rutas.domain.model.DatesRoute;

import java.util.List;

public interface IDatesRouteServicePort {
    void saveDatesRoute(DatesRoute datesRoute);
    void updateDatesRoute(DatesRoute datesRoute);
    void deleteADateRoute(Long dateRouteId);
    void deleteDatesRouteOfRoute(Long routeId);
    DatesRoute getDateRoute(Long dateRouteId);
    List<DatesRoute> findDatesRouteByRoute(Long  routeId);
    List<DatesRoute> getAllDatesRoute();

}
