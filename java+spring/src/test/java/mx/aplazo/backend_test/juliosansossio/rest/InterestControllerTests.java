package mx.aplazo.backend_test.juliosansossio.rest;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import mx.aplazo.backend_test.juliosansossio.domain.CalculateInterest;
import mx.aplazo.backend_test.juliosansossio.service.InterestService;

@SpringBootTest(properties = "spring.main.lazy-initialization=true",
classes = {InterestController.class})
public class InterestControllerTests {
  @Autowired
  InterestController interestController;

  @MockBean
  InterestService interestService;

  @Test
  public void shouldCallServiceListMethod () {
    interestController.list();
    verify(interestService, times(1)).list();
  }

  @Test
  public void shouldCallServiceCalculateMethod () {
    interestController.calculate(new CalculateInterest());
    verify(interestService, times(1)).calculate(Mockito.any());
  }
}
