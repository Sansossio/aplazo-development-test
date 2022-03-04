import { Module } from '@nestjs/common';
import { InterestController } from './controller/interest.controller';
import { InterestService } from './service/interest.service';

@Module({
  controllers: [InterestController],
  providers: [InterestService],
})
export class InterestModule {}
