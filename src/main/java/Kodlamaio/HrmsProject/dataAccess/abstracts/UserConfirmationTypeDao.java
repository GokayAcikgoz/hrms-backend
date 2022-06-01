package Kodlamaio.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlamaio.HrmsProject.entities.concretes.UserConfirmationType;

public interface UserConfirmationTypeDao extends JpaRepository<UserConfirmationType, Integer>{

}
