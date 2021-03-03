package ec.edu.espe.UniversityRestaurantCapacitySystem.view;

import com.google.gson.Gson;
import ec.edu.espe.UniversityRestaurantCapacitySystem.controller.Controller;
import ec.edu.espe.UniversityRestaurantCapacitySystem.model.Administrator;
import ec.edu.espe.UniversityRestaurantCapacitySystem.model.Costumer;
import ec.edu.espe.UniversityRestaurantCapacitySystem.model.Dessert;
import ec.edu.espe.UniversityRestaurantCapacitySystem.model.MainCourse;
import ec.edu.espe.UniversityRestaurantCapacitySystem.model.Order;
import ec.edu.espe.UniversityRestaurantCapacitySystem.model.Product;
import ec.edu.espe.filemanager.utils.FileManager;
import java.util.ArrayList;
import java.util.List;
import ec.edu.espe.UniversityRestaurantCapacitySystem.model.Drink;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Cristian Maranje Software-Runners ESPE-DCCO
 */
public class UniversityRestaurantCapacityControlSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {

        LogIn v = new LogIn();
        v.setVisible(true);
      Product products[]= new Product[3];
        
        //products[0]= new Product("Hamburguesa", 1357,1.50f, "Sin cebolla", 20) {}; // Do we need to have instances of products ?
        products[0]= new MainCourse("menu",2468, 1, "secondplate", 4 , 10, "anysoup");
        products[1]= new Drink("Juice ",6789, 1, "apple ", 40, true, true, LocalDate.now().plusDays(10));
        products[2]= new Dessert("brownie", 9876, 2, "With vainilla ice cream", 20);
        
        for (Product product : products){
            
            System.out.println(product.showEspecifications());
            product.prepare();
            System.out.println("pice for sale - > "+ product.computePriceForSale());
            System.out.println("=======");
        }
        Display display = new Display();
        List<String> foundLines;
        Product product = new Drink();
        Costumer costumer = new Costumer();
        List<Order> orders = new ArrayList<Order>();
        Gson gson = new Gson();
        Administrator cashier =new Administrator();
        Controller controller = new Controller();
        int option = 0;
        do {
            option = display.displayMenu();
            switch (option) {
                case 1:
                    cashier.registerNewOrder(orders);
                    break;
                case 2:
                    controller.printAllOrders();
                    break;
                case 3:
                    FileManager.save("product.json", gson.toJson(product.addNewProduct()));
                    break;
                case 4:
                    FileManager.save("costumersList.json", gson.toJson(costumer.addNewCostumer()));
                    System.out.println("**NEW COSTUMER ADDED***\n");
                    break;
                case 5:
                    foundLines = FileManager.find("product.json", display.productToFind());
                    System.out.println(foundLines);
                    break;
                case 6:
                    foundLines = FileManager.findAll("product.json");
                    System.out.println(foundLines);
                    break;
                case 7:
                    System.out.println("Exiting ...");
                    Thread.sleep(1* 1000);    
                    System.out.println("Thank you for using this system");
                    System.exit(0);
                    break;
                
                
            }
        } while (7 >= option && option > 0);
        
         Scanner scan = new Scanner(System.in);
        int limit;
        int election;
        System.out.println("WHAT PRODUCT WILL YOU ENTER?");
        System.out.println("(1).MainCourse");
        System.out.println("(2).Drink");
        System.out.println("(1).Dessert");
        election= scan.nextInt();
        
    }
}