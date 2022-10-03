package com.rutas.conductor.creacion_de_rutas.applicaton.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RouteResponse {

    private NeighborhoodResponse origin;
    private NeighborhoodResponse destination;
    private List<RouteNeighborhoodDto> stops;
    private List<DateDto> travelDates;
    private Integer quota;
}
