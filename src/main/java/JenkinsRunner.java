import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import javax.xml.bind.DatatypeConverter;

import lombok.SneakyThrows;

import static org.testng.Assert.assertEquals;

/**
 * Created by Oleksii_Usachov on 4/26/2018
 */
public class JenkinsRunner {

  private static final String USER_ID = "Aleksey_U";
  private static final String USER_TOKEN = "327808b6cb1967e69c8589cd5a5f8478";
  private static final String JENKINS_URL = "http://localhost:8080/job/%s/build";
  private static final String JENKINS_PIPELINE = "Jenkins/job/Jenkins";

  @SneakyThrows
  public static void main(String[] args) {
    String theUrl = String.format(JENKINS_URL, JENKINS_PIPELINE);
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(theUrl);
    URI uri = builder.build().encode().toUri();

    HttpHeaders headers = createHttpHeaders(USER_ID, USER_TOKEN);
    HttpEntity<?> httpEntity = new HttpEntity<>(headers);

    ResponseEntity response = new RestTemplate().exchange(uri, HttpMethod.POST, httpEntity, String.class);

    assertEquals(response.getStatusCode(), HttpStatus.CREATED);
  }

  @SneakyThrows
  private static HttpHeaders createHttpHeaders(String user, String password) {
    String notEncoded = user + ":" + password;
    String encodedAuth = DatatypeConverter.printBase64Binary(notEncoded.getBytes("utf-8"));
    HttpHeaders headers = new HttpHeaders();
    headers.add(HttpHeaders.AUTHORIZATION, "Basic " + encodedAuth);

    return headers;
  }
}
