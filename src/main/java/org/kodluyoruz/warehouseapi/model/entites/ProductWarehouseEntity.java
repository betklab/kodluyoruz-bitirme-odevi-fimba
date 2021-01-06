package org.kodluyoruz.warehouseapi.model.entites;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PRODUCT_WAREHOUSE")
@Getter
@Setter
@NoArgsConstructor
public class ProductWarehouseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private ProductEntity product;

    @MapsId("id")
    @ManyToOne
    @JoinColumn(name = "WAREHOUSE_ID", nullable = false)
    private WarehouseEntity wareHouse;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "CREATED_BY", nullable = false)
    private User user;

    @Column(name = "STOCK_AMOUNT", nullable = false)
    private Long stockAmount = 0;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TRANSACTION_DATE")
    private Date transactionDate;

}
