package com.termend.service.evaluate;

import java.util.List;
import java.util.Map;

import com.termend.common.Evals;
import com.termend.pojo.Evaluate;

/**
 * 评价服务类接口
 * 
 * @author yubaojin
 *
 */
public interface IEvaluateService {

	/**
	 * 根据菜的id得到该菜所有评价
	 * 
	 * @param diskId
	 * @return
	 */
	Evals getEvalsByDiskId(int diskId);

	Map<String, Object> getEvals(int page, int rows, int evalValue);

	void saveEvals(List<Evaluate> evals, Integer isAnonymous, String avatarUrl, String nickname);
}
