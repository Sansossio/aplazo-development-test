package mx.aplazo.backend_test.juliosansossio.rest;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import mx.aplazo.backend_test.juliosansossio.domain.CalculateInterest;
import mx.aplazo.backend_test.juliosansossio.service.InterestServiceImpl;

@SpringBootTest(properties = "spring.main.lazy-initialization=true",
classes = {InterestControllerImpl.class})
public class InterestControllerTests {
  @Autowired
  InterestControllerImpl interestController;

  @MockBean
  InterestServiceImpl interestService;

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

  @Test
  public void shouldCallRepositorySaveMethodOneTime() {
    CalculateInterest calculateInterest = new CalculateInterest();
    calculateInterest.setAmount(100.0);
    calculateInterest.setTerms(3);
    calculateInterest.setRate(0.1);

    interestController.calculate(calculateInterest);

    verify(interestService, times(1)).save(Mockito.any());
  }
}
