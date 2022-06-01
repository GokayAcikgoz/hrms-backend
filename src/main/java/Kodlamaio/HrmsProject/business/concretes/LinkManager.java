package Kodlamaio.HrmsProject.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Kodlamaio.HrmsProject.business.abstracts.LinkService;
import Kodlamaio.HrmsProject.core.utilities.result.DataResult;
import Kodlamaio.HrmsProject.core.utilities.result.Result;
import Kodlamaio.HrmsProject.core.utilities.result.SuccessDataResult;
import Kodlamaio.HrmsProject.core.utilities.result.SuccessResult;
import Kodlamaio.HrmsProject.dataAccess.abstracts.LinkDao;
import Kodlamaio.HrmsProject.entities.concretes.Link;

@Service
public class LinkManager implements LinkService{
	
	private LinkDao linkDao;

	@Autowired
	public LinkManager(LinkDao linkDao) {
		this.linkDao = linkDao;
	}

	@Override
	public Result add(Link link) {

		linkDao.save(link);
		return new SuccessResult("Link eklendi.");
	}

	@Override
	public Result update(Link link) {

		linkDao.save(link);
		return new SuccessResult("Link güncellendi.");
	}

	@Override
	public Result delete(int id) {

		linkDao.deleteById(id);
		return new SuccessResult("Link silindi.");
	}

	@Override
	public DataResult<List<Link>> getAll() {
		return new SuccessDataResult<List<Link>>(linkDao.findAll());
	}

	@Override
	public DataResult<Link> getById(int id) {
		return new SuccessDataResult<Link>(linkDao.getById(id));
	}

}
