package com.cs.elasticcrud;

import java.util.Scanner;

import com.cs.elasticcrud.esindexservice.IESService;
import com.cs.elasticcrud.esindexserviceimpl.IESServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
	private static String ESERVER_URL ;
	private static  final int  ZERO_INDEX = 0;
	private static IESService iESService = new IESServiceImpl();
    public static void main( String[] args )
   
    {
    	
        if(args.length > 0) {
        	
        	ESERVER_URL = args[ZERO_INDEX];
        	System.out.println(ESERVER_URL);
        	Scanner sc = new Scanner(System.in);
        	String c = "y";
        	while("Y".equalsIgnoreCase(c)) {
        		System.out.println("please chosse below option");
        		System.out.println("press 1 for create index In ES");
        		System.out.println("press 2 for delete index In ES ");
        		int ch = sc.nextInt();
        		String indexName ;;
        		switch(ch) {
        		case 1 : 
        			System.out.println("Enter Index Name ");
        			 indexName = sc.next();
        			iESService.createIndex(ESERVER_URL, indexName);
        			break;
        		case 2 : 
        			System.out.println("Enter Index Name ");
        			 indexName = sc.next();
        			iESService.deleteIndex(ESERVER_URL, indexName);
        			break;
        		
        		}
        		System.out.println("For continue Press Y otherwise N ");
        		c = sc.next();
        		
        	}
        	System.out.println(" Thank You ! for using me. BAY BAY See You Again");
        }else {
        	System.out.println("OOPS ! you did not provide elastic server URL , Kindly pass the elastic search server URL as an argument \n like java http://localhost:9200");
        }
    }
}
