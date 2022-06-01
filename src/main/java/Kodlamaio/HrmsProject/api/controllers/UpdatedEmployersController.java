package Kodlamaio.HrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Kodlamaio.HrmsProject.business.abstracts.UpdatedEmployerService;
import Kodlamaio.HrmsProject.core.utilities.result.DataResult;
import Kodlamaio.HrmsProject.entities.concretes.UpdateEmployer;

@RestController
@RequestMapping("/api/updatedEmployers")
@CrossOrigin
public class UpdatedEmployersController {
	
	private UpdatedEmployerService updatedEmployerService;

	@Autowired
	public UpdatedEmployersController(UpdatedEmployerService updatedEmployerService) {
		this.updatedEmployerService = updatedEmployerService;
	}

	@GetMapping("/getAll")
	public DataResult<List<UpdateEmployer>> getAll() {
		return updatedEmployerService.getAll();
	}

	@GetMapping("/getById")
	public DataResult<UpdateEmployer> getById(@RequestParam int id) {
		return updatedEmployerService.getById(id);
	}
	
	@GetMapping("/getByEmployerId")
	public DataResult<UpdateEmployer> getByEmployerId(@RequestParam int employerId) {
		return updatedEmployerService.getByEmployerId(employerId);
	}

}
