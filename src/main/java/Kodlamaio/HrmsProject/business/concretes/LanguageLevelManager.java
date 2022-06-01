package Kodlamaio.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlamaio.HrmsProject.business.abstracts.LanguageLevelService;
import Kodlamaio.HrmsProject.core.utilities.result.DataResult;
import Kodlamaio.HrmsProject.core.utilities.result.Result;
import Kodlamaio.HrmsProject.core.utilities.result.SuccessDataResult;
import Kodlamaio.HrmsProject.core.utilities.result.SuccessResult;
import Kodlamaio.HrmsProject.dataAccess.abstracts.LanguageLevelDao;
import Kodlamaio.HrmsProject.entities.concretes.LanguageLevel;

@Service
public class LanguageLevelManager implements LanguageLevelService{
	
	private LanguageLevelDao languageLevelDao;

	@Autowired
	public LanguageLevelManager(LanguageLevelDao languageLevelDao) {
		this.languageLevelDao = languageLevelDao;
	}

	@Override
	public Result add(LanguageLevel languageLevel) {

		languageLevelDao.save(languageLevel);
		return new SuccessResult("Dil seviyesi eklendi.");
	}

	@Override
	public Result update(LanguageLevel languageLevel) {

		languageLevelDao.save(languageLevel);
		return new SuccessResult("Dil seviyesi güncellendi.");
	}

	@Override
	public Result delete(int id) {

		languageLevelDao.deleteById(id);
		return new SuccessResult("Dil seviyesi silindi.");
	}

	@Override
	public DataResult<List<LanguageLevel>> getAll() {
		return new SuccessDataResult<List<LanguageLevel>>(languageLevelDao.findAll());
	}

	@Override
	public DataResult<LanguageLevel> getById(int id) {
		return new SuccessDataResult<LanguageLevel>(languageLevelDao.getById(id));
	}

}
