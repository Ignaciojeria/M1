package com.example.QuartsTasksMetro.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.QuartsTasksMetro.Entity.Transaccion;

public interface TransaccionRepository extends JpaRepository<Transaccion,Long> {
	
	@Query("select max(t.numeroTransaccion) from Transaccion t")
	int findLastTransaction();

}
