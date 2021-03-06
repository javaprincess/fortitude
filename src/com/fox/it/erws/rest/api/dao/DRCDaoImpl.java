package com.fox.it.erws.rest.api.dao;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CacheStoreMode;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;





import com.fox.it.erws.rest.api.datasource.DRCStoredProcedure;
import com.fox.it.erws.rest.api.model.drc.DRCRightsCheckRequiredRequest;
import com.fox.it.erws.rest.api.pojos.Answer;
import com.fox.it.erws.rest.api.pojos.AppControlParamRequiredFields;
import com.fox.it.erws.rest.api.pojos.ConsumingApplication;
import com.fox.it.erws.rest.api.pojos.ConsumingApplicationPOJO;
import com.fox.it.erws.rest.api.pojos.ProductList;
import com.fox.it.erws.rest.api.pojos.RightsCheckDetail;
import com.fox.it.erws.rest.api.pojos.RightsCheckRestrictionDetail;
import com.fox.it.erws.rest.api.util.IdsUtil;
import com.fox.it.erws.rest.api.validation.AskType;
import com.google.common.collect.Lists;


@Repository
public class  DRCDaoImpl implements DRCDao {
	private Logger log = Logger.getLogger(DRCDaoImpl.class);
	
	private static final int IN_LIMIT =1000;	
	
	@PersistenceUnit
	protected EntityManagerFactory entityManagerFactory;
	
	@PersistenceContext
	protected EntityManager entityManager;
	

    private static final String sql = "insert into APP_RGHTS_CHK_REQ (APP_NM,APP_RGHTS_CHK_REQ_ID,APP_REQ_DATE,ERM_RESPONSE_ID,CONTRACT_ID,TITLE_LIST_ID,TITLE_LIST_MAP_ID,PRODUCT_ID,FOX_VERSION_ID,TITLE_LICENSE_RIGHT_ID,FROM_DATE,TO_DATE,MLT_GROUP_ID,MEDIA_ID,TERRITORY_ID,LANGUAGE_ID,MOBILE_CELLULAR_WIRELESS,INTERNET_OPEN,INTERNET_CLOSED,FOX_ID,FIN_PROD_ID,APP_REQ_ID) " +
                                                             "values " + 
                                                             "(?,APP_RGHTS_CHK_REQ_SEQ.nextval,sysdate,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    
	
	public DRCDaoImpl(EntityManagerFactory eM) {
		setEntityManagerFactory(eM);
	}
	
	public DRCDaoImpl() {
	
	}
	
    public void setEntityManagerFactory(EntityManagerFactory eMF) {
    	entityManagerFactory = eMF;
    }
	
    public EntityManagerFactory getEntityManagerFactory() {
    	return this.entityManagerFactory;
    }
    
	public EntityManager getEntityManager() {
		return entityManager;

	}
	
	public void setEntityManager(EntityManager eM) {
		entityManager = eM;
	}
	
	
	

    public void create(ConsumingApplicationPOJO mm, EntityManager eM) {
           eM.createNativeQuery(sql)
           .setParameter(1,mm.getConsumingApplicationName())
           .setParameter(2,mm.getResponseId())
           .setParameter(3,mm.getContractId())
           .setParameter(4,mm.getTitleListId())
           .setParameter(5,mm.getTitleListMapId())
           .setParameter(6,mm.getReqProductId())
           .setParameter(7,mm.getReqFoxVersionId())
           .setParameter(8,mm.getTitleLicenseRightId())
           .setParameter(9,mm.getStartDate())
           .setParameter(10,mm.getEndDate())
           .setParameter(11,mm.getMltGroupId())
           .setParameter(12,mm.getMediaId())           
           .setParameter(13,mm.getTerritoryId())
           .setParameter(14,mm.getLanguageId())
           .setParameter(15,mm.getMobileCellWirelessIndicator())
           .setParameter(16,mm.getInternetOpenIndicator())
           .setParameter(17,mm.getInternetClosedIndicator())
           .setParameter(18,mm.getReqFoxId())
           .setParameter(19,mm.getReqFinProdId())
           .setParameter(20,mm.getRequestId())
           .executeUpdate();                    
    }
    
