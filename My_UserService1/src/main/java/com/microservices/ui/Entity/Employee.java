package com.microservices.ui.Entity;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
public class Employee {

	//The @Id annotation is inherited from javax.persistence.Id， indicating the member field below is the primary key of current entity.
	
	//The @GeneratedValue annotation is to configure the way of increment of the specified column(field).

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
    private long employeeId;
	
	@NotNull(message ="First name cannot be null")
	@Size(min=2,message ="first name must not be less than two characters")
	private String firstName;
	
	@NotNull(message ="Last name cannot be null")
	@Size(min=2,message ="Last name must not be less than two characters")
	private String lastName;
	
	
	
	
	
	
//	@NotNull(message="Email cannot be null")
//	@Email
//	private String email;
//	
//	@NotNull
//	@Size(min=8,max=16, message="password must be greater than or equal to 8 charcater and less than 16 character")
//	private String password;
//	
//	
//	@NotEmpty
//	@Size(min=8,message = "Please write a address which are mention your addharcard")
//    private String eaddr;
//	
////    @NotNull
////	@Pattern(regexp ="\"[789][0-9]{9}\"")
////	@Size(max=10,message = "please filled 10 digit number")
//    private int emono;
//	
//	
//    private double esalary;
	
	
}
