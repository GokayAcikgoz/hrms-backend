package Kodlamaio.HrmsProject.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlamaio.HrmsProject.entities.concretes.UserConfirmation;

public interface UserConfirmationDao extends JpaRepository<UserConfirmation, Integer>{

	List<UserConfirmation> getByUser_Id(int userId);
	
	List<UserConfirmation> getByIsConfirmedAndUserConfirmationType_Id(boolean isConfirmed, int userConfirmationTypeId);
}