    public void create(Collection<ConsumingApplicationPOJO> list, EntityManager eM) {
      
        
    	for (ConsumingApplicationPOJO mm: list) {
        	     create(mm, eM);
                  
           }
           eM.flush();
    }

	
	public void remove(AppKeyData appKeyData, 
			String consumingApplicationName) {
		
		EntityManager eM = getEntityManagerFactory().createEntityManager();
		eM.getTransaction().begin();
		
		StringBuffer sql = new StringBuffer();
		sql.append("DELETE from ConsumingApplicationPOJO");
		sql.append(" ca where ca.");
		sql.append(appKeyData.getAppKeyField());
		sql.append("= :");
		sql.append(appKeyData.getAppKeyField());
		sql.append(" and ca.consumingApplicationName = :consumingApplicationName");
		

		eM.createQuery(
						sql.toString(), ConsumingApplicationPOJO.class)
						.setParameter(appKeyData.getAppKeyField(), appKeyData.getAppKeyValue())
						.setParameter("consumingApplicationName", consumingApplicationName)
						.executeUpdate();
				
			
		eM.getTransaction().commit();
		eM.close();
		 
	
	}
	

	
	public void save(Collection<ConsumingApplicationPOJO> pojoCollection) {
		EntityManager eM = getEntityManagerFactory().createEntityManager();

		//TODO clean transactions
		eM.getTransaction().begin();
		
		create(pojoCollection, eM);
		eM.getTransaction().commit();
		eM.close();
		
			
	}

	@SuppressWarnings("unchecked")
	public List<ConsumingApplicationPOJO> find(AppKeyData appKeyData) {
		EntityManager eM = getEntityManagerFactory().createEntityManager();
		
		return eM.createNamedQuery("findMeByTitleListId")
				.setParameter(appKeyData.getAppKeyField(), appKeyData.getAppKeyValue())
				.getResultList();
	}
	
	public Long findRunId(String applicationName, Long applicationValue) {
		EntityManager eM = getEntityManagerFactory().createEntityManager();
		
		ProductList productList = null;
		productList = (ProductList)eM.createNativeQuery(
					"SELECT run_id from app_prod_list_rghts_chk WHERE PROD_LIST_ID = " + applicationValue + " and app_nm = '" + applicationName + "'", ProductList.class)
					.getSingleResult(); 		
		eM.close();
		return productList.getRunId();
		
	}
	
	
	
	public Long getResponseId() {
		BigDecimal responseId = null;
		
		EntityManager eM = getEntityManagerFactory().createEntityManager();
		responseId = (BigDecimal) eM.createNativeQuery(
				"SELECT APP_RGHTS_CHK_RESPONSE_SEQ.nextval from dual")
				.getSingleResult();
		eM.close();
			
		
		
		return responseId.longValue();
	}
	
	@SuppressWarnings("unchecked")
	public Collection<RightsCheckRestrictionDetail> findRightsCheckRestrictionDetail(Long queryId) {
		EntityManager eM = getEntityManagerFactory().createEntityManager();
		Collection<RightsCheckRestrictionDetail> rightsCheckRestrictionDetailResultList = null;
		rightsCheckRestrictionDetailResultList = eM.createQuery(
				"SELECT r from RightsCheckRestrictionDetail r where r.queryId = :queryId")
				.setParameter("queryId", new Long(queryId))
				.getResultList();
		
		
		eM.close();
		return rightsCheckRestrictionDetailResultList;
	}
	
