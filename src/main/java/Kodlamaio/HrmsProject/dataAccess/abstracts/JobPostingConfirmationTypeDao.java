package Kodlamaio.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlamaio.HrmsProject.entities.concretes.JobPostingConfirmationType;

public interface JobPostingConfirmationTypeDao extends JpaRepository<JobPostingConfirmationType, Integer>{

	
}
