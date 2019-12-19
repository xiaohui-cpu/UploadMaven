package com.termend.controller.evaluate;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.termend.common.Evals;
import com.termend.common.Result;
import com.termend.common.json.JsonUtils;
import com.termend.pojo.Evaluate;
import com.termend.service.evaluate.IEvaluateService;


@RestController
@RequestMapping("/evaluate")
public class EvaluateController {

	@Autowired
	private IEvaluateService evaluateService;

	/**
	 * 根据菜的id得到该菜所有评价
	 * 
	 * @param diskId
	 * @return
	 */
	@RequestMapping("/getEvalsByDiskId")
	public Result getEvalsByDiskId(Integer diskId) {
		Evals evals = evaluateService.getEvalsByDiskId(diskId);
		return Result.ok(evals);
	}

	/**
	 * 得到所有的评价
	 * 
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("/getEvals")
	public Map<String, Object> getEvals(@RequestParam(defaultValue = "1") Integer page,
			@RequestParam(defaultValue = "10") Integer rows, @RequestParam(defaultValue = "0") Integer evalValue) {
		Map<String, Object> evals = evaluateService.getEvals(page, rows, evalValue);
		return evals;
	}

	@RequestMapping("/saveEvals")
	@ResponseBody
	public Result saveEvals(String evals, Integer isAnonymous, String avatarUrl, String nickname)throws Exception {
		nickname = new String(nickname.getBytes("ISO-8859-1"),"UTF-8");
		System.out.println("evals=="+evals+" "+isAnonymous+"  "+avatarUrl+" "+nickname);
		List<Evaluate> evalss = JsonUtils.jsonToList(evals, Evaluate.class);
		for (Evaluate evaluate : evalss) {
			evaluate.setContent(new String(evaluate.getContent().getBytes("ISO-8859-1"),"UTF-8"));
			System.out.println(evaluate.getContent());
		}
		evaluateService.saveEvals(evalss, isAnonymous, avatarUrl, nickname);
		return Result.ok();
	}
}
