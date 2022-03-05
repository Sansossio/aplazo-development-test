package mx.aplazo.backend_test.juliosansossio.domain;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class CalculateInterestResponse {
  @Schema(required = true)
  Integer payment_number;

  @Schema(required = true)
  Double amount;

  @Schema(required = true)
  Date payment_date;
}
