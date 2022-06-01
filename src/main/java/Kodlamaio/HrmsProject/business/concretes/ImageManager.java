package Kodlamaio.HrmsProject.business.concretes;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import Kodlamaio.HrmsProject.business.abstracts.ImageService;
import Kodlamaio.HrmsProject.business.abstracts.UserService;
import Kodlamaio.HrmsProject.business.adapters.cloudinary.CloudStorageService;
import Kodlamaio.HrmsProject.core.utilities.result.DataResult;
import Kodlamaio.HrmsProject.core.utilities.result.Result;
import Kodlamaio.HrmsProject.core.utilities.result.SuccessDataResult;
import Kodlamaio.HrmsProject.core.utilities.result.SuccessResult;
import Kodlamaio.HrmsProject.dataAccess.abstracts.ImageDao;
import Kodlamaio.HrmsProject.entities.concretes.Image;

@Service
public class ImageManager implements ImageService{
	
	private ImageDao imageDao;
	private CloudStorageService cloudStorageService;
	private UserService userService;

	@Autowired
	public ImageManager(ImageDao imageDao, CloudStorageService cloudStorageService, UserService userService) {
		this.imageDao = imageDao;
		this.cloudStorageService = cloudStorageService;
		this.userService = userService;
	}

	@Override
	public Result add(Image image) {

		imageDao.save(image);
		return new SuccessResult("İmaj eklendi.");
	}

	@Override
	public Result update(Image image) {

		imageDao.save(image);
		return new SuccessResult("İmaj güncellendi.");
	}

	@Override
	public Result delete(int id) {
		
		Image image = getById(id).getData();

		String[] splitImageUrlArray = image.getUrl().split("/");
		int indexOfExtension = splitImageUrlArray[splitImageUrlArray.length - 1].indexOf(".");
		String publicIdOfImage = splitImageUrlArray[splitImageUrlArray.length - 1].substring(0, indexOfExtension);

		cloudStorageService.delete(publicIdOfImage);
		imageDao.deleteById(id);
		return new SuccessResult("İmaj silindi.");
	}

	@Override
	public DataResult<List<Image>> getAll() {
		return new SuccessDataResult<List<Image>>(imageDao.findAll());
	}

	@Override
	public DataResult<Image> getById(int id) {
		return new SuccessDataResult<Image>(imageDao.getById(id));
	}

	@Override
	public Result upload(int userId, MultipartFile file) {

		Map<?, ?> uploadImage = (Map<?, ?>) cloudStorageService.upload(file).getData();

		Image image = new Image();
		image.setUser(userService.getById(userId).getData());
		image.setUrl(uploadImage.get("url").toString());

		return add(image);
	}

	@Override
	public DataResult<Image> getByUserId(int userId) {
		return new SuccessDataResult<Image>(imageDao.getByUser_Id(userId));
	}

}
