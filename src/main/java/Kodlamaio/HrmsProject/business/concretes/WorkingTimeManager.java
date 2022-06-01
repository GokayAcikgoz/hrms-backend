package Kodlamaio.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import Kodlamaio.HrmsProject.business.abstracts.WorkingTimeService;
import Kodlamaio.HrmsProject.core.utilities.result.DataResult;
import Kodlamaio.HrmsProject.core.utilities.result.Result;
import Kodlamaio.HrmsProject.core.utilities.result.SuccessDataResult;
import Kodlamaio.HrmsProject.core.utilities.result.SuccessResult;
import Kodlamaio.HrmsProject.dataAccess.abstracts.WorkingTimeDao;
import Kodlamaio.HrmsProject.entities.concretes.WorkingTime;

@Service
public class WorkingTimeManager implements WorkingTimeService{
	
	private WorkingTimeDao workingTimeDao;

	@Autowired
	public WorkingTimeManager(WorkingTimeDao workingTimeDao) {
		this.workingTimeDao = workingTimeDao;
	}

	@Override
	public Result add(WorkingTime workingTime) {
		
		workingTimeDao.save(workingTime);
		return new SuccessResult();
	}

	@Override
	public Result update(WorkingTime workingTime) {
		
		workingTimeDao.save(workingTime);
		return new SuccessResult();
	}

	@Override
	public Result delete(int id) {
		
		workingTimeDao.deleteById(id);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<WorkingTime>> getAll() {
		
		Sort sort = Sort.by(Sort.Direction.ASC, "time");
		
		return new SuccessDataResult<List<WorkingTime>>(workingTimeDao.findAll(sort));
	}

	@Override
	public DataResult<WorkingTime> getById(int id) {
		return new SuccessDataResult<WorkingTime>(workingTimeDao.getById(id));
	}

}
