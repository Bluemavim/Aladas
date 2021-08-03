package ar.com.ada.api.aladas.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.aladas.entities.Vuelo;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Integer> {

    Vuelo findByVueloId(Integer vueloId);

    List<Vuelo> findByEstadoVueloId(Integer estadoVueloId);

}