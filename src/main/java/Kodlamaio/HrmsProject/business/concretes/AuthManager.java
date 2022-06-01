package Kodlamaio.HrmsProject.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlamaio.HrmsProject.business.abstracts.AuthService;
import Kodlamaio.HrmsProject.business.abstracts.CandidateService;
import Kodlamaio.HrmsProject.business.abstracts.CompanyStaffService;
import Kodlamaio.HrmsProject.business.abstracts.EmployerService;
import Kodlamaio.HrmsProject.core.entities.User;
import Kodlamaio.HrmsProject.core.utilities.result.ErrorResult;
import Kodlamaio.HrmsProject.core.utilities.result.Result;
import Kodlamaio.HrmsProject.entities.concretes.Candidate;
import Kodlamaio.HrmsProject.entities.concretes.CompanyStaff;
import Kodlamaio.HrmsProject.entities.concretes.Employer;

@Service
public class AuthManager implements AuthService{
	
	private CompanyStaffService companyStaffService;
	private CandidateService candidateService;
	private EmployerService employerService;
	
	
	@Autowired
	public AuthManager(CompanyStaffService companyStaffService, CandidateService candidateService,
			EmployerService employerService) {
		this.companyStaffService = companyStaffService;
		this.candidateService = candidateService;
		this.employerService = employerService;
	}

	@Override
	public Result resgisterCompanyStaff(CompanyStaff companyStaff, String confirmPassword) {
		
		validateUser(companyStaff, confirmPassword);

		return companyStaffService.add(companyStaff);
		
	}

	@Override
	public Result resgisterCandidate(Candidate candidate, String confirmPassword) {
		
		validateUser(candidate, confirmPassword);

		return candidateService.add(candidate);
	}

	@Override
	public Result resgisterEmployer(Employer employer, String confirmPassword) {
	
		validateUser(employer, confirmPassword);

		return employerService.add(employer);
	}
	
	
	private boolean checkIfPasswordsMatch(String password, String confirmPassword) {

		boolean result = false;

		if (password.equals(confirmPassword)) {
			result = true;
		}

		return result;
	}

	private Result validateUser(User user, String confirmPassword) {

		if (!checkIfPasswordsMatch(user.getPassword(), confirmPassword)) {
			return new ErrorResult("Parola eşleşmesi gerçekleşmedi. Lütfen kontrol ederek yeniden deneyiniz.");
		}

		return null;
	}

}
