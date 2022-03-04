import { ApiProperty } from '@nestjs/swagger';
import { StoreRequestEntity } from '../../database/models/store-request.entity';

export class StoreRequestDto implements StoreRequestEntity {
  @ApiProperty()
  id: number;

  @ApiProperty()
  request: string;

  @ApiProperty()
  response: string;
}
