package Kodlamaio.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import Kodlamaio.HrmsProject.business.abstracts.WorkingTypeService;
import Kodlamaio.HrmsProject.core.utilities.result.DataResult;
import Kodlamaio.HrmsProject.core.utilities.result.Result;
import Kodlamaio.HrmsProject.core.utilities.result.SuccessDataResult;
import Kodlamaio.HrmsProject.core.utilities.result.SuccessResult;
import Kodlamaio.HrmsProject.dataAccess.abstracts.WorkingTypeDao;
import Kodlamaio.HrmsProject.entities.concretes.WorkingType;

@Service
public class WorkingTypeManager implements WorkingTypeService{
	
	private WorkingTypeDao workingTypeDao;
	
	@Autowired
	public WorkingTypeManager(WorkingTypeDao workingTypeDao) {
		this.workingTypeDao = workingTypeDao;
	}

	@Override
	public Result add(WorkingType workingType) {
		
		workingTypeDao.save(workingType);
		return new SuccessResult();
	}

	@Override
	public Result update(WorkingType workingType) {
		
		workingTypeDao.save(workingType);
		return new SuccessResult();
	}

	@Override
	public Result delete(int id) {
		
		workingTypeDao.deleteById(id);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<WorkingType>> getAll() {
		
		Sort sort = Sort.by(Sort.Direction.ASC, "type");
		
		return new SuccessDataResult<List<WorkingType>>(workingTypeDao.findAll(sort));
	}

	@Override
	public DataResult<WorkingType> getById(int id) {
		return new SuccessDataResult<WorkingType>(workingTypeDao.getById(id));
	}

}
