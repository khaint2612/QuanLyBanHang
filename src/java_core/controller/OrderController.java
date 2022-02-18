package java_core.controller;

import java_core.App;
import java_core.models.Order;
import java_core.models.OrderDetail;
import java_core.models.Product;
import java_core.validation.Input;

import java.util.Scanner;
public class OrderController {
    Scanner sc = new Scanner(System.in);

    public void orders(){
        System.out.println("-------------Mua san pham------------");
        Integer id = Input.inputInt(sc, "Ma dat hang");
        System.out.println("Nhap ten khach hang");
        String customerName = sc.nextLine();
        System.out.println("So dien thoai");
        String phoneNumber = sc.nextLine();
        System.out.println("Nhap email");
        String email = sc.nextLine();
        Order order = new Order();
        order.setId(id);
        order.setCustomerName(customerName);
        order.setPhoneNumber(phoneNumber);
        order.setEmail(email);
        while (true) {
            Integer productId = Input.inputInt(sc, "Nhap ma san pham:");
            if(productId == 0){
                break;
            }
            Integer amount = Input.inputInt(sc, "Nhap so luong san pham:");
            Product p = null;
            for (Product product : App.products) {
                if(product.getId() == productId){
                    p = product;
                    break;
                }
            }
            if(p == null){
                System.out.println("Khong co san pham nay trong danh sach");
            }else{
                OrderDetail ordersDetail = new OrderDetail(order.getId(),productId,amount);
                order.getOrders().add(ordersDetail);
            }
        }
        
        App.ORDERS.add(order);
    }

    public void showOrder(){
        System.out.println("Danh sach hoa don");
        String header = String.format("%s%30s%30s%15s", "Ma","Ten khach hang","So dien thoai","Email");
        System.out.println(header);
        System.out.println("=================================================================================");
        ProductController productController = new ProductController();
        for (Order order : App.ORDERS) {
            String row = String.format("%s%25s%30s%20s",order.getId(),order.getCustomerName()
                            ,order.getPhoneNumber(),order.getEmail());
            System.out.println(row);
            String headerOrderDetails = String.format("%10s%20s%20s%20s",
                            "STT","Ten san pham","Gia","So luong");
            System.out.println(headerOrderDetails);
            System.out.println("====================================================================================");
            int i = 1;
            for(OrderDetail orderDetail : order.getOrders()){
                Product product = productController.getById(orderDetail.getProductId());
                System.out.printf("%10s%15s%25%15s",i,product.getName(),product.getPrice(),product.getQuantity());
                System.out.println();
                i++;
            }
        }
    }
}
