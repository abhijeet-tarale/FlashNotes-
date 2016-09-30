package com.psl.flashnotes.Idao;

import java.util.List;

import com.psl.flashnotes.bean.Queries;

public interface IQueryDao {

	public Queries addQuery(Queries query);

	public List<Queries> getAllQueries(int noteId);

	public Queries getQueryById(int queryId);
}
