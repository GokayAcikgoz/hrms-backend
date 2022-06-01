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

import Kodlamaio.HrmsProject.business.abstracts.ExperienceService;
import Kodlamaio.HrmsProject.core.utilities.result.DataResult;
import Kodlamaio.HrmsProject.core.utilities.result.Result;
import Kodlamaio.HrmsProject.entities.concretes.Experience;

@RestController
@RequestMapping("/api/experiences")
@CrossOrigin
public class ExperiencesController {
	
	private ExperienceService experienceService;

	@Autowired
	public ExperiencesController(ExperienceService experienceService) {
		this.experienceService = experienceService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody Experience experience) {
		return experienceService.add(experience);
	}

	@PutMapping("/update")
	public Result update(@RequestBody Experience experience) {
		return experienceService.update(experience);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestParam int id) {
		return experienceService.delete(id);
	}

	@GetMapping("/getAll")
	public DataResult<List<Experience>> getAll() {
		return experienceService.getAll();
	}

	@GetMapping("/getById")
	public DataResult<Experience> getById(@RequestParam int id) {
		return experienceService.getById(id);
	}

	@GetMapping("/getAllByResumeIdSortedByTerminationDate")
	public DataResult<List<Experience>> getAllByResumeIdSortedByTerminationDate(@RequestParam int resumeId) {
		return experienceService.getAllByResumeIdSortedByTerminationDate(resumeId);
	}


}