	@SuppressWarnings("unchecked")
	public Collection<RightsCheckDetail> findRightsCheckDetail(Long queryId) {
		EntityManager eM = getEntityManagerFactory().createEntityManager();
		Collection<RightsCheckDetail> rightsCheckDetailResultList = null;
		rightsCheckDetailResultList = eM.createQuery(
				"SELECT r from RightsCheckDetail r where r.queryId = :queryId")
				.setParameter("queryId", new Long(queryId))
				.getResultList();
		
		eM.close();
		log.debug("retrieved the rights check details.  There are this many: " + rightsCheckDetailResultList.size());
		return rightsCheckDetailResultList;
	}
	
	

	
	@SuppressWarnings("unchecked")
    public Collection<Answer> findAnswer(String applicationName,Long applicationValue) {
           EntityManager eM = getEntityManagerFactory().createEntityManager();
           StringBuffer sql = new StringBuffer();
           
           TypedQuery<Answer> answerQuery = null;
           Collection<Answer> answerCollection = null;
           
           
           sql.append("SELECT PLMQ.CRT_DT, PLMQ.CRT_NM, PLMQ.UPD_DT, PLMQ.UPD_NM, PLMQ.APP_PROD_LIST_MLT_QRY_ID, PLMQ.RUN_ID, ");
           sql.append(" PLMQ.CNTRCT_ID, PLMQ.TTL_LIST_MAP_ID, PLMQ.TTL_LCNS_RGHT_ID, PLMQ.MLT_GRP_ID, PLMQ.FOX_VERSION_ID, PLMQ.FROM_DT, ");
           sql.append(" PLMQ.TO_DT, PLMQ.MEDIA_ID, PLMQ.TRRTRY_ID, PLMQ.LNGG_ID, PLMQ.MOB_FLG, PLMQ.OPN_INET_FLG, PLMQ.CLSD_INET_FLG, ");
           sql.append(" PLMQ.WTHN_THRU_FLG, PLMQ.QRY_ID, PLMQ.STRT_TM, PLMQ.END_TM, PLMQ.STS_DESC, PLMQ.PROD_LIST_ID, PLMQ.WPR_PROD_ID, ");
           sql.append(" PLMQ.APP_INTRFC_PROD_ID, PLMQ.APP_RGHTS_CHK_REQ_ID, PLMQ.TTL_LIST_ID ,");
           sql.append(" RCQ.FOX_ID REQ_FOX_ID, RCQ.FOX_VERSION_ID REQ_FOX_VERSION_ID, RCQ.PRODUCT_ID REQ_PRODUCT_ID, RCQ.FIN_PROD_ID REQ_FIN_PROD_ID, ");
           sql.append(" NVL(RCS.PASS_FLG,0) PASS_FLG, RSN_TXT, ");
           sql.append(" RCS.STRT_DT RIGHTS_START_DATE, RCS.STRT_DT_CD RIGHTS_START_DATE_CODE, RCS.END_DT RIGHTS_END_DATE, RCS.END_DT_CD RIGHTS_END_DATE_CODE, ");
           sql.append(" RCS.RSTRCN_CDS INFO_CODES, RCS.GNRL_RSTRCN_CDS GENERAL_INFO_CODES, RCS.LCNSNG_RSTRCN_CDS LICENSING_INFO_CODES, RCS.MOT_RSTRCN_CDS MOT_INFO_CODES ");
           sql.append(" FROM APP_PROD_LIST_MLT_QRY PLMQ ");
           sql.append(" INNER JOIN APP_RGHTS_CHK_REQ RCQ ON RCQ.APP_RGHTS_CHK_REQ_ID=PLMQ.APP_RGHTS_CHK_REQ_ID ");
           sql.append(" LEFT OUTER JOIN RGHTS_CHK_SMRY RCS ON PLMQ.QRY_ID=RCS.QRY_ID ");
           sql.append(" WHERE PLMQ.PROD_LIST_ID=?   ");
           sql.append(" AND RCQ.APP_NM=? " );     
           sql.append(" ORDER BY RCQ.APP_RGHTS_CHK_REQ_ID ");
           
          answerQuery = (TypedQuery<Answer>) eM.createNativeQuery(sql.toString(), Answer.class)
          .setParameter(1, applicationValue)
          .setParameter(2, applicationName);          
          answerCollection = answerQuery.getResultList();
          eM.close();
          return answerCollection;
    }
	
	
	public <K extends ConsumingApplication> void rightsCheck(Long appKeyValue, String withinThroughoutFlag, String consumingApplicationName) {
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("drc-config.xml"); 
		DRCStoredProcedure drcStoredProcedure = (DRCStoredProcedure) ctx.getBean("drcStoredProcedure"); 
		if (withinThroughoutFlag == null) {
			drcStoredProcedure.getDRCRightsCheck(appKeyValue.longValue(), new String("T"), consumingApplicationName);
		} else { 
			drcStoredProcedure.getDRCRightsCheck(appKeyValue.longValue(), withinThroughoutFlag, consumingApplicationName); 
		}
		ctx.close();
	}
	
	
	@SuppressWarnings("unchecked")
	public List<AppControlParamRequiredFields> findAllAppControlParamRequiredFields(String appName) {
		EntityManager eM = getEntityManagerFactory().createEntityManager();
		List<AppControlParamRequiredFields> appControlParamRequiredFieldsList = null;
		
		String sql = new String("SELECT * from APP_CTRL_PARAM_REQ_FLDS where app_nm=\'" + appName + "\'");
			appControlParamRequiredFieldsList = eM.createNativeQuery(sql, AppControlParamRequiredFields.class)
					.setHint("javax.persistence.cache.storeMode", CacheStoreMode.BYPASS)
					.getResultList();			
		eM.close();
		return appControlParamRequiredFieldsList;
	}
	
