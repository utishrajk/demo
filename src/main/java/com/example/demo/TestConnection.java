package com.example.demo;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

public class TestConnection {
	
	public static void main(String[] args) throws Exception {
		
		SSLContext sslcontext = SSLContexts.createSystemDefault();
		SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(
		        sslcontext, new String[] { "TLSv1", "SSLv3" }, null,
		        SSLConnectionSocketFactory.getDefaultHostnameVerifier());

		Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
		        .register("http", PlainConnectionSocketFactory.INSTANCE)
		        .register("https", sslConnectionSocketFactory)
		        .build();
		PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager(socketFactoryRegistry);

		HttpClient httpclient = HttpClients.custom()
		    .setSSLSocketFactory(sslConnectionSocketFactory)
		    .setConnectionManager(cm)
		    .build();
		
		HttpGet request = new HttpGet("https://api.coinmarketcap.com/v1/ticker/");
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpResponse response = client.execute(request);
		System.out.println(">>" + response);
		
	}

}
