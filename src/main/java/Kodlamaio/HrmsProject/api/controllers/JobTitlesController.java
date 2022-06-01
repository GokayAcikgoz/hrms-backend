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

import Kodlamaio.HrmsProject.business.abstracts.JobTitleService;
import Kodlamaio.HrmsProject.core.utilities.result.DataResult;
import Kodlamaio.HrmsProject.core.utilities.result.Result;
import Kodlamaio.HrmsProject.entities.concretes.JobTitle;

@RestController
@RequestMapping("/api/jobTitles")
@CrossOrigin
public class JobTitlesController {
	
	private JobTitleService jobTitleService;

	@Autowired
	public JobTitlesController(JobTitleService jobTitleService) {
		this.jobTitleService = jobTitleService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobTitle jobTitle) {
		return jobTitleService.add(jobTitle);
	}

	@PutMapping("/update")
	public Result update(@RequestBody JobTitle jobTitle) {
		return jobTitleService.update(jobTitle);
	}

	@GetMapping("/getAll")
	public DataResult<List<JobTitle>> getAll() {
		return jobTitleService.getAll();
	}

	@GetMapping("/getById")
	public DataResult<JobTitle> getById(@RequestParam int id) {
		return jobTitleService.getById(id);
	}

}
