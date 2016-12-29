package com.lovi.msa.query;

import com.lovi.msa.model.Movie;
import com.lovi.searchbox.annotation.QueryController;
import com.lovi.searchbox.annotation.QueryFunction;
import com.lovi.searchbox.query.Criteria;
import com.lovi.searchbox.query.Query;
import com.lovi.searchbox.query.QueryHolder;

@QueryController
public class QueryFunctions {

	@QueryFunction("query1")
	public QueryHolder query1() throws Exception{
		
		Criteria c = Criteria
				.where("@parm_key").is("@parm_value");
		
		Query query = new Query(c);
		
		return new QueryHolder(Movie.class, query);
		
	}
	
	@QueryFunction("query2")
	public QueryHolder query2() throws Exception{
		
		Criteria c = Criteria
				.where("@parm_key").searchByPrefix("@parm_value");
		
		Query query = new Query(c);
		
		return new QueryHolder(Movie.class, query);
		
	}
	
}
