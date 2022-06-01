package Kodlamaio.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlamaio.HrmsProject.entities.concretes.Resume;

public interface ResumeDao extends JpaRepository<Resume, Integer>{
	
	Resume getByCandidate_Id(int candidateId);
	
	Resume getByCoverLetter_Id(int coverLetterId);

}
