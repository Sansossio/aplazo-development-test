import { InterestService } from './interest.service';

describe('InterestService', () => {
  let service: InterestService;

  jest.useFakeTimers().setSystemTime(new Date('2022-04-04').getTime());

  beforeEach(async () => {
    service = new InterestService();
  });

  it('should be defined', () => {
    expect(service).toBeDefined();
  });

  it('should calculate interest', () => {
    const request = {
      amount: 1000,
      rate: 10,
      terms: 12,
    };
    const response = service.calculateInterest(request);
    expect(response).toBeDefined();
    expect(response.length).toBe(12);
  });

  it('should calculate decimal interest response', () => {
    const request = {
      amount: 1000,
      rate: 1.25,
      terms: 12,
    };
    expect(service.calculateInterest(request)).toMatchSnapshot();
  });

  it('should calculate exact interest response', () => {
    const request = {
      amount: 1000,
      rate: 10,
      terms: 10,
    };
    expect(service.calculateInterest(request)).toMatchSnapshot();
  });
});
