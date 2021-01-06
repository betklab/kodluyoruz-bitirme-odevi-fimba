package org.kodluyoruz.warehouseapi.dao.impl;

import org.kodluyoruz.warehouseapi.base.AbstractWarehouseAPIRepository;
import org.kodluyoruz.warehouseapi.dao.ProductCRUDRepository;
import org.kodluyoruz.warehouseapi.dao.ProductWarehouseCRUDRepository;
import org.kodluyoruz.warehouseapi.model.entites.ProductEntity;
import org.kodluyoruz.warehouseapi.model.entites.ProductWarehouseEntity;

public class ProductWareHouseCRUDRepositoryImpl extends AbstractWarehouseAPIRepository<ProductWarehouseEntity, Long>
        implements ProductWarehouseCRUDRepository {
}
