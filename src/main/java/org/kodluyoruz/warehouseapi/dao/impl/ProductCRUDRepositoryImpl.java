package org.kodluyoruz.warehouseapi.dao.impl;

import org.kodluyoruz.warehouseapi.base.AbstractWarehouseAPIRepository;
import org.kodluyoruz.warehouseapi.dao.ProductCRUDRepository;
import org.kodluyoruz.warehouseapi.model.entites.ProductEntity;
import org.kodluyoruz.warehouseapi.model.entites.WarehouseEntity;

import java.util.Collection;

public class ProductCRUDRepositoryImpl extends AbstractWarehouseAPIRepository<ProductEntity, Long>
        implements ProductCRUDRepository {
}
