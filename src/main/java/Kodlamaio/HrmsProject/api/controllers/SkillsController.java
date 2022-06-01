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

import Kodlamaio.HrmsProject.business.abstracts.SkillService;
import Kodlamaio.HrmsProject.core.utilities.result.DataResult;
import Kodlamaio.HrmsProject.core.utilities.result.Result;
import Kodlamaio.HrmsProject.entities.concretes.Skill;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin
public class SkillsController {
	
	private SkillService skillService;

	@Autowired
	public SkillsController(SkillService skillService) {
		this.skillService = skillService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody Skill skill) {
		return skillService.add(skill);
	}

	@PutMapping("/update")
	public Result update(@RequestBody Skill skill) {
		return skillService.update(skill);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestParam int id) {
		return skillService.delete(id);
	}

	@GetMapping("/getAll")
	public DataResult<List<Skill>> getAll() {
		return skillService.getAll();
	}

	@GetMapping("/getById")
	public DataResult<Skill> getById(@RequestParam int id) {
		return skillService.getById(id);
	}

}
