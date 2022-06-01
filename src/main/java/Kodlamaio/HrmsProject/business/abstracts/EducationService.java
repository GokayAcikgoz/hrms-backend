package Kodlamaio.HrmsProject.business.abstracts;

import java.util.List;

import Kodlamaio.HrmsProject.core.utilities.result.DataResult;
import Kodlamaio.HrmsProject.entities.concretes.Education;

public interface EducationService extends BaseEntityService<Education>{
	
	DataResult<List<Education>> getAllByResumeId(int resumeId);

	DataResult<List<Education>> getAllByResumeIdSortedByGraduationDate(int resumeId);

}
