import { Injectable, OnModuleInit } from '@nestjs/common';
import { InstanceWrapper } from '@nestjs/core/injector/instance-wrapper';
import { DiscoveryService, MetadataScanner, Reflector } from '@nestjs/core';
import { STORE_REQUEST_KEY } from './decorator/store-request.const';
import { StoreRequestService } from './service/store-request.service';

@Injectable()
export class StoreRequestExplorer implements OnModuleInit {
  constructor(
    private readonly service: StoreRequestService,

    private readonly discoveryService: DiscoveryService,
    private readonly metadataScanner: MetadataScanner,
    private readonly reflector: Reflector,
  ) {}

  private lookupHandlers(instance: Record<string, Function>, key: string) {
    const methodRef = instance[key];
    const config = this.reflector.get(STORE_REQUEST_KEY, methodRef);

    if (!config) {
      return;
    }

    instance[key] = async (...args: any[]) => {
      const response = await methodRef(...args);
      if (args.length === 1) {
        [args] = args;
      }
      void this.service.storeEvent(args, response);
      return response;
    };
    instance[key].bind(instance);
  }

  onModuleInit() {
    const instances: InstanceWrapper[] = [
      ...this.discoveryService.getControllers(),
      ...this.discoveryService.getProviders(),
    ];

    instances
      .filter((wrapper) => wrapper.isDependencyTreeStatic())
      .forEach(({ instance }: InstanceWrapper) => {
        if (!instance || !Object.getPrototypeOf(instance)) {
          return;
        }
        this.metadataScanner.scanFromPrototype(
          instance,
          Object.getPrototypeOf(instance),
          (key: string) => this.lookupHandlers(instance, key),
        );
      });
  }
}
