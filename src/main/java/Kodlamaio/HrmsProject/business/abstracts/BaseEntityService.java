package Kodlamaio.HrmsProject.business.abstracts;

import java.util.List;

import Kodlamaio.HrmsProject.core.utilities.result.DataResult;
import Kodlamaio.HrmsProject.core.utilities.result.Result;

public interface BaseEntityService<T> {
	
	Result add(T entity);
	
	Result update(T entity);
	
	Result delete(int id);
	
	DataResult<List<T>> getAll();
	
	DataResult<T> getById(int id);
}
