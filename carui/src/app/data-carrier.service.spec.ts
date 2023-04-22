import { TestBed } from '@angular/core/testing';

import { DataCarrierService } from './data-carrier.service';

describe('DataCarrierService', () => {
  let service: DataCarrierService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DataCarrierService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
