package com.app.PrimeNumGeneratorServer.PrimeRepo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.app.PrimeNumGeneratorServer.Entity.PrimeNum;

@Repository
public interface primeRepository extends JpaRepository<PrimeNum,Long>
{
	
}
