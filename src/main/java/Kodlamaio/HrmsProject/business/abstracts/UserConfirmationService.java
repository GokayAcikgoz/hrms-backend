package Kodlamaio.HrmsProject.business.abstracts;

import java.util.List;

import Kodlamaio.HrmsProject.core.utilities.result.DataResult;
import Kodlamaio.HrmsProject.entities.concretes.UserConfirmation;

public interface UserConfirmationService extends BaseEntityService<UserConfirmation>{
	
	DataResult<List<UserConfirmation>> getAllByUserId(int userId);
	
	DataResult<List<UserConfirmation>> getAllByIsConfirmedAndUserConfirmationTypeId(boolean isConfirmed, int userConfirmationTypeId);

}
