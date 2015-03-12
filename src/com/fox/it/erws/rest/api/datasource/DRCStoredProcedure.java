package com.fox.it.erws.rest.api.datasource;

import java.sql.Timestamp;
import java.sql.Types;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.object.StoredProcedure;

import com.fox.it.erws.rest.api.model.drc.DRCRightsCheckRequiredRequest;


//executes stored procedure to get DRC
//Rights_Check_For_Product_List
public class DRCStoredProcedure {
	
	private JdbcTemplate jdbcTemplate;
	
	private RightsCheckForProductList sProc;
	
	private class RightsCheckForProductList extends StoredProcedure{
		private static final String SPROC_NAME = "INTERFACES_PC.Rights_Check_For_Product_List";
		
		
		public RightsCheckForProductList(DataSource datasource) {
			super(datasource, SPROC_NAME);
			try {
				declareParameter(new SqlParameter("PRODUCT_ID", Types.INTEGER));
				declareParameter(new SqlParameter("WITHIN_THROUGHOUT_FLG", Types.VARCHAR));
				declareParameter(new SqlParameter("APP_NM", Types.VARCHAR));
				
				compile();
			
			} catch (Exception e) {
				e.getMessage();
			}
		}
		
		public Object execute(long productListId, String withinThroughout, String appName) {
			Map<String,Object> results = super.execute(productListId, withinThroughout, appName);
			return results.get(productListId);
		}
			
	} 

	public void setDataSource(DataSource source) {
		this.jdbcTemplate = new JdbcTemplate(source);
		this.sProc =  new RightsCheckForProductList(this.jdbcTemplate.getDataSource());
	}

	public Object getDRCRightsCheck(long appKeyValue, String withinThroughout, String appName) {
		return sProc.execute(appKeyValue, withinThroughout, appName);
	}
	
	public boolean getIsRightsCheckRequired(DRCRightsCheckRequiredRequest DRCRightsCheckRequiredRequest,
			Long appKeyValue){
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
		.withCatalogName("INTERFACES_PC")
		.withFunctionName("IS_RIGHTS_CHECK_REQUIRED_PL")
		.declareParameters(
				new SqlParameter("PRODUCT_LIST_ID", Types.INTEGER),
				new SqlParameter("LAST_RIGHTS_CHECK_DATE", Types.TIMESTAMP),
				new SqlParameter("APP_NM", Types.VARCHAR),
				new SqlOutParameter("result", Types.VARCHAR)
				);
		
	
		System.out.println("timestamp: " +  DRCRightsCheckRequiredRequest.getDateTimeOfLastCheck());
		
		Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(appKeyValue, DRCRightsCheckRequiredRequest.getDateTimeOfLastCheck(), DRCRightsCheckRequiredRequest.getConsumingApplicationName());
		if (simpleJdbcCallResult.get("result").equals("N"))
			return false;
		else
			return true;
			
	}



}
