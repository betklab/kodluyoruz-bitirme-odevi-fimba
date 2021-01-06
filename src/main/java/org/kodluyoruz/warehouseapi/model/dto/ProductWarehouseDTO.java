package org.kodluyoruz.warehouseapi.model.dto;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class ProductWarehouseDTO extends BaseIDDTO {
    private ProductDTO product;
    private WarehouseDTO warehouse;
    private Long stockAmount;
    private Date transactionDate;
    private UserDTO user;

}
