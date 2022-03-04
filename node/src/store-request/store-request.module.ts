import { Module } from '@nestjs/common';
import { DiscoveryModule } from '@nestjs/core';
import { TypeOrmModule } from '@nestjs/typeorm';
import { StoreRequestEntity } from '../database/models/store-request.entity';
import { StoreRequestExplorer } from './store-request.explorer';
import { StoreRequestService } from './service/store-request.service';
import { StoreRequestController } from './controller/store-request.controller';

@Module({
  imports: [TypeOrmModule.forFeature([StoreRequestEntity]), DiscoveryModule],
  controllers: [StoreRequestController],
  providers: [StoreRequestService, StoreRequestExplorer],
})
export class StoreRequestModule {}
