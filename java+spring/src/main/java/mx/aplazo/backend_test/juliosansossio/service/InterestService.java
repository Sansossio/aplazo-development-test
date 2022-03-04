package mx.aplazo.backend_test.juliosansossio.service;

import java.util.List;

import mx.aplazo.backend_test.juliosansossio.domain.CalculateInterest;
import mx.aplazo.backend_test.juliosansossio.domain.CalculateInterestResponse;
import mx.aplazo.backend_test.juliosansossio.domain.Interest;

public interface InterestService {
  public List<Interest> list();

  public Interest save(Interest interest);

  public List<CalculateInterestResponse> calculate(CalculateInterest body);
}
