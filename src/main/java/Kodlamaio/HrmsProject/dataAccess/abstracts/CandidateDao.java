package Kodlamaio.HrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlamaio.HrmsProject.entities.concretes.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	
	List<Candidate> getByUserActivation_IsActivated(boolean isActivated);
	
	Candidate getByIdentityNumber(String identityNumber);
	
}
