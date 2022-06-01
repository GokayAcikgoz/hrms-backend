package Kodlamaio.HrmsProject.business.concretes;

import org.springframework.stereotype.Service;

import Kodlamaio.HrmsProject.business.abstracts.EmailService;
import Kodlamaio.HrmsProject.core.entities.User;
import Kodlamaio.HrmsProject.core.utilities.result.Result;
import Kodlamaio.HrmsProject.core.utilities.result.SuccessResult;

@Service
public class EmailManager implements EmailService{
	
	@Override
	public Result sendEmail(User user) {
		return new SuccessResult(user.getEmail() + " adresine e-posta gönderildi.");
	}

}
