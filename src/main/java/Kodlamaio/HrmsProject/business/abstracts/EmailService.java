package Kodlamaio.HrmsProject.business.abstracts;

import Kodlamaio.HrmsProject.core.entities.User;
import Kodlamaio.HrmsProject.core.utilities.result.Result;

public interface EmailService {
	
	Result sendEmail(User user);

}
