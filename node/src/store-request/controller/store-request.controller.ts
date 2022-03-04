import { Controller, Get } from '@nestjs/common';
import { ApiOperation, ApiResponse, ApiTags } from '@nestjs/swagger';
import { StoreRequestDto } from '../dto/store-request.dto';
import { StoreRequestService } from '../service/store-request.service';

@Controller('interest')
@ApiTags('Interest')
export class StoreRequestController {
  constructor(private readonly service: StoreRequestService) {}

  @Get('list')
  @ApiOperation({
    summary: 'Get last 100 events',
  })
  @ApiResponse({ type: StoreRequestDto, isArray: true })
  async list() {
    return this.service.getEvents();
  }
}
