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

import Kodlamaio.HrmsProject.business.abstracts.UserConfirmationTypeService;
import Kodlamaio.HrmsProject.core.utilities.result.DataResult;
import Kodlamaio.HrmsProject.core.utilities.result.Result;
import Kodlamaio.HrmsProject.entities.concretes.UserConfirmationType;

@RestController
@RequestMapping("/api/userConfirmationTypes")
@CrossOrigin
public class UserConfirmationTypesController {
	
	private UserConfirmationTypeService userConfirmationTypeService;

	@Autowired
	public UserConfirmationTypesController(UserConfirmationTypeService userConfirmationTypeService) {
		this.userConfirmationTypeService = userConfirmationTypeService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody UserConfirmationType userConfirmationType) {
		return userConfirmationTypeService.add(userConfirmationType);
	}

	@PutMapping("/update")
	public Result update(@RequestBody UserConfirmationType userConfirmationType) {
		return userConfirmationTypeService.update(userConfirmationType);
	}

	@GetMapping("/getAll")
	public DataResult<List<UserConfirmationType>> getAll() {
		return userConfirmationTypeService.getAll();
	}

	@GetMapping("/getById")
	public DataResult<UserConfirmationType> getById(@RequestParam int id) {
		return userConfirmationTypeService.getById(id);
	}

}
