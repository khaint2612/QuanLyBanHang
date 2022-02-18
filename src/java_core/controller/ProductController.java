package java_core.controller;

import java.util.Scanner;

import java_core.models.Product;
import java_core.validation.Input;
import java_core.App;

public class ProductController {
    Scanner sc = new Scanner(System.in);

    public void insertProduct() {
        int id = Input.inputInt(sc, "Nhap ma san pham:");
        System.out.println("Nhap ten san pham");
        String name = sc.nextLine();
        Float price = Input.inputFloat(sc, "Nhap gia san pham:");
        System.out.println("Mo ta san pham:");
        String description = sc.nextLine();
        int quantity = Input.inputInt(sc, "Nhap so luong san pham:");
        Product product = new Product(id, name, price, description, quantity);
        App.products.add(product);
    }

    private void row(Product product) {
        System.out.printf("%d%15s%18f%10d%15s", product.getId(), product.getName(), product.getPrice(),
                product.getQuantity(),product.getDescription());
    }

    private void header() {
        String header = String.format("%s%15s%15s%15s%15s", "Ma", "Ten", "Gia","So luong", "Mo ta");
        System.out.println(header);
        System.out.println("======================================================================");
    }

    public void showProduct() {
        System.out.println("Danh sach san pham");
        header();
        for (Product product : App.products) {
            row(product);
            System.out.println();
        }
    }

    public void updateProduct() {
        if (App.products.isEmpty()) {
            System.out.println("Danh sach rong");
        } else {
            Integer id = Input.inputInt(sc, "Nhap ma can tim");
            Product product = null;
            for (Product p : App.products) {
                if (p.getId() == id) {
                    product = p;
                }
            }
            if (product == null) {
                System.out.println("Khong co san pham nay trong danh sach");
                showProduct();
            } else {
                System.out.println("Nhap ten san pham");
                product.setName(sc.nextLine());
                product.setPrice(Input.inputFloat(sc, "Nhap gia san pham:"));
                System.out.println("Mo ta san pham:");
                product.setDescription(sc.nextLine());
            }
        }
    }

    public void removeProduct() {
        Product product = null;
        Integer id = Input.inputInt(sc, "Nhap ma can xoa");
        for (Product p : App.products) {
            if (p.getId() == id) {
                product = p;
                break;
            }
        }
        if (product == null) {
            System.out.println("Khong co san pham nay trong danh sach");
            showProduct();
        } else {
            App.products.remove(product);
            System.out.println("Da xoa thanh cong");
        }
    }

    public Product getById(int id) {
        Product product = null;
        for(Product p : App.products){
            if(id == p.getId()){
                product = p;
                break;
            }
        }
        return product;
    }
}