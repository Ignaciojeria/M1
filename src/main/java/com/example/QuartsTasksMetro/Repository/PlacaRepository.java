package com.example.QuartsTasksMetro.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.QuartsTasksMetro.Entity.Placa;
import com.example.QuartsTasksMetro.Entity.Estacion;
import java.util.List;
import com.example.QuartsTasksMetro.Entity.Conexion;

public interface PlacaRepository extends JpaRepository<Placa,Long>{
	
	Placa findByConexion(Conexion conexion);

}
