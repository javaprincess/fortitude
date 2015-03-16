package com.fox.it.erws.rest.api.processor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fox.it.erws.rest.api.dao.DRCDao;
import com.fox.it.erws.rest.api.model.drc.response.ProductAnswer;
import com.fox.it.erws.rest.api.pojos.Answer;
import com.fox.it.erws.rest.api.pojos.RightsCheckDetail;
import com.fox.it.erws.rest.api.pojos.RightsCheckRestrictionDetail;

public class AnswerResponseConverter {

	private final DRCDao drcDao;
	
	public AnswerResponseConverter(DRCDao drcDao) {
		this.drcDao = drcDao;
	}
	
	
	private void addAnswer(ProductAnswer productAnswer,Answer answer) {
		productAnswer.getStrands().add(answer);
	}
	
	private ProductAnswer getFrom(Answer answer) {
		List<Answer> answers = new ArrayList<>();
		ProductAnswer productAnswer = new ProductAnswer(answer.getReqProductId(), answer.getReqProductId(), answer.getReqFoxId(), answer.getReqFinProdId(), answers);
		return productAnswer;
	}
	
	private List<ProductAnswer> toList(Map<Long,ProductAnswer> productAnswerMap) {
		List<ProductAnswer> list = new ArrayList<>();
		list.addAll(productAnswerMap.values());
		return list;
	}
	
	private String getKeyQueryAndPassCheckIdKey(Long queryId, Long passCheckId) {
		return  queryId + ":" + passCheckId;
	}
	
	private Map<String,List<RightsCheckRestrictionDetail>> getRightsCheckRestrictionDetailsByQueryIdAndPassFailCheckId(List<RightsCheckRestrictionDetail> rightsCheckRestrictionDetails) {
		Map<String,List<RightsCheckRestrictionDetail>> map = new HashMap<>();
		for (RightsCheckRestrictionDetail r: rightsCheckRestrictionDetails) {
			String key = getKeyQueryAndPassCheckIdKey(r.getQueryId(), r.getPassFailCheckId());
			List<RightsCheckRestrictionDetail> list = new ArrayList<>();
			if (map.containsKey(key)) {
				list = map.get(key);
			} else {
				map.put(key, list);
			}
			list.add(r);
		}
		return map;
	}
	
	private void setRightsRestrictionDetail(List<RightsCheckDetail> rightsCheckDetail,List<RightsCheckRestrictionDetail> rightsCheckRestrictionDetails) {
		Map<String,List<RightsCheckRestrictionDetail>> map = getRightsCheckRestrictionDetailsByQueryIdAndPassFailCheckId(rightsCheckRestrictionDetails);
		for (RightsCheckDetail r: rightsCheckDetail ) {
			String key = getKeyQueryAndPassCheckIdKey(r.getQueryId(), r.getPassFailCheckId());
			List<RightsCheckRestrictionDetail> restrictionDetails = map.get(key);
			r.setRightsCheckRestrictionDetail(restrictionDetails);
		}
	}
	
	
	/**
	 * Gets all the rights check details for all the answers.
	 * It fetches them in batch for efficiency purposes
	 * @param answers
	 * @return
	 */
	private List<RightsCheckDetail> getRightsCheckDetail(Collection<Answer> answers) {
		//first accumulate all the ids
		List<Long> queryIds = new ArrayList<>();
		for (Answer answer: answers) {
			Long queryId = answer.getQueryId();
			queryIds.add(queryId);
		}
		List<RightsCheckDetail> rightsCheckDetail = drcDao.getRightsCheckDetailByQueryIds(queryIds);
		List<RightsCheckRestrictionDetail> rightsCheckRestrictionDetails = drcDao.findRightsCheckRestrictionDetailByQueryIds(queryIds);
		setRightsRestrictionDetail(rightsCheckDetail, rightsCheckRestrictionDetails);
		return rightsCheckDetail; 
	}
	
	private Map<Long,List<RightsCheckDetail>> toMapByQueryId(List<RightsCheckDetail> rightsCheckDetail) {
		Map<Long,List<RightsCheckDetail>> map = new HashMap<>();
		for (RightsCheckDetail detail: rightsCheckDetail) {
			Long queryId = detail.getQueryId();
			List<RightsCheckDetail> details = new ArrayList<>();
			if (map.containsKey(queryId)) {
				details = map.get(queryId);
			} else {
				map.put(queryId, details);
			}
			details.add(detail);
		}
		return map;
	}

	private void setRightsCheckDetail(Collection<Answer> answers) {
		List<RightsCheckDetail> rightsCheckDetails = getRightsCheckDetail(answers);

		Map<Long,List<RightsCheckDetail>> map = toMapByQueryId(rightsCheckDetails);
		for (Answer answer: answers) {
			Long queryId = answer.getQueryId();
			List<RightsCheckDetail> detail=map.get(queryId);
			answer.setRightsCheckDetail(detail);
		}
	}
	
	public List<ProductAnswer> convert(Collection<Answer> answers) {
		setRightsCheckDetail(answers);
		//indexed by foxVersionId
		Map<Long,ProductAnswer> productAnswerMap = new HashMap<>();
		for (Answer answer: answers) {
			Long foxVersionId = answer.getFoxVersionId();
			ProductAnswer productAnswer = null;
			if (productAnswerMap.containsKey(foxVersionId)) {
				productAnswer = productAnswerMap.get(foxVersionId);
			} else {
				productAnswer = getFrom(answer);
				productAnswerMap.put(foxVersionId, productAnswer);
			}
			addAnswer(productAnswer, answer);
		}
		List<ProductAnswer> list = toList(productAnswerMap);
		return list;
	}

}
