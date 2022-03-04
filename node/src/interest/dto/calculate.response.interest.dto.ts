import { ApiProperty } from '@nestjs/swagger';

export class CalculateInterestResponseDto {
  @ApiProperty()
  payment_number: number;

  @ApiProperty()
  amount: number;

  @ApiProperty()
  payment_date: Date;
}
