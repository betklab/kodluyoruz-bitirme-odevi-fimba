package org.kodluyoruz.warehouseapi.dao;


public interface WarehouseOperationRepository {

    boolean hasExistSameWarehouseCode(String warehouseCode);
    void transfer(Long fromId, Long toId);
    boolean isActiveWarehouses(Long fromId, Long toId);
}
