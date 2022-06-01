package Kodlamaio.HrmsProject.business.abstracts;

import java.util.List;

import Kodlamaio.HrmsProject.core.utilities.result.DataResult;
import Kodlamaio.HrmsProject.entities.concretes.UserActivation;

public interface UserActivationService extends BaseEntityService<UserActivation>{
	
	DataResult<UserActivation> getByCode(String code);

	DataResult<UserActivation> getByUserId(int userId);
	
	DataResult<List<UserActivation>> getAllByIsActivated(boolean isActivated);

}
