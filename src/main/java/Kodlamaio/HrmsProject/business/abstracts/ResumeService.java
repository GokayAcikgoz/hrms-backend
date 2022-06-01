package Kodlamaio.HrmsProject.business.abstracts;

import java.util.List;

import Kodlamaio.HrmsProject.core.utilities.result.DataResult;
import Kodlamaio.HrmsProject.core.utilities.result.Result;
import Kodlamaio.HrmsProject.entities.concretes.Resume;
import Kodlamaio.HrmsProject.entities.dtos.ResumeWithAllRelatedEntitiesDto;

public interface ResumeService extends BaseEntityService<Resume>{

	Result addCoverLetterToResume(int resumeId, int coverLetterId);
	
	Result deleteCoverLetterFromResume(int resumeId);

	DataResult<List<ResumeWithAllRelatedEntitiesDto>> getAllResumesDetailsByActivatedCandidate();

	DataResult<Resume> getByCandidateId(int candidateId);

	DataResult<ResumeWithAllRelatedEntitiesDto> getResumeDetailsByCandidateId(int candidateId);
}
