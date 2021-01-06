package org.kodluyoruz.warehouseapi.converter;

import org.kodluyoruz.warehouseapi.base.WarehouseAPIConverter;
import org.kodluyoruz.warehouseapi.model.dto.ProductDTO;
import org.kodluyoruz.warehouseapi.model.entites.ProductEntity;

import java.util.Date;
import java.util.Objects;

public class ProductEntityToProductDTOConverter implements WarehouseAPIConverter<ProductEntity, ProductDTO> {
    @Override
    public ProductDTO convert(ProductEntity input) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(input.getId());
        productDTO.setName(input.getName());
        productDTO.setCode(input.getCode());
        productDTO.setStatus(input.getStatus());
        productDTO.setCreatedAt(Objects.isNull(input.getCreatedAt()) ? new Date() : input.getCreatedAt());
        productDTO.setUpdatedAt(input.getUpdatedAt());
        productDTO.setVatRate(input.getVatRate());
        productDTO.setVatAmount(input.getVatAmount());
        productDTO.setVatIncludedPrice(input.getVatIncludedPrice());
        productDTO.setPrice(input.getPrice());

        return productDTO;
    }
}
