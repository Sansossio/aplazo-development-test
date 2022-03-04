import { ApiProperty } from '@nestjs/swagger';
import { IsInt, IsNumber, IsPositive } from 'class-validator';

export class CalculateInterestRequestDto {
  @ApiProperty({ example: 100, description: 'The principal amount' })
  @IsNumber()
  @IsPositive()
  amount: number;

  @ApiProperty({ example: 3, description: 'The number of weeks' })
  @IsInt()
  @IsPositive()
  terms: number;

  @ApiProperty({ example: 5, description: 'The interest rate' })
  @IsNumber()
  @IsPositive()
  rate: number;
}
