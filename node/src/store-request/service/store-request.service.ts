import { Injectable } from '@nestjs/common';
import { InjectRepository } from '@nestjs/typeorm';
import { Repository } from 'typeorm';
import { StoreRequestEntity } from '../../database/models/store-request.entity';

const LIMIT = 10;

@Injectable()
export class StoreRequestService {
  constructor(
    @InjectRepository(StoreRequestEntity)
    private readonly storeRequestRepository: Repository<StoreRequestEntity>,
  ) {}

  async storeEvent(body: Object, response: Object) {
    const storeRequest = this.storeRequestRepository.create({
      request: JSON.stringify(body),
      response: JSON.stringify(response),
    });
    await this.storeRequestRepository.save(storeRequest);
  }

  async getEvents() {
    return this.storeRequestRepository.find({
      take: LIMIT,
      order: {
        id: 'DESC',
      },
    });
  }
}
