package org.kodluyoruz.warehouseapi.dao;

import org.kodluyoruz.warehouseapi.model.entites.ProductEntity;

import java.text.CollationElementIterator;
import java.util.Collection;

public interface ProductCRUDRepository {
    Collection<ProductEntity> list();
    ProductEntity create(ProductEntity entity);
    ProductEntity update(ProductEntity entity);
    void delete(Long id);
}
