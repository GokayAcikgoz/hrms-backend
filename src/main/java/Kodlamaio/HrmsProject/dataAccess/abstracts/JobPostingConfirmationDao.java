package Kodlamaio.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlamaio.HrmsProject.entities.concretes.JobPostingConfirmation;

public interface JobPostingConfirmationDao extends JpaRepository<JobPostingConfirmation, Integer>{

	JobPostingConfirmation getByJobPosting_Id(int jobPostingId);
}
