package Kodlamaio.HrmsProject.business.abstracts;

import java.util.List;

import Kodlamaio.HrmsProject.core.utilities.result.DataResult;
import Kodlamaio.HrmsProject.entities.concretes.FavoriteJobPosting;
import Kodlamaio.HrmsProject.entities.concretes.JobPosting;

public interface FavoriteJobPostingService extends BaseEntityService<FavoriteJobPosting>{
	
	DataResult<List<FavoriteJobPosting>> getAllByCandidateId(int candidateId);

	DataResult<List<JobPosting>> getAllActiveJobPostingsByCandidateIdSortedByDateOfAddToFavorites(int candidateId);
	
	DataResult<FavoriteJobPosting> getByCandidateIdAndJobPostingId(int candidateId, int jobPostingId);

}
