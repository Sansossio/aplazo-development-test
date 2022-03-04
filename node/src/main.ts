import { ValidationPipe } from '@nestjs/common';
import { ConfigService } from '@nestjs/config';
import { NestFactory } from '@nestjs/core';
import { DocumentBuilder, SwaggerModule } from '@nestjs/swagger';
import { AppModule } from './app.module';

async function bootstrap() {
  const app = await NestFactory.create(AppModule);

  app.useGlobalPipes(new ValidationPipe());

  const configService = app.get(ConfigService);

  const [swaggerEnable, swaggerTitle, swaggerDescription] = [
    configService.get('app.swagger.enable'),
    configService.get('app.swagger.title'),
    configService.get('app.swagger.description'),
  ];

  if (swaggerEnable) {
    const config = new DocumentBuilder()
      .setTitle(swaggerTitle)
      .setDescription(swaggerDescription)
      .setVersion(process.env.npm_package_version)
      .build();
    const document = SwaggerModule.createDocument(app, config);
    SwaggerModule.setup(configService.get('app.swagger.path'), app, document);
  }

  await app.listen(process.env.APP_PORT || 3000, async () => {
    console.log(`Application is running on: ${await app.getUrl()}`);
  });
}
void bootstrap();
