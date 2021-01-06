package org.kodluyoruz.warehouseapi.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.kodluyoruz.warehouseapi.base.WarehouseAPIResponseError;
import org.kodluyoruz.warehouseapi.converter.ProductDTOToProductEntityConverter;
import org.kodluyoruz.warehouseapi.converter.ProductEntityToProductDTOConverter;
import org.kodluyoruz.warehouseapi.converter.WarehouseDTOToWarehouseEntityConverter;
import org.kodluyoruz.warehouseapi.converter.WarehouseEntityToWarehouseDTOConverter;
import org.kodluyoruz.warehouseapi.dao.ProductCRUDRepository;
import org.kodluyoruz.warehouseapi.dao.ProductOperationRepository;
import org.kodluyoruz.warehouseapi.dao.WarehouseCRUDRepository;
import org.kodluyoruz.warehouseapi.dao.WarehouseOperationRepository;
import org.kodluyoruz.warehouseapi.model.dto.BaseIDDTO;
import org.kodluyoruz.warehouseapi.base.WarehouseAPIResponseHolder;
import org.kodluyoruz.warehouseapi.model.dto.ProductDTO;
import org.kodluyoruz.warehouseapi.model.dto.WarehouseDTO;
import org.kodluyoruz.warehouseapi.model.entites.ProductEntity;
import org.kodluyoruz.warehouseapi.model.entites.WarehouseEntity;
import org.kodluyoruz.warehouseapi.service.ProductCRUDService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ProductCRUDServiceImpl implements ProductCRUDService {
    private final ProductCRUDRepository productCRUDRepository;
    private final ProductOperationRepository productOperationRepository;
    private final ProductEntityToProductDTOConverter productEntityToProductDTOConverter;
    private final ProductDTOToProductEntityConverter productDTOToProductEntityConverter;

    @Override
    public WarehouseAPIResponseHolder<Collection<ProductDTO>> list() {
        Collection<ProductEntity> productEntities = productCRUDRepository.list();
        if (CollectionUtils.isEmpty(productEntities)){
            return new WarehouseAPIResponseHolder<>(HttpStatus.NOT_FOUND);
        }
        List<ProductDTO> productDTOList = productEntities.
                stream().
                map(productEntityToProductDTOConverter::convert).
                collect(Collectors.toList());
        return new WarehouseAPIResponseHolder<>(productDTOList, HttpStatus.OK);
    }

    @Override
    public WarehouseAPIResponseHolder<ProductDTO> create(ProductDTO data) {
        if (Objects.isNull(data)){
            return new WarehouseAPIResponseHolder<>(HttpStatus.NO_CONTENT);
        }

        String productName = data.getName();
        // TODO: VALIDATION
        if (productName.isEmpty()){
            return new WarehouseAPIResponseHolder<>(HttpStatus.NO_CONTENT);
        }
        ProductEntity productEntity = productDTOToProductEntityConverter.convert(data);
        productCRUDRepository.create(productEntity);

        return new WarehouseAPIResponseHolder<>(productEntityToProductDTOConverter
                .convert(productEntity), HttpStatus.OK);
    }

    @Override
    public WarehouseAPIResponseHolder<ProductDTO> update(ProductDTO data) {
        // TODO: VALIDATION

        ProductEntity updateEntity = productDTOToProductEntityConverter.convert(data);
        updateEntity.setUpdatedAt(new Date());
        ProductEntity updatedEntity = productCRUDRepository.update(updateEntity);
        return new WarehouseAPIResponseHolder<>(productEntityToProductDTOConverter.convert(updatedEntity),
                HttpStatus.OK);
    }

    @Override
    public WarehouseAPIResponseHolder<?> delete(BaseIDDTO data) {
        productCRUDRepository.delete(data.getId());
        return new WarehouseAPIResponseHolder<>(HttpStatus.OK);
    }
}
