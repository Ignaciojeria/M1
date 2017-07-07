package com.example.QuartsTasksMetro.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.QuartsTasksMetro.Entity.Conexion;

public interface ConexionRepository extends JpaRepository<Conexion,Long> {

	@Query("select COUNT(*) from Transaccion t")
	int findLastConnection();
}
