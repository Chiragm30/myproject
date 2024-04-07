package com.app.PrimeNumGeneratorServer.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrimeNumRequest {
 
	private int firstNumber,lastNumber;
}
