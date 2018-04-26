package tests;

import org.testng.annotations.Test;

import lombok.extern.log4j.Log4j2;

/**
 * Created by Oleksii_Usachov on 4/26/2018
 */
@Log4j2
public class IntergationTest {

  @Test
  public void shouldRunIntegrationTest() {
    log.debug("Integration test run");
  }
}
