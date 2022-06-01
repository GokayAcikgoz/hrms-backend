package Kodlamaio.HrmsProject.business.abstracts;

import java.util.List;

import Kodlamaio.HrmsProject.core.entities.User;
import Kodlamaio.HrmsProject.core.utilities.result.DataResult;

public interface UserService {
	
	DataResult<List<User>> getAll();
	
	DataResult<User> getById(int id);
	
	DataResult<User> getByEmail(String email);

}
