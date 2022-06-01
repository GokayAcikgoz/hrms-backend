package Kodlamaio.HrmsProject.business.adapters.cloudinary;

import org.springframework.web.multipart.MultipartFile;

import Kodlamaio.HrmsProject.core.utilities.result.DataResult;

public interface CloudStorageService {
	
	DataResult<?> upload(MultipartFile multipartFile);
	
	DataResult<?> delete(String publicIdOfImage);

}
