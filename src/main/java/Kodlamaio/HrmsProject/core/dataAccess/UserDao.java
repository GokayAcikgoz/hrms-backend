package Kodlamaio.HrmsProject.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlamaio.HrmsProject.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer>{

	User getByEmail(String email);
}
