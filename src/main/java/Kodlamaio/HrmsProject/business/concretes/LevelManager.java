package Kodlamaio.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import Kodlamaio.HrmsProject.business.abstracts.LevelService;
import Kodlamaio.HrmsProject.core.utilities.result.DataResult;
import Kodlamaio.HrmsProject.core.utilities.result.Result;
import Kodlamaio.HrmsProject.core.utilities.result.SuccessDataResult;
import Kodlamaio.HrmsProject.core.utilities.result.SuccessResult;
import Kodlamaio.HrmsProject.dataAccess.abstracts.LevelDao;
import Kodlamaio.HrmsProject.entities.concretes.Level;

@Service
public class LevelManager implements LevelService{
	
	private LevelDao levelDao;

	@Autowired
	public LevelManager(LevelDao levelDao) {
		this.levelDao = levelDao;
	}

	@Override
	public Result add(Level level) {
		
		levelDao.save(level);
		return new SuccessResult();
	}

	@Override
	public Result update(Level level) {
		
		levelDao.save(level);
		return new SuccessResult();
	}

	@Override
	public Result delete(int id) {
		
		levelDao.deleteById(id);
		return new SuccessResult();
	}

	@Override
	public DataResult<List<Level>> getAll() {
		
		Sort sort = Sort.by(Sort.Direction.ASC, "level");
		
		return new SuccessDataResult<List<Level>>(levelDao.findAll(sort));
	}

	@Override
	public DataResult<Level> getById(int id) {
		return new SuccessDataResult<Level>(levelDao.getById(id));
	}

}
