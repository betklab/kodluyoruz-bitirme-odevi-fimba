package org.kodluyoruz.warehouseapi.dao;

import org.kodluyoruz.warehouseapi.model.entites.ProductWarehouseEntity;
import org.kodluyoruz.warehouseapi.model.entites.WarehouseEntity;

import java.util.Collection;

public interface ProductWarehouseCRUDRepository {

    Collection<ProductWarehouseEntity> list();

    ProductWarehouseEntity create(ProductWarehouseEntity warehouseEntity);

    ProductWarehouseEntity update(ProductWarehouseEntity warehouseEntity);

    void delete(Long id);


}
