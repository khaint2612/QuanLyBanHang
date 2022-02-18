package java_core.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class OrderDetail {
    private static Integer currentId = 0;
    private Integer id;
    private Integer orderId;
    private Integer productId;
    private Integer quantity;

    public OrderDetail(Integer orderId,Integer productId, Integer quantity){
        this.id = currentId++;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
    }
}
