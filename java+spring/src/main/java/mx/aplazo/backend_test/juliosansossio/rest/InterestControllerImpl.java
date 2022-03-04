package mx.aplazo.backend_test.juliosansossio.rest;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import mx.aplazo.backend_test.juliosansossio.domain.CalculateInterest;
import mx.aplazo.backend_test.juliosansossio.domain.CalculateInterestResponse;
import mx.aplazo.backend_test.juliosansossio.domain.Interest;
import mx.aplazo.backend_test.juliosansossio.service.InterestServiceImpl;

@RestController
@RequestMapping("/interest")
@Tag(name = "Interest")
@Slf4j
public class InterestControllerImpl implements InterestController {
  @Autowired
  private InterestServiceImpl interestService;

  @GetMapping("list")
  @Operation(summary = "List all interests")
  public List<Interest> list() {
    return interestService.list();
  }

  @PostMapping("calculate")
  @Operation(summary = "Calculate interest")
  public List<CalculateInterestResponse> calculate(@RequestBody CalculateInterest body) {
    List<CalculateInterestResponse> response = interestService.calculate(body);

    ObjectMapper Obj = new ObjectMapper();
    try {
      this.interestService.save(Interest.create(
          Obj.writeValueAsString(body),
          Obj.writeValueAsString(response)));
    } catch (IOException e) {
      log.error("Error saving request: " + e.getMessage(), e);
    }

    return response;
  }
}
