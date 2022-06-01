package Kodlamaio.HrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Kodlamaio.HrmsProject.business.abstracts.LevelService;
import Kodlamaio.HrmsProject.core.utilities.result.DataResult;
import Kodlamaio.HrmsProject.core.utilities.result.Result;
import Kodlamaio.HrmsProject.entities.concretes.Level;

@RestController
@RequestMapping("/api/levels")
@CrossOrigin
public class LevelsController {
	
	private LevelService levelService;

	@Autowired
	public LevelsController(LevelService levelService) {
		this.levelService = levelService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody Level level) {
		return levelService.add(level);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody Level level) {
		return levelService.update(level);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Level>> getAll() {
		return levelService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<Level> getById(@RequestParam int id) {
		return levelService.getById(id);
	}

}
