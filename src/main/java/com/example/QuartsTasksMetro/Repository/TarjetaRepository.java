package com.example.QuartsTasksMetro.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.QuartsTasksMetro.Entity.Tarjeta;

public interface TarjetaRepository extends JpaRepository<Tarjeta,Long> {
	
	Tarjeta findByCodigoTarjeta(long codigotarjeta);

}
