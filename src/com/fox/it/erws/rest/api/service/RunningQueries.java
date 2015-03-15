package com.fox.it.erws.rest.api.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RunningQueries {

	private HashSet<ApplicationQuery> running = new HashSet<>();

		
		
		
	
	public RunningQueries() {
	}
	
	public boolean isRunning(ApplicationQuery applicationQuery) {
		return running.contains(applicationQuery);

	}
	
	public boolean isRunning(String applicationName, Long id) {
		ApplicationQuery applicationQuery = new ApplicationQuery(applicationName, id);
		return isRunning(applicationQuery);
	}
	
	public void setAsRunning(ApplicationQuery applicationQuery) {
		running.add(applicationQuery);		
		
	}
	
	public void setAsRunning(String applicationName,Long id) {
		ApplicationQuery applicationQuery = new ApplicationQuery(applicationName, id);
		setAsRunning(applicationQuery);
	}
	
	public void remove(ApplicationQuery applicationQuery) {
		running.remove(applicationQuery);
		
	}
	
	public void  remove(String applicationName,Long id) {
		ApplicationQuery applicationQuery = new ApplicationQuery(applicationName, id);
		remove(applicationQuery);
	}
	
	public void clear(String applicationName) {
		Set<ApplicationQuery> all = getAll();
		List<ApplicationQuery> remove = new ArrayList<>();
		for (ApplicationQuery q: all) {
			if (applicationName.equals(q.getApplicationName())) {
				remove.add(q);
			}
		}
		running.removeAll(remove);
	}
	
	public void clearAll() {
		running.clear();
	}
	
	public Set<ApplicationQuery> getAll() { 
		return running;
	}
	

}
