import { DynamicModule } from '@nestjs/common';
import { ConfigModule, ConfigService } from '@nestjs/config';
import { TypeOrmModule } from '@nestjs/typeorm';

export const DatabaseModule: DynamicModule = TypeOrmModule.forRootAsync({
  imports: [ConfigModule.forRoot()],
  inject: [ConfigService],
  useFactory: async (configService: ConfigService) => ({
    type: 'sqlite',
    database: configService.get('database.name'),
    synchronize: true,
    autoLoadEntities: true,
  }),
});
