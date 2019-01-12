package lab10example1;

import java.sql.*;

public class GoodsCRUD{
    private MysqlDatabaseConnection connection=null;
    
    GoodsCRUD(MysqlDatabaseConnection conn){
        this.connection=conn;
    }
    
    ResultSet getAllGoods(){
        return connection.executeQuery("SELECT * FROM GOODS");
    }
    ResultSet getAllManagers(){
        return connection.executeQuery("SELECT * FROM MANAGER");
    }
    
    ResultSet getGoodsByID(String Code){
        return connection.executeQuery("SELECT * FROM GOODS Where G_ID="+Code);
    }
    ResultSet getManagerByID(String Code){
        return connection.executeQuery("SELECT * FROM MANAGER Where M_ID="+Code);
    }
    ResultSet getLocationByID(int Code){
        return connection.executeQuery("SELECT * FROM STOREHOUSE Where Place_ID="+Code);
    }
    
    ResultSet getGoodsQuantity(String quantity){
        return connection.executeQuery( "SELECT  *" +
                                        "FROM GOODS\n" +
                                        "WHERE Quantity="+quantity);
    }
    ResultSet getSizeStorehouse(String size){
        return connection.executeQuery( "SELECT  *" +
                                        "FROM STOREHOUSE\n" +
                                        "WHERE Size='"+size+"'");
    }
    
    
    
           
   int UpdateEmployee(
            String Code, 
            String updatedSex, 
            String updatedName
            
            )
    {
        return connection.executeUpdate("UPDATE MANAGER SET Sex='"+updatedSex+"', M_NAME='"+updatedName+"'\nWHERE M_ID="+Code);
    
    
}
}
