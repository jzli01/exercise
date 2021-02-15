package com.exercise.rest.util;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;


public class RestCalls {


	public static <V> V parseResponseToPojo(Response originalResponse, Class<V> responseClass){
		return originalResponse.readEntity(responseClass);
	}

	public static Response get(String url, String path, MultivaluedMap<String,String> requestHeaders, Map<String,String> queryParameters){
		List<Object> providers = new ArrayList<Object>();
		providers.add(new JacksonJsonProvider());
		WebClient client = WebClient.create(url, providers).path(path);
		client = client.accept("application/json;charset=UTF-8").headers(requestHeaders);

		if(queryParameters!=null){
			for(String key:queryParameters.keySet()){
				client.query(key, queryParameters.get(key));
			}
		}

		return client.get();
	}
	
	


}