package Kodlamaio.HrmsProject.business.adapters.mernis;

import java.time.LocalDate;

public interface UserCheckService {
	
	boolean checkIfRealPerson(String identityNumber, String firstName, String lastName, LocalDate dateOfBirth);

}
