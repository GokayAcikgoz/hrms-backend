package Kodlamaio.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import Kodlamaio.HrmsProject.business.abstracts.LanguageService;
import Kodlamaio.HrmsProject.core.utilities.result.DataResult;
import Kodlamaio.HrmsProject.core.utilities.result.Result;
import Kodlamaio.HrmsProject.core.utilities.result.SuccessDataResult;
import Kodlamaio.HrmsProject.core.utilities.result.SuccessResult;
import Kodlamaio.HrmsProject.dataAccess.abstracts.LanguageDao;
import Kodlamaio.HrmsProject.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService{
	
	private LanguageDao languageDao;

	@Autowired
	public LanguageManager(LanguageDao languageDao) {
		this.languageDao = languageDao;
	}

	@Override
	public Result add(Language language) {

		languageDao.save(language);
		return new SuccessResult("Dil eklendi.");
	}

	@Override
	public Result update(Language language) {

		languageDao.save(language);
		return new SuccessResult("Dil güncellendi.");
	}

	@Override
	public Result delete(int id) {

		languageDao.deleteById(id);
		return new SuccessResult("Dil silindi.");
	}

	@Override
	public DataResult<List<Language>> getAll() {
		
		Sort sort = Sort.by(Sort.Direction.ASC, "language");
		
		return new SuccessDataResult<List<Language>>(languageDao.findAll(sort));
	}

	@Override
	public DataResult<Language> getById(int id) {
		return new SuccessDataResult<Language>(languageDao.getById(id));
	}

}
