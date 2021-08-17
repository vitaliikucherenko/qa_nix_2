package nixsolutions.com.controller;

import nixsolutions.com.entity.Product;
import nixsolutions.com.service.ProductService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class ProductController {
    private ProductService productService = new ProductService();

    public void start() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("select your option");
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                crud(position, reader);
                position = reader.readLine();
                if (position.equals("0")) {
                    System.exit(0);
                }
                crud(position, reader);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void runNavigation() {
        System.out.println();
        System.out.println("if you want create product, please enter 1");
        System.out.println("if you want update product, please enter 2");
        System.out.println("if you want delete product, please enter 3");
        System.out.println("if you want findById product, please enter 4");
        System.out.println("if you want findAll product, please enter 5");
        System.out.println("if you want exit, please enter 0");
        System.out.println();
    }

    private void crud(String position, BufferedReader reader) {
        switch (position) {
            case "1":
                create(reader);
                break;
            case "2":
                update(reader);
                break;
            case "3":
                delete(reader);
                break;
            case "4":
                findById(reader);
                break;
            case "5":
                findAll(reader);
                break;
        }
        runNavigation();
    }

    private void create(BufferedReader reader) {
        System.out.println("ProductController.create");
        // try {
        System.out.println("Please, enter product name");
        String name = getTextFromConsole(reader);
        //String name = reader.readLine();
        System.out.println("Please, enter product description");
        String description = getTextFromConsole(reader);
        //String description = reader.readLine();
        System.out.println("Please, enter product count");
        String countString = getNumberFromConsole(reader);
        //String countString = reader.readLine();
        int count = Integer.parseInt(countString);
        System.out.println("Please, enter product price");
        String priceString = getDoubleFromConsole(reader);
        //String priceString = reader.readLine();
        double price = Double.parseDouble(priceString);
        Product productA = new Product();
        productA.setName(name);
        productA.setDescription(description);
        productA.setCount(count);
        productA.setPrice(price);
        productService.create(productA);
        //   } catch (IOException e) {
        //      System.out.println("problem: = " + e.getMessage());
        //  }
    }

    private void update(BufferedReader reader) {
        System.out.println("ProductController.update");
        //try {
        System.out.println("Please, enter product id");
        String id = getTextFromConsole(reader);
        //String id = reader.readLine();
        System.out.println("Please, enter product name");
        String name = getTextFromConsole(reader);
        //String name = reader.readLine();
        System.out.println("Please, enter product description");
        String description = getTextFromConsole(reader);
        //String description = reader.readLine();
        System.out.println("Please, enter product count");
        String countString = getNumberFromConsole(reader);
        //String countString = reader.readLine();
        int count = Integer.parseInt(countString);
        System.out.println("Please, enter product price");
        String priceString = getDoubleFromConsole(reader);
        //String priceString = reader.readLine();
        double price = Double.parseDouble(priceString);
        Product productA = new Product();
        productA.setId(id);
        productA.setName(name);
        productA.setDescription(description);
        productA.setCount(count);
        productA.setPrice(price);
        productService.update(productA);
        //} catch (IOException e) {
        //System.out.println("problem: = " + e.getMessage());
        //}
    }

    private void delete(BufferedReader reader) {
        System.out.println("ProductController.delete");
        //try {
        System.out.println("Please, enter id");
        String id = getTextFromConsole(reader);
        //String id = reader.readLine();
        productService.delete(id);
        //} catch (IOException e) {
        //System.out.println("problem: = " + e.getMessage());
        //}
    }

    private void findById(BufferedReader reader) {
        System.out.println("ProductController.findById");
        //try {
        System.out.println("Please, enter id");
        String id = getTextFromConsole(reader);
        //String id = reader.readLine();
        Product productA = productService.findById(id);
        System.out.println("product = " + productA);
        //} catch (IOException e) {
        //System.out.println("problem: = " + e.getMessage());
        //}
    }

    private void findAll(BufferedReader reader) {
        System.out.println("ProductController.findAll");
        Product[] products = productService.findAll();
        for (Product productA : products) {
            System.out.println("product = " + productA);
        }
    }

    //check data
    public static String getTextFromConsole(BufferedReader getData) {
        String s = "";
        boolean success = false;
        while (!success) {
            try {
                s = getData.readLine();
                //  System.out.println("Please, enter data");
                if (s == null || s.length() == 0 || s.trim().length() <= 0) {
                    throw new Exception();
                }//close if
                success = true;
            } //close try
            catch (Exception e) {
                success = false;
                System.out.println("Please, enter data");
            } //close catch
        } //close while
        return s;
    }

    //check number data
    public static String getNumberFromConsole(BufferedReader getData) {
        int number;
        String s = "";
        boolean success = false;
        while (!success) {
            try {
                s = getData.readLine();
                number = Integer.parseInt(s);
                if (s.length() == 0 || s.trim().length() < 0) {
                    throw new Exception();
                }//close if
                success = true;
            } //close try
            catch (Exception e) {
                success = false;
                System.out.println("Please, enter data");
            } //close catch
        } //close while
        return s;
    }

    //check double data
    public static String getDoubleFromConsole(BufferedReader getData) {
        double number;
        String s = "";
        boolean success = false;
        while (!success) {
            try {
                s = getData.readLine();
                number = Double.parseDouble(s);
                if (s.length() == 0 || s.trim().length() < 0) {
                    throw new Exception();
                }//close if
                success = true;
            } //close try
            catch (Exception e) {
                success = false;
                System.out.println("Please, enter data");
            } //close catch
        } //close while
        return s;
    }
}