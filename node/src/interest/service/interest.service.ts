import { Injectable } from '@nestjs/common';
import { StoreRequest } from '../../store-request/decorator/store-request.decorator';
import { CalculateInterestRequestDto } from '../dto/calculate.request.interest.dto';
import { CalculateInterestResponseDto } from '../dto/calculate.response.interest.dto';

@Injectable()
export class InterestService {
  @StoreRequest()
  calculateInterest(
    data: CalculateInterestRequestDto,
  ): CalculateInterestResponseDto[] {
    const response: CalculateInterestResponseDto[] = [];
    const totalToPay = data.amount + (data.rate / 100) * data.amount;
    const totalPerPayment = totalToPay / data.terms;

    for (let i = 1; i <= data.terms; i++) {
      response.push({
        payment_number: i,
        amount: totalPerPayment,
        payment_date: new Date(),
      });
    }
    return response;
  }
}
