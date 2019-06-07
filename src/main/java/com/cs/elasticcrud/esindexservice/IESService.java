package com.cs.elasticcrud.esindexservice;

public interface IESService {
	
	String createIndex(String ServerURL,String indexName);
	String deleteIndex(String serverURL, String indexName);
}
