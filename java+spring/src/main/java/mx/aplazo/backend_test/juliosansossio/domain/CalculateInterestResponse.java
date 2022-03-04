package mx.aplazo.backend_test.juliosansossio.domain;

import java.util.Date;

import io.swagger.v3.oas.annotations.media.Schema;

public class CalculateInterestResponse {
  @Schema(required = true)
  Integer payment_number;

  @Schema(required = true)
  Double amount;

  @Schema(required = true)
  Date payment_date;

  public Integer getPayment_number() {
    return payment_number;
  }

  public void setPayment_number(Integer payment_number) {
    this.payment_number = payment_number;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Date getPayment_date() {
    return payment_date;
  }

  public void setPayment_date(Date payment_date) {
    this.payment_date = payment_date;
  }
}
