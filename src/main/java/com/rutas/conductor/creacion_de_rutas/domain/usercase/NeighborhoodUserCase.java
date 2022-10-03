package com.rutas.conductor.creacion_de_rutas.domain.usercase;

import com.rutas.conductor.creacion_de_rutas.domain.api.INeighborhoodServicePort;
import com.rutas.conductor.creacion_de_rutas.domain.model.Neighborhood;
import com.rutas.conductor.creacion_de_rutas.domain.spi.INeighborhoodPersistencePort;

import java.util.List;

public class NeighborhoodUserCase implements INeighborhoodServicePort {
    private final INeighborhoodPersistencePort neighborhoodPersistencePort;

    public NeighborhoodUserCase(INeighborhoodPersistencePort neighborhoodPersistencePort) {
        this.neighborhoodPersistencePort = neighborhoodPersistencePort;
    }

    /**
     * @param neighborhood the neighborhood to be saved
     */
    @Override
    public void saveNeighborhood(Neighborhood neighborhood) {
        neighborhoodPersistencePort.saveNeighborhood(neighborhood);
    }

    /**
     * @param neighborhood the neighborhood to be updated
     */
    @Override
    public void updateNeighborhood(Neighborhood neighborhood) {
        neighborhoodPersistencePort.updateNeighborhood(neighborhood);
    }


    /**
     * @param neighborhoodName the name of the neighborhood to be deleted
     */
    @Override
    public void deleteNeighborhood(String neighborhoodName) {
        neighborhoodPersistencePort.deleteNeighborhood(neighborhoodName);
    }

    /**
     * @param neighborhoodName the name of the neighborhood to be found
     * @return the neighborhood found
     */
    @Override
    public Neighborhood findByName(String neighborhoodName) {
        return neighborhoodPersistencePort.findByName(neighborhoodName);
    }

    /**
     * @return all the neighborhoods
     */
    @Override
    public List<Neighborhood> getAllNeighborhoods() {
        return neighborhoodPersistencePort.getAllNeighborhoods();
    }
}
