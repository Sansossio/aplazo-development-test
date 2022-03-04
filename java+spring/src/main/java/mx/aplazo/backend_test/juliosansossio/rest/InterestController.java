package mx.aplazo.backend_test.juliosansossio.rest;

import java.util.List;

import mx.aplazo.backend_test.juliosansossio.domain.CalculateInterest;
import mx.aplazo.backend_test.juliosansossio.domain.CalculateInterestResponse;
import mx.aplazo.backend_test.juliosansossio.domain.Interest;

public interface InterestController {
  public List<Interest> list();

  public List<CalculateInterestResponse> calculate(CalculateInterest body);
}
