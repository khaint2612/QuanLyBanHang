package java_core.validation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    public static Integer inputInt(Scanner sc, String message) {
        while (true) {
            try {
                System.out.println(message);
                Integer value = Integer.parseInt(sc.nextLine());
                if (value < 0) {
                    System.err.println("Ban da nhap duoi 0");
                } else {
                    return value;
                }
            } catch (InputMismatchException ie) {
                System.out.println("Vui long nhap dung dinh dang");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Float inputFloat(Scanner sc, String message) {
        while (true) {
            try {
                System.out.println(message);
                Float value = Float.parseFloat(sc.nextLine());
                if (value <0){
                    System.err.println("Ban da nhap duoi 0");
                }else{
                    return value;
                }
            } catch (InputMismatchException ie) {
                System.err.println("Ban da nhap sai dinh dang");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
