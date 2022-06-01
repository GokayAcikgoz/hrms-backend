package Kodlamaio.HrmsProject.business.concretes;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlamaio.HrmsProject.business.abstracts.EmailService;
import Kodlamaio.HrmsProject.business.abstracts.JobPostingConfirmationService;
import Kodlamaio.HrmsProject.core.utilities.result.DataResult;
import Kodlamaio.HrmsProject.core.utilities.result.Result;
import Kodlamaio.HrmsProject.core.utilities.result.SuccessDataResult;
import Kodlamaio.HrmsProject.core.utilities.result.SuccessResult;
import Kodlamaio.HrmsProject.dataAccess.abstracts.JobPostingConfirmationDao;
import Kodlamaio.HrmsProject.entities.concretes.JobPostingConfirmation;

@Service
public class JobPostingConfirmationManager implements JobPostingConfirmationService{
	
	private JobPostingConfirmationDao jobPostingConfirmationDao;
	private EmailService emailService;

	@Autowired
	public JobPostingConfirmationManager(JobPostingConfirmationDao jobPostingConfirmationDao, EmailService emailService) {
		this.jobPostingConfirmationDao = jobPostingConfirmationDao;
		this.emailService = emailService;
	}

	@Override
	public Result add(JobPostingConfirmation jobPostingConfirmation) {
		
		jobPostingConfirmation.setIsConfirmedDate(LocalDateTime.now());
		
		jobPostingConfirmationDao.save(jobPostingConfirmation);
		emailService.sendEmail(jobPostingConfirmation.getJobPosting().getEmployer());
		return new SuccessResult();
	}

	@Override
	public Result update(JobPostingConfirmation jobPostingConfirmation) {
		
		jobPostingConfirmationDao.save(jobPostingConfirmation);
		return new SuccessResult();
	}

	@Override
	public Result delete(int id) {
		
		jobPostingConfirmationDao.deleteById(id);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<JobPostingConfirmation>> getAll() {
		return new SuccessDataResult<List<JobPostingConfirmation>>(jobPostingConfirmationDao.findAll());
	}

	@Override
	public DataResult<JobPostingConfirmation> getById(int id) {
		return new SuccessDataResult<JobPostingConfirmation>(jobPostingConfirmationDao.getById(id));
	}

	@Override
	public DataResult<JobPostingConfirmation> getByJobPostingId(int jobPostingId) {		
		return new SuccessDataResult<JobPostingConfirmation>(jobPostingConfirmationDao.getByJobPosting_Id(jobPostingId));
	}

}
