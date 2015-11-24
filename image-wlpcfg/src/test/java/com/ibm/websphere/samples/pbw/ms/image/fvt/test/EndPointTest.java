/*******************************************************************************
 * Copyright (c) 2015 IBM Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.ibm.websphere.samples.pbw.ms.image.fvt.test;

import static org.junit.Assert.assertTrue;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Tests that the image service is correctly responding to requests.
 * It does not perform only visual validation of the returned image,
 * just that one was returned (when expected).
 *
 */
public class EndPointTest {
	private static String port;
	private static String contextRoot;
	private static final String STRAWBERRIES = "/V0006";
	private static final String INVALID = "/invalid";
	
	private enum RequestType {
		GET, PUT		//need to look these up from somewhere else
	}

	@BeforeClass
	public static void beforeClass() {
		port = System.getProperty("liberty.test.port");
		contextRoot = "http://localhost:" + port + "/images/product/inventory";
	}
	
	/*
	 * Basic test to see if we can get back an image that exists in the service
	 */
	@Test
	public void testGetStrawberries() {
        String url = contextRoot + STRAWBERRIES;
        sendRequest(url, RequestType.GET, PBWImage.class, 200);
	}
	
	/*
	 * Test that requests for non-existant images returns a 404
	 */
	@Test
	public void testGetInvalid() {
        String url = contextRoot + INVALID;
        sendRequest(url, RequestType.GET, PBWImage.class, 404);
	}
	
	
	/*
	 * General purpose rest client call of the service
	 */
	private Object sendRequest(String url, RequestType requestType, Class<?> messageReader, int expectedStatus ) {
		System.out.println("Testing " + url);
		Client client = ClientBuilder.newClient();
		client.register(BinaryMessageReader.class);
		WebTarget target = client.target(url);
		Invocation.Builder invoBuild  = target.request();
		Response response = null;
		try {
			response = invoBuild.build(requestType.toString(), null).invoke();
			assertTrue("Incorrect response code: " + response.getStatus(), response.getStatus() == expectedStatus);
			return response.readEntity(messageReader);
		} finally {
			response.close();
		}
	}
}
