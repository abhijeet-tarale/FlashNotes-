package com.psl.flashnotes.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psl.flashnotes.Idao.IQueryDao;
import com.psl.flashnotes.bean.Queries;

@Service
public class QueryService {
	@Autowired
	private IQueryDao queryDao;
	
	public Queries addQuery(Queries query)
	{
		System.out.println("In query Service !!!!!! ");
		query.setDateCreated(new Date());
		query.setLastUpdated(new Date());
		return queryDao.addQuery(query);
		
	}
	
	public List<Queries> getAllQueries(int noteId){
		return queryDao.getAllQueries(noteId);
	}
	public Queries getQueriesById( int queryId) {
		
		return queryDao.getQueryById(queryId);
	}
	
}
