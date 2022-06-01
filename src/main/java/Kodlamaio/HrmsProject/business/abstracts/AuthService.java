package Kodlamaio.HrmsProject.business.abstracts;

import Kodlamaio.HrmsProject.core.utilities.result.Result;
import Kodlamaio.HrmsProject.entities.concretes.Candidate;
import Kodlamaio.HrmsProject.entities.concretes.CompanyStaff;
import Kodlamaio.HrmsProject.entities.concretes.Employer;

public interface AuthService {
	
	Result resgisterCompanyStaff(CompanyStaff companyStaff, String confirmPassword);

	Result resgisterCandidate(Candidate candidate, String confirmPassword);

	Result resgisterEmployer(Employer employer, String confirmPassword);

}
