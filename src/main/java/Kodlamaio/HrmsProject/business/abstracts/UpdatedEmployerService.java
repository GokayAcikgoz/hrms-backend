package Kodlamaio.HrmsProject.business.abstracts;

import Kodlamaio.HrmsProject.core.utilities.result.DataResult;
import Kodlamaio.HrmsProject.entities.concretes.UpdateEmployer;

public interface UpdatedEmployerService extends BaseEntityService<UpdateEmployer>{
	
	DataResult<UpdateEmployer> getByEmployerId(int employerId);


}
