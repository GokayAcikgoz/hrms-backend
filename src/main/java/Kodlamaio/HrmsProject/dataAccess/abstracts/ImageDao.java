package Kodlamaio.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlamaio.HrmsProject.entities.concretes.Image;

public interface ImageDao extends JpaRepository<Image, Integer>{

	Image getByUser_Id(int userId);
}
