package com.microservices.ui.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class EmployeeResponse {

	private String firstName;
	private String lastName;
	private long employeeId;
}
