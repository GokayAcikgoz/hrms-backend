package Kodlamaio.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlamaio.HrmsProject.business.abstracts.UserConfirmationTypeService;
import Kodlamaio.HrmsProject.core.utilities.result.DataResult;
import Kodlamaio.HrmsProject.core.utilities.result.Result;
import Kodlamaio.HrmsProject.core.utilities.result.SuccessDataResult;
import Kodlamaio.HrmsProject.core.utilities.result.SuccessResult;
import Kodlamaio.HrmsProject.dataAccess.abstracts.UserConfirmationTypeDao;
import Kodlamaio.HrmsProject.entities.concretes.UserConfirmationType;

@Service
public class UserConfirmationTypeManager implements UserConfirmationTypeService{
	
	private UserConfirmationTypeDao userConfirmationTypeDao;
	
	@Autowired
	public UserConfirmationTypeManager(UserConfirmationTypeDao userConfirmationTypeDao) {
		this.userConfirmationTypeDao = userConfirmationTypeDao;
	}

	@Override
	public Result add(UserConfirmationType userConfirmationType) {
		
		userConfirmationTypeDao.save(userConfirmationType);
		return new SuccessResult("Onay tipi eklendi.");
	}

	@Override
	public Result update(UserConfirmationType userConfirmationType) {
		
		userConfirmationTypeDao.save(userConfirmationType);
		return new SuccessResult("Onay tipi güncellendi.");
	}

	@Override
	public Result delete(int id) {
		
		userConfirmationTypeDao.deleteById(id);
		return new SuccessResult("Onay tipi silindi.");
	}

	@Override
	public DataResult<List<UserConfirmationType>> getAll() {
		return new SuccessDataResult<List<UserConfirmationType>>(userConfirmationTypeDao.findAll());
	}

	@Override
	public DataResult<UserConfirmationType> getById(int id) {
		return new SuccessDataResult<UserConfirmationType>(userConfirmationTypeDao.getById(id));
	}

}
