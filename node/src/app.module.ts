import { Module } from '@nestjs/common';
import { ConfigModule } from '@nestjs/config';
import { InterestModule } from './interest/interest.module';
import { DatabaseModule } from './database/database.module';
import config from './config';
import { StoreRequestModule } from './store-request/store-request.module';

@Module({
  imports: [
    ConfigModule.forRoot({
      load: config,
    }),
    StoreRequestModule,
    DatabaseModule,
    InterestModule,
  ],
})
export class AppModule {}
