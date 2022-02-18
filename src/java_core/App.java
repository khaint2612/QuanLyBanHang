package java_core;

import java_core.controller.OrderController;
import java_core.controller.ProductController;
import java_core.models.Order;
import java_core.models.Product;
import java_core.validation.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static final List<Product> products = new ArrayList<Product>();
    public static final List<Order> ORDERS = new ArrayList<Order>();

    public static void main(String[] args) throws Exception {
        ProductController controller = new ProductController();
        Scanner sc = new Scanner(System.in);
        OrderController orderController = new OrderController();
        while (true) {
            System.out.println("----------------Danh sach chuc nang---------------");
            System.out.println("1.Them san pham moi");
            System.out.println("2.Hien thi san pham");
            System.out.println("3.Sua san pham");
            System.out.println("4.Xoa san pham");
            System.out.println("5.Mua hang");
            System.out.println("6.Hien thi don dat hang");
            System.out.println("0.Thoat");
            int choose = Input.inputInt(sc, "Chon chuc nang");
            switch (choose) {
                case 1:
                    controller.insertProduct();
                    break;
                case 2:
                    controller.showProduct();
                    break;
                case 3:
                    controller.updateProduct();
                    break;
                case 4:
                    controller.removeProduct();
                    break;
                case 5:
                    orderController.orders();
                    break;
                case 6:
                    orderController.showOrder();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Vui long chon 1 chuc nang");
                    break;
            }
        }
    }
}
