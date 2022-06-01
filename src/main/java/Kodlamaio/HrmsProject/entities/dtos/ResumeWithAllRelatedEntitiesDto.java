package Kodlamaio.HrmsProject.entities.dtos;


import java.time.LocalDateTime;
import java.util.List;

import Kodlamaio.HrmsProject.entities.concretes.Candidate;
import Kodlamaio.HrmsProject.entities.concretes.CoverLetter;
import Kodlamaio.HrmsProject.entities.concretes.Education;
import Kodlamaio.HrmsProject.entities.concretes.Experience;
import Kodlamaio.HrmsProject.entities.concretes.Image;
import Kodlamaio.HrmsProject.entities.concretes.LanguageLevel;
import Kodlamaio.HrmsProject.entities.concretes.Link;
import Kodlamaio.HrmsProject.entities.concretes.Skill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResumeWithAllRelatedEntitiesDto {
	
	private int id;

	private LocalDateTime creationDate;

	private Candidate candidate;

	private CoverLetter coverLetter;

	private Image image;

	private List<Education> educations;

	private List<Experience> experiences;

	private List<LanguageLevel> languageLevels;

	private List<Link> links;

	private List<Skill> skills;

}
