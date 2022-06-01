package Kodlamaio.HrmsProject.business.abstracts;

import java.util.List;

import Kodlamaio.HrmsProject.core.utilities.result.DataResult;
import Kodlamaio.HrmsProject.entities.concretes.Experience;

public interface ExperienceService extends BaseEntityService<Experience>{
	
	DataResult<List<Experience>> getAllByResumeId(int resumeId);

	DataResult<List<Experience>> getAllByResumeIdSortedByTerminationDate(int resumeId);

}
