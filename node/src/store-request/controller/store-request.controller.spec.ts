import { StoreRequestController } from './store-request.controller';

describe('StoreRequestController', () => {
  let controller: StoreRequestController;
  const service = {
    getEvents: jest.fn(),
    storeEvent: jest.fn(),
  };

  beforeEach(async () => {
    controller = new StoreRequestController(service as any);
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
  });

  it('should call service.getEvents', async () => {
    await controller.list();
    expect(service.getEvents).toHaveBeenCalled();
  });
});
