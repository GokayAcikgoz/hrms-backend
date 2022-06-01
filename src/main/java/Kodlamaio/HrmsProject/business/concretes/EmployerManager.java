package Kodlamaio.HrmsProject.business.concretes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import Kodlamaio.HrmsProject.business.abstracts.CompanyStaffService;
import Kodlamaio.HrmsProject.business.abstracts.EmployerService;
import Kodlamaio.HrmsProject.business.abstracts.UpdatedEmployerService;
import Kodlamaio.HrmsProject.business.abstracts.UserActivationService;
import Kodlamaio.HrmsProject.business.abstracts.UserConfirmationService;
import Kodlamaio.HrmsProject.business.abstracts.UserConfirmationTypeService;
import Kodlamaio.HrmsProject.business.abstracts.UserService;
import Kodlamaio.HrmsProject.core.utilities.result.DataResult;
import Kodlamaio.HrmsProject.core.utilities.result.ErrorResult;
import Kodlamaio.HrmsProject.core.utilities.result.Result;
import Kodlamaio.HrmsProject.core.utilities.result.SuccessDataResult;
import Kodlamaio.HrmsProject.core.utilities.result.SuccessResult;
import Kodlamaio.HrmsProject.dataAccess.abstracts.EmployerDao;
import Kodlamaio.HrmsProject.entities.concretes.CompanyStaff;
import Kodlamaio.HrmsProject.entities.concretes.Employer;
import Kodlamaio.HrmsProject.entities.concretes.UpdateEmployer;
import Kodlamaio.HrmsProject.entities.concretes.UserActivation;
import Kodlamaio.HrmsProject.entities.concretes.UserConfirmation;
import Kodlamaio.HrmsProject.entities.concretes.UserConfirmationType;

@Service
public class EmployerManager implements EmployerService{
	
	private EmployerDao employerDao;
	private UserService userService;
	private UserActivationService userActivationService;
	private UserConfirmationService userConfirmationService;
	private UserConfirmationTypeService userConfirmationTypeService;
	private CompanyStaffService companyStaffService;
	private UpdatedEmployerService updatedEmployerService;

	@Autowired
	public EmployerManager(EmployerDao employerDao, UserService userService, UserActivationService userActivationService,
			UserConfirmationService userConfirmationService, UserConfirmationTypeService userConfirmationTypeService, CompanyStaffService companyStaffService, UpdatedEmployerService updatedEmployerService) {
		this.employerDao = employerDao;
		this.userService = userService;
		this.userActivationService = userActivationService;
		this.userConfirmationService = userConfirmationService;
		this.userConfirmationTypeService = userConfirmationTypeService;
		this.companyStaffService = companyStaffService;
		this.updatedEmployerService = updatedEmployerService;
	}

	@Override
	public Result add(Employer employer) {

		validateEmployer(employer);

		employerDao.save(employer);
		return userActivationService.add(new UserActivation(employer));
	}

	@Override
	public Result update(Employer employer) {	

		Employer e = getById(employer.getId()).getData();
		UpdateEmployer updateEmployer = updatedEmployerService.getByEmployerId(employer.getId()).getData();
		
		employer.setEmail(employer.getEmail() == null || employer.getEmail() == "" 
				? e.getEmail()
				: employer.getEmail());
		employer.setPassword(employer.getPassword() == null || employer.getPassword() == ""
				? e.getPassword()
				: employer.getPassword());
		employer.setCompanyName(employer.getCompanyName() == null || employer.getCompanyName() == ""
				? e.getCompanyName()
				: employer.getCompanyName());
		employer.setWebAddress(employer.getWebAddress() == null || employer.getWebAddress() == ""
				? e.getWebAddress()
				: employer.getWebAddress());
		employer.setPhoneNumber(employer.getPhoneNumber() == null || employer.getPhoneNumber() == ""
				? e.getPhoneNumber()
				: employer.getPhoneNumber());
		
		validateEmployer(employer);
		
		if (updateEmployer == null) {
			updateEmployer = new UpdateEmployer(0, employer.getEmail(), employer.getPassword(), employer.getCompanyName(), employer.getWebAddress(), employer.getPhoneNumber(), employer);
		} else {
			updateEmployer.setEmail(employer.getEmail());
			updateEmployer.setPassword(employer.getPassword());
			updateEmployer.setCompanyName(employer.getCompanyName());
			updateEmployer.setWebAddress(employer.getWebAddress());
			updateEmployer.setPhoneNumber(employer.getPhoneNumber());
		}		

		updatedEmployerService.add(updateEmployer);
		return new SuccessResult("İşveren güncellemesi onay aşamasındadır.");
	}

