import { NestFactory } from '@nestjs/core';
import { AppModule } from './app.module';

async function bootstrap() {
  const app = await NestFactory.create(AppModule);
  app.enableCors();
  await app.listen(process.env.PORT|| 3000);
}
bootstrap();
// "main": "src/main.ts",
// "bin" : "ts-node -r tsconfig-paths/register src/main.ts"
// "start": "ts-node -r tsconfig-paths/register src/main.ts",