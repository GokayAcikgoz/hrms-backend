package Kodlamaio.HrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import Kodlamaio.HrmsProject.entities.concretes.Experience;

public interface ExperienceDao extends JpaRepository<Experience, Integer>{
	
	List<Experience> getByResume_Id(int resumeId);

	List<Experience> getByResume_Id(int resumeId, Sort sort);

}
