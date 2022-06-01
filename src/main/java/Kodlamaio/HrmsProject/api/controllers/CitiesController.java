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

import Kodlamaio.HrmsProject.business.abstracts.CityService;
import Kodlamaio.HrmsProject.core.utilities.result.DataResult;
import Kodlamaio.HrmsProject.core.utilities.result.Result;
import Kodlamaio.HrmsProject.entities.concretes.City;

@RestController
@RequestMapping("/api/cities")
@CrossOrigin
public class CitiesController {
	
	private CityService cityService;

	@Autowired
	public CitiesController(CityService cityService) {
		this.cityService = cityService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody City city) {
		return cityService.add(city);
	}

	@PutMapping("/update")
	public Result update(@RequestBody City city) {
		return cityService.update(city);
	}

	@GetMapping("/getAll")
	public DataResult<List<City>> getAll() {
		return cityService.getAll();
	}

	@GetMapping("/getById")
	public DataResult<City> getById(@RequestParam int id) {
		return cityService.getById(id);
	}

}
