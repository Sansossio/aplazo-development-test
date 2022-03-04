import { SetMetadata } from '@nestjs/common';
import { STORE_REQUEST_KEY } from './store-request.const';

export const StoreRequest = () => SetMetadata(STORE_REQUEST_KEY, true);
