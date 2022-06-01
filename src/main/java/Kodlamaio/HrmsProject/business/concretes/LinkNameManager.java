package Kodlamaio.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import Kodlamaio.HrmsProject.business.abstracts.LinkNameService;
import Kodlamaio.HrmsProject.core.utilities.result.DataResult;
import Kodlamaio.HrmsProject.core.utilities.result.Result;
import Kodlamaio.HrmsProject.core.utilities.result.SuccessDataResult;
import Kodlamaio.HrmsProject.core.utilities.result.SuccessResult;
import Kodlamaio.HrmsProject.dataAccess.abstracts.LinkNameDao;
import Kodlamaio.HrmsProject.entities.concretes.LinkName;

@Service
public class LinkNameManager implements LinkNameService{
	
	private LinkNameDao linkNameDao;

	@Autowired
	public LinkNameManager(LinkNameDao linkNameDao) {
		this.linkNameDao = linkNameDao;
	}

	@Override
	public Result add(LinkName linkName) {

		linkNameDao.save(linkName);
		return new SuccessResult("Bağlantı adı eklendi.");
	}

	@Override
	public Result update(LinkName linkName) {

		linkNameDao.save(linkName);
		return new SuccessResult("Bağlantı adı güncellendi.");
	}

	@Override
	public Result delete(int id) {

		linkNameDao.deleteById(id);
		return new SuccessResult("Bağlantı adı silindi.");
	}

	@Override
	public DataResult<List<LinkName>> getAll() {
		
		Sort sort = Sort.by(Sort.Direction.ASC, "name");
		
		return new SuccessDataResult<List<LinkName>>(linkNameDao.findAll(sort));
	}

	@Override
	public DataResult<LinkName> getById(int id) {
		return new SuccessDataResult<LinkName>(linkNameDao.getById(id));
	}

}
