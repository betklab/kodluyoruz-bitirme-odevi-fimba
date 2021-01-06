package org.kodluyoruz.warehouseapi.converter;

import org.kodluyoruz.warehouseapi.base.WarehouseAPIConverter;
import org.kodluyoruz.warehouseapi.model.dto.ProductDTO;
import org.kodluyoruz.warehouseapi.model.dto.WarehouseDTO;
import org.kodluyoruz.warehouseapi.model.entites.ProductEntity;
import org.kodluyoruz.warehouseapi.model.enums.ProductStatus;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class ProductDTOToProductEntityConverter implements WarehouseAPIConverter<ProductDTO, ProductEntity> {
    @Override
    public ProductEntity convert(ProductDTO input) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(input.getId());
        productEntity.setName(input.getName());
        productEntity.setCode(input.getCode());
        productEntity.setStatus(input.getStatus());
        productEntity.setCreatedAt(Objects.isNull(input.getCreatedAt()) ? new Date() : input.getCreatedAt());
        productEntity.setUpdatedAt(input.getUpdatedAt());
        productEntity.setVatRate(input.getVatRate());
        productEntity.setVatAmount(input.getVatAmount());
        productEntity.setVatIncludedPrice(input.getVatIncludedPrice());
        productEntity.setPrice(input.getPrice());

        return productEntity;
    }
}
