import { registerAs } from '@nestjs/config';

export const databaseConfig = registerAs('database', () => ({
  name: process.env.DATABASE_NAME || 'test',
}));
