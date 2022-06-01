package Kodlamaio.HrmsProject.business.abstracts;

import java.util.List;

import Kodlamaio.HrmsProject.core.utilities.result.DataResult;
import Kodlamaio.HrmsProject.core.utilities.result.Result;
import Kodlamaio.HrmsProject.entities.concretes.Candidate;

public interface CandidateService extends BaseEntityService<Candidate>{
	
	Result activate(String code);

	DataResult<List<Candidate>> getAllByIsActivated(boolean isActivated);

	DataResult<Candidate> getByIdentityNumber(String identityNumber);

}
