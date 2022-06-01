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

import Kodlamaio.HrmsProject.business.abstracts.WorkingTimeService;
import Kodlamaio.HrmsProject.core.utilities.result.DataResult;
import Kodlamaio.HrmsProject.core.utilities.result.Result;
import Kodlamaio.HrmsProject.entities.concretes.WorkingTime;

@RestController
@RequestMapping("/api/workingTimes")
@CrossOrigin
public class WorkingTimesController {
	
	private WorkingTimeService workingTimeService;

	@Autowired
	public WorkingTimesController(WorkingTimeService workingTimeService) {
		this.workingTimeService = workingTimeService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody WorkingTime workingTime) {
		return workingTimeService.add(workingTime);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody WorkingTime workingTime) {
		return workingTimeService.update(workingTime);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<WorkingTime>> getAll() {
		return workingTimeService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<WorkingTime> getById(@RequestParam int id) {
		return workingTimeService.getById(id);
	}

}
