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

import Kodlamaio.HrmsProject.business.abstracts.WorkingTypeService;
import Kodlamaio.HrmsProject.core.utilities.result.DataResult;
import Kodlamaio.HrmsProject.core.utilities.result.Result;
import Kodlamaio.HrmsProject.entities.concretes.WorkingType;

@RestController
@RequestMapping("/api/workingTypes")
@CrossOrigin
public class WorkingTypesController {
	
	private WorkingTypeService workingTypeService;

	@Autowired
	public WorkingTypesController(WorkingTypeService workingTypeService) {
		this.workingTypeService = workingTypeService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody WorkingType workingType) {
		return workingTypeService.add(workingType);
	}
	
	@PutMapping("/update")
	public Result update(@RequestBody WorkingType workingType) {
		return workingTypeService.update(workingType);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<WorkingType>> getAll() {
		return workingTypeService.getAll();
	}
	
	@GetMapping("/getById")
	public DataResult<WorkingType> getById(@RequestParam int id) {
		return workingTypeService.getById(id);
	}

}
