package Kodlamaio.HrmsProject.business.abstracts;

import org.springframework.web.multipart.MultipartFile;

import Kodlamaio.HrmsProject.core.utilities.result.DataResult;
import Kodlamaio.HrmsProject.core.utilities.result.Result;
import Kodlamaio.HrmsProject.entities.concretes.Image;

public interface ImageService extends BaseEntityService<Image>{
	
	Result upload(int userId, MultipartFile file);

	DataResult<Image> getByUserId(int userId);

}
