import { Test, TestingModule } from '@nestjs/testing';
import { InterestService } from '../service/interest.service';
import { InterestController } from './interest.controller';

describe('InterestController', () => {
  let controller: InterestController;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      controllers: [InterestController],
      providers: [InterestService],
    }).compile();

    controller = module.get<InterestController>(InterestController);
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
  });
});
