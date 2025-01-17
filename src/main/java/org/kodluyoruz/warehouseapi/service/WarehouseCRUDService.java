package org.kodluyoruz.warehouseapi.service;

import org.kodluyoruz.warehouseapi.base.WarehouseAPICRUDBaseService;
import org.kodluyoruz.warehouseapi.base.WarehouseAPIResponseHolder;
import org.kodluyoruz.warehouseapi.model.dto.WarehouseDTO;

public interface WarehouseCRUDService extends WarehouseAPICRUDBaseService<WarehouseDTO> {
    WarehouseAPIResponseHolder<?> transfer(Long fromId, Long toId);

}
