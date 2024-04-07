package com.app.PrimeNumGeneratorServer.seviceI;
import com.app.PrimeNumGeneratorServer.Entity.PrimeNumRequest;
import com.app.PrimeNumGeneratorServer.Entity.PrimeNumResponse;



public interface PrimeServiceI {

	public PrimeNumResponse CalculatePrimeNumber(PrimeNumRequest pRequest);

}
