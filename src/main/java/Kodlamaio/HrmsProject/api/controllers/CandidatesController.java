package Kodlamaio.HrmsProject.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Kodlamaio.HrmsProject.business.abstracts.CandidateService;
import Kodlamaio.HrmsProject.core.utilities.result.DataResult;
import Kodlamaio.HrmsProject.core.utilities.result.Result;
import Kodlamaio.HrmsProject.entities.concretes.Candidate;

@RestController
@RequestMapping("/api/candidates")
@CrossOrigin
public class CandidatesController {
	
	private CandidateService candidateService;

	@Autowired
	public CandidatesController(CandidateService candidateService) {
		this.candidateService = candidateService;
	}

	@PutMapping("/update")
	public Result update(@RequestBody Candidate candidate) {
		return candidateService.update(candidate);
	}

	@GetMapping("/getAll")
	public DataResult<List<Candidate>> getAll() {
		return candidateService.getAll();
	}

	@GetMapping("getById")
	public DataResult<Candidate> getById(@RequestParam int id) {
		return candidateService.getById(id);
	}

	@PutMapping("/activate")
	public Result activate(@RequestParam String code) {
		return candidateService.activate(code);
	}

	@GetMapping("/getAllByIsActivated")
	public DataResult<List<Candidate>> getAllByIsActivated(@RequestParam boolean isActivated) {
		return candidateService.getAllByIsActivated(isActivated);
	}

}
