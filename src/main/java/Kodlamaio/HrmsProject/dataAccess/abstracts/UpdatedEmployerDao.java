package Kodlamaio.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlamaio.HrmsProject.entities.concretes.UpdateEmployer;

public interface UpdatedEmployerDao extends JpaRepository<UpdateEmployer, Integer>{

	UpdateEmployer getByEmployer_Id(int employerId);
}
