package com.rutas.conductor.creacion_de_rutas.infraestructure.input.rest;

import com.rutas.conductor.creacion_de_rutas.applicaton.dto.NeighborhoodRequest;
import com.rutas.conductor.creacion_de_rutas.applicaton.dto.NeighborhoodResponse;
import com.rutas.conductor.creacion_de_rutas.applicaton.handler.INeighborhoodHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/neighborhood")
public class NeighborhoodController {
    private final INeighborhoodHandler neighborhoodHandler;

    @Operation(summary = "Add a new neighborhood")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Neighborhood created", content = @Content),
            @ApiResponse(responseCode = "409", description = "Neighborhood already exists", content = @Content)
    })
    @PostMapping("/save")
    public ResponseEntity<Void> saveNeighborhoodInDB(@RequestBody NeighborhoodRequest neighborhoodRequest){
        neighborhoodHandler.saveNeighborhoodInDB(neighborhoodRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Get all the neighborhoods")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "All neighborhoods returned",
                    content = @Content(mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = NeighborhoodResponse.class)))),
            @ApiResponse(responseCode = "404", description = "UserEntity not found", content = @Content)
    })
    @GetMapping("/getAll")
    public ResponseEntity<List<NeighborhoodResponse>> getAllNeighborhoodsFromDB(){
        return ResponseEntity.ok(neighborhoodHandler.getAllNeighborhoodsFromDB());
    }

    @Operation(summary = "Get a neighborhood by his name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Neighborhood found",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = NeighborhoodResponse.class))),
            @ApiResponse(responseCode = "404", description = "Neighborhood not found", content = @Content)
    })
    @GetMapping("/get/{name}")
    public ResponseEntity<NeighborhoodResponse> getNeighborhoodByNameFromDB(@PathVariable(name = "name") String neighborhoodName){
        return ResponseEntity.ok(neighborhoodHandler.getNeighborhoodFromDBByName(neighborhoodName));
    }

    @Operation(summary = "Update an existing neighborhood")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Neighborhood updated", content = @Content),
            @ApiResponse(responseCode = "404", description = "Neighborhood not found", content = @Content)
    })
    @PutMapping("/update")
    public ResponseEntity<Void> updateNeighborhoodInDB(@RequestBody NeighborhoodRequest neighborhoodRequest){
        neighborhoodHandler.updateNeighborhoodInDB(neighborhoodRequest);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Delete an existing neighborhood")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Neighborhood deleted", content = @Content),
            @ApiResponse(responseCode = "404", description = "Neighborhood not found", content = @Content)
    })
    @DeleteMapping("/delete/{neighborhoodName}")
    public ResponseEntity<Void> deleteNeighborhoodInDB(@PathVariable String neighborhoodName){
        neighborhoodHandler.deleteNeighborhoodInDB(neighborhoodName);
        return ResponseEntity.noContent().build();
    }
}