	@SuppressWarnings("unchecked")
	public List<AppControlParamRequiredFields> findAllAppControlParamRequiredFields(String appName, AskType askType) {
		EntityManager eM = getEntityManagerFactory().createEntityManager();
		List<AppControlParamRequiredFields> appControlParamRequiredFieldsList = null;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT * from APP_CTRL_PARAM_REQ_FLDS where app_nm=\'" + appName + "\'" );
		
		//SEE IF THE entities are being cached
		//Cache cache = eM.getEntityManagerFactory().getCache();
		//Long entityId =0L;
		
		if (askType==AskType.DRC_CHECK) {
			sql.append(" and isAskType1 = 1");
		} else {
			sql.append(" and isAskType2 = 1");
		}
			
		sql.append(" order by CHECK_ORDER");
		appControlParamRequiredFieldsList = eM.createNativeQuery(sql.toString(), AppControlParamRequiredFields.class)
				.setHint("javax.persistence.cache.storeMode", CacheStoreMode.BYPASS)
				.getResultList();
		
		eM.close();
			
		
		return appControlParamRequiredFieldsList;
	}
	
	
	public boolean isRightsCheckRequired(DRCRightsCheckRequiredRequest DRCRightsCheckRequiredRequest,
			Long appKeyValue) {
		
		boolean isRightsCheckRequired = false;
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("drc-config.xml"); 
		DRCStoredProcedure drcStoredProcedure = (DRCStoredProcedure) ctx.getBean("drcStoredProcedure"); 
		isRightsCheckRequired = drcStoredProcedure.getIsRightsCheckRequired(DRCRightsCheckRequiredRequest, appKeyValue); 
		ctx.close();
		return isRightsCheckRequired;
						
	}


	
	private List<RightsCheckDetail> getRightsCheckDetailByQueryIdsInBatch(List<Long> ids) {
		if (ids==null||ids.isEmpty()) {
			return new ArrayList<RightsCheckDetail>();
		}
        EntityManager eM = getEntityManagerFactory().createEntityManager();		
		String sql = "Select * from RGHTS_CHK_DTL where QRY_ID in " + IdsUtil.getIdsAsListInParenthesis(ids);
		Query q = eM.createNativeQuery(sql, RightsCheckDetail.class);
		@SuppressWarnings("unchecked")
		List<RightsCheckDetail> details = q.getResultList();
		return details;		
	}
	
	private List<RightsCheckRestrictionDetail> getRightsCheckRestrictionDetailByQueryIdsInBatch(List<Long> ids) {
		if (ids==null||ids.isEmpty()) {
			return new ArrayList<RightsCheckRestrictionDetail>();
		}
        EntityManager eM = getEntityManagerFactory().createEntityManager();		
		String sql = "Select * from RGHTS_RSTRCN_CD_CHK_DTL where QRY_ID in " + IdsUtil.getIdsAsListInParenthesis(ids);
		Query q = eM.createNativeQuery(sql, RightsCheckRestrictionDetail.class);
		@SuppressWarnings("unchecked")
		List<RightsCheckRestrictionDetail> details = q.getResultList();
		return details;		
	}
	
	
	public List<RightsCheckDetail> getRightsCheckDetailByQueryIds(List<Long> ids) {
		List<RightsCheckDetail> details = new ArrayList<>(ids==null?0:ids.size());
		if (ids==null||ids.size()==0) return details;
		if (ids.size()<=IN_LIMIT) {
			details=getRightsCheckDetailByQueryIdsInBatch(ids);
		} else {
			List<List<Long>> splittedIds = Lists.partition(ids, IN_LIMIT);
			for (List<Long> batchIds: splittedIds) {
				details.addAll(getRightsCheckDetailByQueryIdsInBatch(batchIds));
			}
		}		
		return details;		
		
	}
	
	public List<RightsCheckRestrictionDetail> findRightsCheckRestrictionDetailByQueryIds(List<Long> ids) {
		List<RightsCheckRestrictionDetail> details = new ArrayList<>(ids==null?0:ids.size());
		if (ids==null||ids.size()==0) return details;
		if (ids.size()<=IN_LIMIT) {
			details=getRightsCheckRestrictionDetailByQueryIdsInBatch(ids);
		} else {
			List<List<Long>> splittedIds = Lists.partition(ids, IN_LIMIT);
			for (List<Long> batchIds: splittedIds) {
				details.addAll(getRightsCheckRestrictionDetailByQueryIdsInBatch(batchIds));
			}
		}		
		return details;		
		
	}


}

