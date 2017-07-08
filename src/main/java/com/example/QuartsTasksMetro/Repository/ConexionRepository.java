package com.example.QuartsTasksMetro.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.QuartsTasksMetro.Entity.Conexion;

public interface ConexionRepository extends JpaRepository<Conexion,Long> {

	@Query("select COUNT(*) from Conexion")
	int findLastConnection();
	
	List<Conexion> findById(long id);
}
