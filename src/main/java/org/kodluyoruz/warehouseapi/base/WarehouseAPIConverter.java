package org.kodluyoruz.warehouseapi.base;

/**
 * Service katmanı ile Data katmanı arasındaki objelerin değişimi için kullanılan converter.
 * @param <T>
 * @param <R>
 */
public interface WarehouseAPIConverter<T, R> {

    R convert(T input);
}
