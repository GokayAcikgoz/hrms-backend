package Kodlamaio.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import Kodlamaio.HrmsProject.business.abstracts.CityService;
import Kodlamaio.HrmsProject.core.utilities.result.DataResult;
import Kodlamaio.HrmsProject.core.utilities.result.Result;
import Kodlamaio.HrmsProject.core.utilities.result.SuccessDataResult;
import Kodlamaio.HrmsProject.core.utilities.result.SuccessResult;
import Kodlamaio.HrmsProject.dataAccess.abstracts.CityDao;
import Kodlamaio.HrmsProject.entities.concretes.City;

@Service
public class CityManager implements CityService{
	
	private CityDao cityDao;
	
	@Autowired
	public CityManager(CityDao cityDao) {
		this.cityDao = cityDao;
	}

	@Override
	public Result add(City city) {
		cityDao.save(city);
		return new SuccessResult("Şehir eklendi.");
	}

	@Override
	public Result update(City city) {
		cityDao.save(city);
		return new SuccessResult("Şehir güncellendi.");
	}

	@Override
	public Result delete(int id) {
		cityDao.deleteById(id);
		return new SuccessResult("Şehir silindi.");
	}

	@Override
	public DataResult<List<City>> getAll() {
		Sort sort = Sort.by(Sort.Direction.ASC, "city");
		
		return new SuccessDataResult<List<City>>(cityDao.findAll(sort));
	}

	@Override
	public DataResult<City> getById(int id) {
		return new SuccessDataResult<City>(cityDao.getById(id));
	}

}
