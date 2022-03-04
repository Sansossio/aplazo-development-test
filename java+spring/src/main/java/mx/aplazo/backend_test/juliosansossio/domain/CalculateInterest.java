package mx.aplazo.backend_test.juliosansossio.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import io.swagger.v3.oas.annotations.media.Schema;

public class CalculateInterest {
  @Positive
  @NotNull
  @Schema(description = "The amount to be paid", defaultValue = "100")
  Double amount;

  @Positive
  @NotNull
  @Schema(description = "The number of payments", defaultValue = "3")
  Integer terms;

  @NotNull
  @Schema(description = "The interest rate", defaultValue = "5")
  Double rate;

  public CalculateInterest() {
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Integer getTerms() {
    return terms;
  }

  public void setTerms(Integer terms) {
    this.terms = terms;
  }

  public Double getRate() {
    return rate;
  }

  public void setRate(Double rate) {
    this.rate = rate;
  }

}
