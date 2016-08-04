package com.demo.services.employee;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Component
public class MaskInputHelper {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MaskInputHelper.class);
	 public static void change(JsonNode parent, String fieldName, String newValue) {
	        if (parent.has(fieldName)) {
	            ((ObjectNode) parent).put(fieldName, newValue);
	        }

	        for (JsonNode child : parent) {
	            change(child, fieldName, newValue);
	        }
	    }
	public static void main(String arg[]){
		String json1 = "{\"name\":\"sri\", \"city\":29 , \"list\":[{ \"address\": {\"streetAddress\": \"100 Wall Street\",\"city\": \"New York\" }}]}";
		String json2 = "{\"name\":\"sri\", \"age\":29 , \"list\":{ \"address\": {\"streetAddress\": \"100 Wall Street\",\"city\": \"New York\" }}}";
		
		//Address object with 2 fields
		String json3 = "{\"name\":\"sri\", \"age\":29 ,  \"address\": {\"streetAddress\": \"100 Wall Street\",\"city\": \"New York\" }}";
		
		String json4 = "{\"name\":\"sri\", \"age\":29 ,  \"address\": [{\"streetAddress\": \"100 Wall Street\",\"city\": \"New York\" }]}";
		 
		
		 LOGGER.info("json1:" + json1);
		 LOGGER.info(new MaskInputHelper().maskInput(json1,"city","XXX"));
		 LOGGER.info("json2:" + json2);
		 LOGGER.info(new MaskInputHelper().maskInput(json2,"streetAddress","???"));
		 
		 LOGGER.info("json3:" + json3);
		 LOGGER.info(new MaskInputHelper().maskInput(json3,"streetAddress","???"));
		 LOGGER.info("json4:" + json4);
		 LOGGER.info(new MaskInputHelper().maskInput(json4,"streetAddress","???"));
	}
	
	
	public  String maskInput(String requestString,String fieldToMask,String maskString) {
		 ObjectMapper mapper = new ObjectMapper();
		 String result=null;
	        JsonNode tree=null;
			try {
				tree = mapper.readTree(requestString);
				change(tree, fieldToMask, maskString);
			} catch (IOException e) {
				LOGGER.error("Exception:" ,e);
			}
			try {
				result=mapper.writerWithDefaultPrettyPrinter().writeValueAsString(tree);
			} catch (JsonProcessingException e) {
				LOGGER.error("Exception:" ,e);
			}
			 return result;
	}
}
