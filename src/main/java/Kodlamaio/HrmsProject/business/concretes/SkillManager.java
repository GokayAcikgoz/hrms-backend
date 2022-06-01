package Kodlamaio.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlamaio.HrmsProject.business.abstracts.SkillService;
import Kodlamaio.HrmsProject.core.utilities.result.DataResult;
import Kodlamaio.HrmsProject.core.utilities.result.Result;
import Kodlamaio.HrmsProject.core.utilities.result.SuccessDataResult;
import Kodlamaio.HrmsProject.core.utilities.result.SuccessResult;
import Kodlamaio.HrmsProject.dataAccess.abstracts.SkillDao;
import Kodlamaio.HrmsProject.entities.concretes.Skill;

@Service
public class SkillManager implements SkillService{
	
	private SkillDao skillDao;

	@Autowired
	public SkillManager(SkillDao skillDao) {
		this.skillDao = skillDao;
	}

	@Override
	public Result add(Skill skill) {

		skillDao.save(skill);
		return new SuccessResult("Yetenek eklendi.");
	}

	@Override
	public Result update(Skill skill) {

		skillDao.save(skill);
		return new SuccessResult("Yetenek güncellendi.");
	}

	@Override
	public Result delete(int id) {

		skillDao.deleteById(id);
		return new SuccessResult("Yetenek silindi.");
	}

	@Override
	public DataResult<List<Skill>> getAll() {
		return new SuccessDataResult<List<Skill>>(skillDao.findAll());
	}

	@Override
	public DataResult<Skill> getById(int id) {
		return new SuccessDataResult<Skill>(skillDao.getById(id));
	}

}
