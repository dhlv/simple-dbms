package lab10example1;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Application {
    private UserInterface UI=null;
    private MysqlDatabaseConnection dbConnection=null;
    private Scanner scanner = null;
    private Boolean isRunning=true;
    
    void start(){
        this.initialize();
        this.run();
    }
    
    void initialize(){
        this.scanner = new Scanner(System.in);
        this.UI = new UserInterface();
        MysqlDatabaseConnection dbConnection = new MysqlDatabaseConnection();
        if(dbConnection.connect())
        {
            this.dbConnection=dbConnection;
        }
        else{
            this.isRunning=false;
            this.UI.printInitializationError();
        }
    }
    
    void run(){
        UI.printWelcomeGreetings();
        while(this.isRunning){
            UI.printMainMenu();
            int mainOption = Integer.parseInt(scanner.nextLine());
            switch(mainOption){
                case 1: viewGoods();
                        break;
                case 2: updateManager();
                        break;
                case 3: viewGoodsQuantity();
                        break;
                case 4: viewSizeHouse();
                break;
                case 5: viewManagers();
                break;
                case 999: this.exit();
                        break;
                default: System.out.println("Incorrect Option selected");
            }
            System.out.flush();
        }
    }
    
    void exit(){
        this.dbConnection.disconnect();
        this.scanner.close();
        this.isRunning=false;
    }
    
    void viewGoods(){
        Boolean backPressed = false;
        while(!backPressed){
            this.UI.printViewGoodsMenu();
            int customerOption = Integer.parseInt(scanner.nextLine());
            switch(customerOption){
                case 1: viewAllGoods();
                        break;
                case 2: viewGoodsByCode();
                        break;
                case 999: backPressed=true;
                        break;
                default: System.out.println("Incorrect Option selected");
            }
        }
    }
    
    void viewManagers(){
       Boolean backPressed = false;
        while(!backPressed){
            this.UI.printViewManagerMenu();
            int customerOption = Integer.parseInt(scanner.nextLine());
            switch(customerOption){
                case 1: veiwAllManagers();
                        break;
                case 2: viewManagerByCode();
                        break;
                case 999: backPressed=true;
                        break;
                default: System.out.println("Incorrect Option selected");
            }
        }
    }
    
    void viewAllGoods(){
        GoodsCRUD customerService = new GoodsCRUD(dbConnection);
        ResultSet rs = customerService.getAllGoods();
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println(rsmd.getColumnName(1) + "  " + rsmd.getColumnName(2) + "  " + rsmd.getColumnName(3));
            while(rs.next())
                System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
        } catch (SQLException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    void veiwAllManagers(){
        GoodsCRUD customerService = new GoodsCRUD(dbConnection);
        ResultSet rs = customerService.getAllManagers();
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println(rsmd.getColumnName(1) + "  " + rsmd.getColumnName(2) + "  " + rsmd.getColumnName(3));
            while(rs.next())
                System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
        } catch (SQLException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void viewGoodsByCode(){
    	GoodsCRUD customerService = new GoodsCRUD(dbConnection);
        UI.printEnterGoodsID();
        String customerCode = scanner.nextLine();
        ResultSet rs = customerService.getGoodsByID(customerCode);
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println(rsmd.getColumnName(1) + "  " + rsmd.getColumnName(2) + "  " + rsmd.getColumnName(3));
            while(rs.next())
                System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
        } catch (SQLException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void viewManagerByCode(){
    	GoodsCRUD customerService = new GoodsCRUD(dbConnection);
        UI.printEnterMID();
        String customerCode = scanner.nextLine();
        ResultSet rs = customerService.getManagerByID(customerCode);
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println(rsmd.getColumnName(1) + "  " + rsmd.getColumnName(2) + "  " + rsmd.getColumnName(3));
            while(rs.next())
                System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
        } catch (SQLException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void updateManager(){
        GoodsCRUD employeeService = new GoodsCRUD(dbConnection);
        UI.printEnterMID();
        String employeeID = scanner.nextLine();
        ResultSet rs = employeeService.getManagerByID(employeeID);
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println(rsmd.getColumnName(1) + "   " + rsmd.getColumnName(2) + "   " + rsmd.getColumnName(3)+"   "+rsmd.getColumnName(4));
            while(rs.next())
                System.out.println(rs.getString(1) + "   " + rs.getString(2) + "   " + rs.getString(3)+"   "+rs.getString(4));
            
            
            UI.printEnterManagerNewName();
            String updatedFName=scanner.nextLine();
           
            UI.printEnterEmployeeSex();
            String updatedSex=scanner.nextLine();
            
            int updated = employeeService.UpdateEmployee(employeeID,updatedSex,updatedFName);
            if(updated==1)
                System.out.println("Manager Updated!");
        } catch (SQLException ex) {
             Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void viewGoodsQuantity(){
    	GoodsCRUD customerService = new GoodsCRUD(dbConnection);
        UI.printEnterQuantity();
        String Quantity = scanner.nextLine();
        ResultSet rs = customerService.getGoodsQuantity(Quantity);
        try {
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println(rsmd.getColumnName(1) + "  " + rsmd.getColumnName(2) + "  " + rsmd.getColumnName(3));
            while(rs.next())
                System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getInt(3));
        } catch (SQLException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void viewSizeHouse(){
        GoodsCRUD customerService = new GoodsCRUD(dbConnection);
       UI. printEnterSizeOfHouses();
       String Gname = scanner.nextLine();
        ResultSet rs = customerService.getSizeStorehouse(Gname);
  try {
            ResultSetMetaData rsmd = rs.getMetaData();
            System.out.println(rsmd.getColumnName(1) + "  " + rsmd.getColumnName(2) + "  " + rsmd.getColumnName(3));
            while(rs.next())
                System.out.println(rs.getString(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
        } catch (SQLException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}