package Kodlamaio.HrmsProject.business.abstracts;

import java.util.List;

import Kodlamaio.HrmsProject.core.utilities.result.DataResult;
import Kodlamaio.HrmsProject.entities.concretes.CoverLetter;

public interface CoverLetterService extends BaseEntityService<CoverLetter>{
	
	DataResult<List<CoverLetter>> getAllByCandidateId(int candidateId);

}
