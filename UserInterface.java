package lab10example1;

/**
 *
 * @author syedmfaizan
 */
public class UserInterface {
    
    void printWelcomeGreetings(){
        System.out.println("Welcome to Find Goods Application!");
    }
    
    void printMainMenu(){
        System.out.println("Select Operation from List:");
        System.out.println("1: View Good(s)");
        System.out.println("2: Update Manager Information");
        System.out.println("3: Get Goods by  Quantity Left");
         System.out.println("4: Get all storehouses in a fixed size");         
         System.out.println("5: View Managers");

         
        System.out.println("999: Exit Application");
    }
    
    void printViewGoodsMenu(){
        System.out.println("\tSelect Operation from List:");
        System.out.println("\t1: View All Goods");
        System.out.println("\t2: View Goods by its ID");
        System.out.println("\t999: Back");
    }
    
     void printViewManagerMenu(){
        System.out.println("\tSelect Operation from List:");
        System.out.println("\t1: View All Manager");
        System.out.println("\t2: View Managers by its ID");
        System.out.println("\t999: Back");
    }
    
    void printEnterGoodsName(){
        System.out.print("Enter Good name: ");
    }
    void printEnterGoodsID(){
                System.out.print("Enter Good ID: ");

    }
    void printEnterMID(){
        System.out.print("Enter Manager ID: ");
    }
    void printEnterManagerNewName(){
        System.out.print("Enter new Manager  name: ");
    }
   void printEnterEmployeeSex(){
       System.out.print("Enter new Manager sex: ");
   }
    void printEnterLocationID() {
        System.out.print("Enter the good ID you wanna change quantity of: ");

    }
    
     void printEnterQuantity(){
        System.out.print("Enter the quantity you want to search: ");
    }
    void printEnterCustomerNewLName(){
        System.out.print("Enter Updated Last Name: ");
    }
    
    void printEnterSizeOfHouses(){
        System.out.print("Enter the size of the storehouse you want to search: ");
    }
    
    void printEnterCustomerNewPhone(){
        System.out.print("Enter Updated Phone Number: ");
    }
    
    void printInitializationError(){
        System.out.println("Application Cannot Initialize!");
    }
    
}
