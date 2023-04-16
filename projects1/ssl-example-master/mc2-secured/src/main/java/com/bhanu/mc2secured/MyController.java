package com.bhanu.mc2secured;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLContext;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/mc2")
public class MyController {

  @GetMapping
  public String get() throws IOException, CertificateException, NoSuchAlgorithmException, KeyStoreException, KeyManagementException {
    final String password = "test1234";
    SSLContext sslContext = SSLContextBuilder
        .create()
        .loadTrustMaterial(ResourceUtils.getFile("/Users/b0k02nq/identity.p12"), password.toCharArray())
        .build();
    CloseableHttpClient client = HttpClients.custom()
        .setSSLContext(sslContext)
        .build();
    HttpComponentsClientHttpRequestFactory requestFactory
        = new HttpComponentsClientHttpRequestFactory();
    requestFactory.setHttpClient(client);
    RestTemplate restTemplate = new RestTemplate(requestFactory);

    String url = "https://localhost:8085/secured";

    HttpHeaders headers = new HttpHeaders();
    headers.setBasicAuth("user", "Mypassword");
    HttpEntity<String> entity = new HttpEntity<>("body", headers);

    ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    return "Result : " + response.getBody();
  }
}
