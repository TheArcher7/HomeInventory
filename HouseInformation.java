import java.io.PrintWriter;
import java.io.IOException;
public class HouseInformation {
    private int square_feet;
    private String address;
    private String city;
    private String state;
    private int zip_code;
    private String Model_name;
    private String sale_status; //sold, available, or under contract

    //default constructor
    public HouseInformation(){
        this.square_feet = -1;
        this.address = "None";
        this.city = "None";
        this.state = "None";
        this.zip_code = -1;
        this.Model_name = "None";
        this.sale_status = "None";
    }
    //constructor
    public HouseInformation(String address, String city, String state, int zip_code){
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip_code = zip_code;
    }
    //constructor
    public HouseInformation(int square_feet, String address, String city, String state, int zip_code, String Model_name, String sale_status){
        this.square_feet = square_feet;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip_code = zip_code;
        this.Model_name = Model_name;
        this.sale_status = sale_status;
    }

    //resets all variables
    public void removeHouse(){
        this.square_feet = -1;
        this.address = "None";
        this.city = "None";
        this.state = "None";
        this.zip_code = -1;
        this.Model_name = "None";
        this.sale_status = "None";
        System.out.println("House information removed.");
    }

    //mutators or setters
    public void update_House(int square_feet, String address, String city, String state, int zip_code, String Model_name, String sale_status){
        this.square_feet = square_feet;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip_code = zip_code;
        this.Model_name = Model_name;
        this.sale_status = sale_status;
    }
    public void update_SquareFeet(int square_feet){this.square_feet = square_feet;}
    public void update_Address(String address){this.address = address;}
    public void update_City(String city){this.city = city;}
    public void update_State(String state){this.state = state;}
    public void update_ZipCode(int zip_code){this.zip_code = zip_code;}
    public void update_ModelName(String Model_name){this.Model_name = Model_name;}
    public void update_SaleStatus(String sale_status){this.sale_status = sale_status;}

    //accessors or getters
    public int get_SquareFeet(){return this.square_feet;}
    public String get_Address(){return this.address;}
    public String get_City(){return this.city;}
    public String get_State(){return this.state;}
    public int get_ZipCode(){return this.zip_code;}
    public String get_ModelName(){return this.Model_name;}
    public String get_SaleStatus(){return this.sale_status;}

    //Create multiple methods with try catch clauses, compare input arguement to the private variable
    // if match, print info to console and return true
    // if no match, return false
    // arraylist will iterate through the arraylist of houses and trigger the same comparison 
    // until one gets a match and prints the info or until all items are out.

    //comparison methods
    public boolean matches_SquareFeet(int square_feet){
        if (square_feet == this.square_feet){return true;}return false;
    }
    public boolean matches_Address(String address){
        if (address.equals(this.address)){return true;}return false;
    }
    public boolean matches_City(String city){
        if (city.equals(this.city)){return true;}return false;
    }
    public boolean matches_State(String state){
        if (state.equals(this.state)){return true;}return false;
    }
    public boolean matches_ZipCode(int zip_code){
        if (zip_code == this.zip_code){return true;}return false;
    }
    public boolean matches_ModelName(String Model_name){
        if (Model_name.equals(this.Model_name)){return true;}return false;
    }
    public boolean matches_SaleStatus(String sale_status){
        if (sale_status.equals(this.sale_status)){return true;}return false;
    }

    //print method
    public void printToConsole(){
        System.out.println("Square footage: " + this.square_feet);
        System.out.println("Street address: " + this.address);
        System.out.println("City: " + this.city);
        System.out.println("State: " + this.state);
        System.out.println("Zip code: " + this.zip_code);
        System.out.println("Model name: " + this.Model_name);
        System.out.println("Sale status: " + this.sale_status);
        System.out.println("");
    }
    public void printToFile(PrintWriter outFS) throws IOException{
        outFS.println("Square footage: " + this.square_feet);
        outFS.println("Street address: " + this.address);
        outFS.println("City: " + this.city);
        outFS.println("State: " + this.state);
        outFS.println("Zip code: " + this.zip_code);
        outFS.println("Model name: " + this.Model_name);
        outFS.println("Sale status: " + this.sale_status);
        outFS.println("");
    }
}
