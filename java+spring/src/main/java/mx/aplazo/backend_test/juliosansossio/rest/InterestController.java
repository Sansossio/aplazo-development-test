package mx.aplazo.backend_test.juliosansossio.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import mx.aplazo.backend_test.juliosansossio.domain.CalculateInterest;
import mx.aplazo.backend_test.juliosansossio.domain.CalculateInterestResponse;
import mx.aplazo.backend_test.juliosansossio.domain.Interest;
import mx.aplazo.backend_test.juliosansossio.service.InterestService;

@RestController
@RequestMapping("/interest")
@Tag(name = "Interest")
public class InterestController {
  @Autowired
  private InterestService interestService;

  @GetMapping("list")
  @Operation(summary = "List all interests")
  public List<Interest> list() {
    return interestService.list();
  }

  @PostMapping("calculate")
  @Operation(summary = "Calculate interest")
  public List<CalculateInterestResponse> calculate(@RequestBody CalculateInterest body) {
    return interestService.calculate(body);
  }
}
