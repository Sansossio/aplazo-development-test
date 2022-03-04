import { StoreRequestService } from './store-request.service';

describe('Store Request Service', () => {
  let service: StoreRequestService;
  const repository = {
    create: jest.fn(),
    save: jest.fn(),
    find: jest.fn(),
  };

  beforeEach(() => {
    jest.resetAllMocks();
    service = new StoreRequestService(repository as any);
  });

  describe('Get events', () => {
    it('should return the events', async () => {
      const events = [
        {
          id: 1,
          request: '{}',
          response: '{}',
        },
        {
          id: 2,
          request: '{}',
          response: '{}',
        },
      ];
      repository.find.mockImplementation(async () => events);

      expect(await service.getEvents()).toMatchSnapshot();
    });

    it('should match filters', async () => {
      let response = null;
      repository.find.mockImplementation(async (filters) => {
        response = filters;
      });
      await service.getEvents();
      expect(response).not.toEqual(null);
      expect(response).toMatchSnapshot();
    });
  });

  describe('Store event', () => {
    it('should call create and save methods 1 time', async () => {
      await service.storeEvent({}, {});
      expect(repository.save).toHaveBeenCalledTimes(1);
      expect(repository.create).toHaveBeenCalledTimes(1);
    });

    it('should returns undefined', async () => {
      expect(await service.storeEvent({}, {})).toBeUndefined();
    });
  });
});
