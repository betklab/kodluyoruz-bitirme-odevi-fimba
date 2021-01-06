package org.kodluyoruz.warehouseapi.dao.impl;

import org.kodluyoruz.warehouseapi.base.AbstractWarehouseAPIRepository;
import org.kodluyoruz.warehouseapi.dao.WarehouseOperationRepository;
import org.kodluyoruz.warehouseapi.model.entites.WarehouseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class WarehouseOperationRepositoryImpl extends AbstractWarehouseAPIRepository<WarehouseEntity, Long> implements WarehouseOperationRepository {

    @Override
    public boolean hasExistSameWarehouseCode(String warehouseCode) {
        Long result = getSession()
                .createQuery("select count(*) from WarehouseEntity where code=:givenCode", Long.class)
                .setParameter("givenCode", warehouseCode)
                .uniqueResult();
        return result > 0;
    }

    @Override
    @Transactional
    public void transfer(Long fromId, Long toId) {
        getSession()
                .createQuery("update ProductWarehouseEntity set wareHouseID=:toId where wareHouseID=:fromId")
                .setParameter("toId", toId)
                .setParameter("fromId", fromId)
                .executeUpdate();
    }

    @Override
    public boolean isActiveWarehouses(Long fromId, Long toId) {
        int result = (int) getSession()
                .createQuery("select count(*) from WarehouseEntity where id in (:ids) and status=:'ACTIVE'")
                .setParameter("ids", new Long[]{fromId, toId})
                .uniqueResult();

        return result == 2;

    }
}
