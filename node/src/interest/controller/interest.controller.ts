import { Body, Controller, Post } from '@nestjs/common';
import { ApiOperation, ApiResponse, ApiTags } from '@nestjs/swagger';
import { CalculateInterestRequestDto } from '../dto/calculate.request.interest.dto';
import { CalculateInterestResponseDto } from '../dto/calculate.response.interest.dto';
import { InterestService } from '../service/interest.service';

@Controller('interest')
@ApiTags('Interest')
export class InterestController {
  constructor(private readonly service: InterestService) {}

  @Post('calculate')
  @ApiOperation({ summary: 'Calculate the interest payments' })
  @ApiResponse({ type: CalculateInterestResponseDto, isArray: true })
  async calculate(@Body() body: CalculateInterestRequestDto) {
    return this.service.calculateInterest(body);
  }
}
