import { STORE_REQUEST_KEY } from './store-request.const';
import { StoreRequest } from './store-request.decorator';

describe('StoreRequest Decorator', () => {
  it('should be defined', () => {
    expect(StoreRequest).toBeDefined();
  });

  it('should set metadata', () => {
    class Test {
      @StoreRequest()
      method() {
        return;
      }
    }

    const meta = Reflect.getMetadata(STORE_REQUEST_KEY, Test.prototype.method);
    expect(meta).toEqual(true);
  });
});
