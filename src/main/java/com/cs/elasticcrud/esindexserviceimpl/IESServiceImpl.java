package com.cs.elasticcrud.esindexserviceimpl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.cs.elasticcrud.esindexservice.IESService;

public class IESServiceImpl implements IESService {

	private static final String  PREETY = "?pretty";
	public String createIndex(String serverURL, String indexName) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String IndexURI = serverURL + "/" + indexName + PREETY;
		HttpPut httpPut = new HttpPut(IndexURI);
		try {
			httpPut.setEntity(new StringEntity(""));
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		httpPut.setHeader("Accept", "application/json");
		httpPut.setHeader("Content-type", "application/json");
		String responseBody=null;
		
		 ResponseHandler<String> responseHandler = response -> {
             int status = response.getStatusLine().getStatusCode();
             if (status >= 200 && status < 300) {
                 HttpEntity entity = response.getEntity();
                 return entity != null ? EntityUtils.toString(entity) : null;
             } else {
                 throw new ClientProtocolException("Unexpected response status: " + status);
             }
         };
        
		
		try {
			responseBody = httpclient.execute(httpPut, responseHandler);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         System.out.println("---------------Create Operation Happaning------------------------");
         System.out.println(responseBody);
     
		return responseBody;
	}

	public String deleteIndex(String serverURL, String indexName) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		String IndexURI = serverURL + "/" + indexName + PREETY;
		HttpDelete httpDelete = new HttpDelete(IndexURI);
		/*
		 * try { httpDelete.setEntity(new StringEntity("")); } catch
		 * (UnsupportedEncodingException e1) { // TODO Auto-generated catch block
		 * e1.printStackTrace(); }
		 */
		httpDelete.setHeader("Accept", "application/json");
		httpDelete.setHeader("Content-type", "application/json");
		String responseBody=null;
		
		 ResponseHandler<String> responseHandler = response -> {
             int status = response.getStatusLine().getStatusCode();
             if (status >= 200 && status < 300) {
                 HttpEntity entity = response.getEntity();
                 return entity != null ? EntityUtils.toString(entity) : null;
             } else {
                 throw new ClientProtocolException("Unexpected response status: " + status);
             }
         };
        
		
		try {
			responseBody = httpclient.execute(httpDelete, responseHandler);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         System.out.println("--------------Delete operation happining--------------------------");
         System.out.println(responseBody);
     
		return responseBody;
	}

}
