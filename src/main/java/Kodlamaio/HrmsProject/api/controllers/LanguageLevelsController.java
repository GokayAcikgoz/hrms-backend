package Kodlamaio.HrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Kodlamaio.HrmsProject.business.abstracts.LanguageLevelService;
import Kodlamaio.HrmsProject.core.utilities.result.DataResult;
import Kodlamaio.HrmsProject.core.utilities.result.Result;
import Kodlamaio.HrmsProject.entities.concretes.LanguageLevel;

@RestController
@RequestMapping("/api/languageLevels")
@CrossOrigin
public class LanguageLevelsController {
	
	private LanguageLevelService languageLevelService;

	@Autowired
	public LanguageLevelsController(LanguageLevelService languageLevelService) {
		this.languageLevelService = languageLevelService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody LanguageLevel languageLevel) {
		return languageLevelService.add(languageLevel);
	}

	@PutMapping("/update")
	public Result update(@RequestBody LanguageLevel languageLevel) {
		return languageLevelService.update(languageLevel);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestParam int id) {
		return languageLevelService.delete(id);
	}

	@GetMapping("/getAll")
	public DataResult<List<LanguageLevel>> getAll() {
		return languageLevelService.getAll();
	}

	@GetMapping("/getById")
	public DataResult<LanguageLevel> getById(@RequestParam int id) {
		return languageLevelService.getById(id);
	}

}
