package Kodlamaio.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlamaio.HrmsProject.business.abstracts.CompanyStaffService;
import Kodlamaio.HrmsProject.core.utilities.result.DataResult;
import Kodlamaio.HrmsProject.core.utilities.result.Result;
import Kodlamaio.HrmsProject.core.utilities.result.SuccessDataResult;
import Kodlamaio.HrmsProject.core.utilities.result.SuccessResult;
import Kodlamaio.HrmsProject.dataAccess.abstracts.CompanyStaffDao;
import Kodlamaio.HrmsProject.entities.concretes.CompanyStaff;

@Service
public class CompanyStaffManager implements CompanyStaffService{
	
	private CompanyStaffDao companyStaffDao;

	@Autowired
	public CompanyStaffManager(CompanyStaffDao companyStaffDao) {
		this.companyStaffDao = companyStaffDao;
	}

	@Override
	public Result add(CompanyStaff companyStaff) {
		companyStaffDao.save(companyStaff);
		return new SuccessResult("Şirket personeli eklendi.");
	}

	@Override
	public Result update(CompanyStaff companyStaff) {
		CompanyStaff c = getById(companyStaff.getId()).getData();
		
		companyStaff.setEmail(companyStaff.getEmail() == null || companyStaff.getEmail() == ""
				? c.getEmail()
				: companyStaff.getEmail());
		companyStaff.setPassword(companyStaff.getPassword() == null || companyStaff.getPassword() == ""
				? c.getPassword()
				: companyStaff.getPassword());
		companyStaff.setFirstName(companyStaff.getFirstName() == null || companyStaff.getFirstName() == ""
				? c.getFirstName()
				: companyStaff.getFirstName());
		companyStaff.setLastName(companyStaff.getLastName() == null || companyStaff.getLastName() == ""
				? c.getLastName()
				: companyStaff.getLastName());

		companyStaffDao.save(companyStaff);
		return new SuccessResult("Şirket personeli güncellendi.");
	}

	@Override
	public Result delete(int id) {
		companyStaffDao.deleteById(id);
		return new SuccessResult("Şirket personeli silindi.");
	}

	@Override
	public DataResult<List<CompanyStaff>> getAll() {
		return new SuccessDataResult<List<CompanyStaff>>(companyStaffDao.findAll());
	}

	@Override
	public DataResult<CompanyStaff> getById(int id) {
		return new SuccessDataResult<CompanyStaff>(companyStaffDao.getById(id));
	}

}
