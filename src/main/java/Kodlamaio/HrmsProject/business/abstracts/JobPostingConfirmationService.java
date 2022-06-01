package Kodlamaio.HrmsProject.business.abstracts;

import Kodlamaio.HrmsProject.core.utilities.result.DataResult;
import Kodlamaio.HrmsProject.entities.concretes.JobPostingConfirmation;

public interface JobPostingConfirmationService extends BaseEntityService<JobPostingConfirmation>{

	
	DataResult<JobPostingConfirmation> getByJobPostingId(int jobPostingId);
}
