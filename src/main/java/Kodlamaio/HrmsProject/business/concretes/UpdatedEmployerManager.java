package Kodlamaio.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlamaio.HrmsProject.business.abstracts.UpdatedEmployerService;
import Kodlamaio.HrmsProject.core.utilities.result.DataResult;
import Kodlamaio.HrmsProject.core.utilities.result.Result;
import Kodlamaio.HrmsProject.core.utilities.result.SuccessDataResult;
import Kodlamaio.HrmsProject.core.utilities.result.SuccessResult;
import Kodlamaio.HrmsProject.dataAccess.abstracts.UpdatedEmployerDao;
import Kodlamaio.HrmsProject.entities.concretes.UpdateEmployer;

@Service
public class UpdatedEmployerManager implements UpdatedEmployerService{
	
	private UpdatedEmployerDao updatedEmployerDao;

	@Autowired
	public UpdatedEmployerManager(UpdatedEmployerDao updatedEmployerDao) {
		this.updatedEmployerDao = updatedEmployerDao;
	}

	@Override
	public Result add(UpdateEmployer updateEmployer) {

		updatedEmployerDao.save(updateEmployer);
		return new SuccessResult("Güncellenmiş işveren eklendi.");
	}

	@Override
	public Result update(UpdateEmployer updateEmployer) {

		updatedEmployerDao.save(updateEmployer);
		return new SuccessResult("Güncellenmiş işveren güncellendi.");
	}

	@Override
	public Result delete(int id) {

		updatedEmployerDao.deleteById(id);
		return new SuccessResult("Güncellenmiş işveren silindi.");
	}

	@Override
	public DataResult<List<UpdateEmployer>> getAll() {
		return new SuccessDataResult<List<UpdateEmployer>>(updatedEmployerDao.findAll());
	}

	@Override
	public DataResult<UpdateEmployer> getById(int id) {
		return new SuccessDataResult<UpdateEmployer>(updatedEmployerDao.getById(id));
	}

	@Override
	public DataResult<UpdateEmployer> getByEmployerId(int employerId) {
		return new SuccessDataResult<UpdateEmployer>(updatedEmployerDao.getByEmployer_Id(employerId));
	}

}
