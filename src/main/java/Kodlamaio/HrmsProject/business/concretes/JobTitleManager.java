package Kodlamaio.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import Kodlamaio.HrmsProject.business.abstracts.JobTitleService;
import Kodlamaio.HrmsProject.core.utilities.result.DataResult;
import Kodlamaio.HrmsProject.core.utilities.result.ErrorResult;
import Kodlamaio.HrmsProject.core.utilities.result.Result;
import Kodlamaio.HrmsProject.core.utilities.result.SuccessDataResult;
import Kodlamaio.HrmsProject.core.utilities.result.SuccessResult;
import Kodlamaio.HrmsProject.dataAccess.abstracts.JobTitleDao;
import Kodlamaio.HrmsProject.entities.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService{
	
	private JobTitleDao jobTitleDao;

	@Autowired
	public JobTitleManager(JobTitleDao jobTitleDao) {
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public Result add(JobTitle jobTitle) {

		if (!checkIfJobTitleExists(jobTitle.getTitle())) {
			return new ErrorResult("Eklemek istediğiniz iş pozisyonu zaten mevcut.");
		}

		jobTitleDao.save(jobTitle);
		return new SuccessResult("İş pozisyonu eklendi.");
	}

	@Override
	public Result update(JobTitle jobTitle) {

		jobTitleDao.save(jobTitle);
		return new SuccessResult("İş pozisyonu güncellendi.");
	}

	@Override
	public Result delete(int id) {

		jobTitleDao.deleteById(id);
		return new SuccessResult("İş pozisyonu silindi.");
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {
		
		Sort sort = Sort.by(Sort.Direction.ASC, "title");
		
		return new SuccessDataResult<List<JobTitle>>(jobTitleDao.findAll(sort));
	}

	@Override
	public DataResult<JobTitle> getById(int id) {
		return new SuccessDataResult<JobTitle>(jobTitleDao.getById(id));
	}

	@Override
	public DataResult<JobTitle> getByTitle(String title) {
		return new SuccessDataResult<JobTitle>(jobTitleDao.getByTitle(title));
	}

	private boolean checkIfJobTitleExists(String title) {

		boolean result = false;

		if (getByTitle(title).getData() == null) {
			result = true;
		}

		return result;
	}

}
