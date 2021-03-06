package mx.aplazo.backend_test.juliosansossio.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import mx.aplazo.backend_test.juliosansossio.domain.CalculateInterest;
import mx.aplazo.backend_test.juliosansossio.domain.CalculateInterestResponse;
import mx.aplazo.backend_test.juliosansossio.repository.InterestRepository;

@SpringBootTest(properties = "spring.main.lazy-initialization=true", classes = { InterestServiceImpl.class })
public class InterestServiceCalculateTests {
  @Autowired
  InterestServiceImpl interestService;

  @MockBean
  InterestRepository mockInterestRepository;

  @Test
  public void shouldCalculateAndResponseAListOfThreeInterests() {
    CalculateInterest calculateInterest = new CalculateInterest();
    calculateInterest.setAmount(100.0);
    calculateInterest.setTerms(3);
    calculateInterest.setRate(0.1);

    List<CalculateInterestResponse> calculateInterestResponse = interestService.calculate(calculateInterest);

    assertEquals(calculateInterestResponse.size(), 3);
  }

  @Test
  public void shouldTheSumOfAllItemsShouldBeEqualToAmountPlusInterest () {
    CalculateInterest calculateInterest = new CalculateInterest();
    Double rate = 10.0;
    calculateInterest.setAmount(100.0);
    calculateInterest.setTerms(3);
    calculateInterest.setRate(rate);

    List<CalculateInterestResponse> calculateInterestResponse = interestService.calculate(calculateInterest);

    Double sum = 0.0;

    for (CalculateInterestResponse item : calculateInterestResponse) {
      sum += item.getAmount();
    }

    Double shouldBe = calculateInterest.getAmount() + (calculateInterest.getAmount() * calculateInterest.getRate() / 100);

    assertEquals(sum, shouldBe);
  }
}