	@Override
	public Result delete(int id) {

		employerDao.deleteById(id);
		return new SuccessResult("İşveren silindi.");
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerDao.findAll());
	}

	@Override
	public DataResult<Employer> getById(int id) {
		return new SuccessDataResult<Employer>(employerDao.getById(id));
	}

	@Override
	public Result activate(String code) {

		UserActivation userActivation = userActivationService.getByCode(code).getData();

		if (userActivation == null) {
			return new ErrorResult("Geçersiz bir kod girdiniz.");
		}

		userActivation.setActivated(true);
		userActivation.setIsActivatedDate(LocalDateTime.now());
		
		userActivationService.update(userActivation);
		return new SuccessResult("Üyeliğiniz onay aşamasındadır.");
	}

	@Override
	public Result confirm(int employerId, int companyStaffId, int userConfirmationTypeId, boolean isConfirmed) {

		Employer employer = getById(employerId).getData();
		CompanyStaff companyStaff = companyStaffService.getById(companyStaffId).getData();
		UserConfirmationType userConfirmationType = userConfirmationTypeService.getById(userConfirmationTypeId).getData();
		UpdateEmployer updatedEmployer = updatedEmployerService.getByEmployerId(employerId).getData();

		if (!isConfirmed && userConfirmationTypeId == 1) {
			userActivationService.delete(userActivationService.getByUserId(employer.getId()).getData().getId());
			delete(employer.getId());
			return new ErrorResult("İşveren hesabı onaylanmadı.");
		}

		if (isConfirmed && userConfirmationTypeId == 1) {
			userConfirmationService.add(new UserConfirmation(employer, companyStaff, userConfirmationType, isConfirmed));
			return new SuccessResult("İşveren hesabı onaylandı.");
		}

		if (!isConfirmed && userConfirmationTypeId == 2) {
			userConfirmationService.add(new UserConfirmation(employer, companyStaff, userConfirmationType, isConfirmed));
			updatedEmployerService.delete(updatedEmployer.getId());
			return new ErrorResult("İşveren güncellemesi onaylanmadı.");
		}

		employer.setEmail(updatedEmployer.getEmail());
		employer.setPassword(updatedEmployer.getPassword());
		employer.setCompanyName(updatedEmployer.getCompanyName());
		employer.setWebAddress(updatedEmployer.getWebAddress());
		employer.setPhoneNumber(updatedEmployer.getPhoneNumber());

		employerDao.save(employer);
		updatedEmployerService.delete(updatedEmployer.getId());
		userConfirmationService.add(new UserConfirmation(employer, companyStaff, userConfirmationType, isConfirmed));
		return new SuccessResult("İşveren güncellemesi onaylandı.");
	}
	
	@Override
	public DataResult<List<Employer>> getAllOnesThatWaitingForAccountConfirmation() {
		
		List<Employer> result = new ArrayList<Employer>();		
		List<Employer> activatedEmployers = getAllByIsActivated(true).getData();
		
		for (Employer employer : activatedEmployers) {
			if (userConfirmationService.getAllByUserId(employer.getId()).getData().size() == 0) {
				result.add(employer);
			}
		}
		
		return new SuccessDataResult<List<Employer>>(result);
	}

	@Override
	public DataResult<List<Employer>> getAllOnesThatWaitingForUpdateConfirmation() {
		
		List<Employer> result = new ArrayList<Employer>();
		List<UpdateEmployer> updatedEmployers = updatedEmployerService.getAll().getData();
		
		for (UpdateEmployer updatedEmployer : updatedEmployers) {
			result.add(new Employer(updatedEmployer.getEmployer().getId() ,updatedEmployer.getEmail(), updatedEmployer.getPassword() ,updatedEmployer.getCompanyName(), updatedEmployer.getWebAddress(), updatedEmployer.getPhoneNumber()));
		}
		
		return new SuccessDataResult<List<Employer>>(result);
	}	
	
	@Override
	public DataResult<List<Employer>> getAllByIsActivated(boolean isActivated) {
		return new SuccessDataResult<List<Employer>>(employerDao.getByUserActivation_IsActivated(isActivated));
	}
	
	@Override
	public DataResult<List<Employer>> getAllByIsConfirmedAndUserConfirmationTypeId(boolean isConfirmed, int userConfirmationTypeId) {
		return new SuccessDataResult<List<Employer>>(employerDao.getByUserConfirmations_IsConfirmedAndUserConfirmations_UserConfirmationType_Id(isConfirmed, userConfirmationTypeId));
	}
	
	@Override
	public DataResult<List<Employer>> getAllByIsConfirmedAndUserConfirmationTypeIdSortedByCompanyName(boolean isConfirmed, int userConfirmationTypeId) {
		
		Sort sort = Sort.by(Sort.Direction.ASC, "companyName");
		
		return new SuccessDataResult<List<Employer>>(employerDao.getByUserConfirmations_IsConfirmedAndUserConfirmations_UserConfirmationType_Id(isConfirmed, userConfirmationTypeId, sort));
	}
	
	@Override
	public DataResult<Employer> getOneThatWaitingForUpdateConfirmationById(int id) {
		
		UpdateEmployer updatedEmployer = updatedEmployerService.getByEmployerId(id).getData();
		Employer result = new Employer(updatedEmployer.getEmployer().getId() ,updatedEmployer.getEmail(), updatedEmployer.getPassword() ,updatedEmployer.getCompanyName(), updatedEmployer.getWebAddress(), updatedEmployer.getPhoneNumber());
		
		return new SuccessDataResult<Employer>(result);
	}

	private boolean checkIfEmailExists(String email) {

		boolean result = false;

		if (userService.getByEmail(email).getData() == null) {
			result = true;
		}

		return result;
	}

	private boolean checkIfDomainsMatch(String webAddress, String email) {

		String[] splitEmailArray = email.split("@");

		return webAddress.contains(splitEmailArray[1]);
	}

	private Result validateEmployer(Employer employer) {
		
		if (employer.getEmail() == null || employer.getPassword() == null || employer.getCompanyName() == null || employer.getWebAddress() == null || employer.getPhoneNumber() == null ) {
			return new ErrorResult("Lütfen boş alanları doldurunuz.");
		}

		if (!checkIfEmailExists(employer.getEmail())) {
			return new ErrorResult("Girilen e-posta adresi başka bir hesaba aittir.");
		}

		if (!checkIfDomainsMatch(employer.getWebAddress(), employer.getEmail())) {
			return new ErrorResult("Web adresi ile e-posta aynı alan adına sahip olmalıdır.");
		}

		return null;
	}

}
