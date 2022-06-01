package Kodlamaio.HrmsProject.business.abstracts;

import Kodlamaio.HrmsProject.core.utilities.result.DataResult;
import Kodlamaio.HrmsProject.entities.concretes.JobTitle;

public interface JobTitleService extends BaseEntityService<JobTitle>{
	
	DataResult<JobTitle> getByTitle(String title);

}
