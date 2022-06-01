package Kodlamaio.HrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import Kodlamaio.HrmsProject.entities.concretes.Skill;

public interface SkillDao extends JpaRepository<Skill, Integer>{

}
