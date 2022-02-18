package java_core.models;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Order {
    private Integer id;
    private String customerName;
    private String phoneNumber;
    private List<OrderDetail> orders = new ArrayList<OrderDetail>();
    private String email;
}
