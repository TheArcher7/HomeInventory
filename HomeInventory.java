/*
 * Micah Mock
 * Colorado State University Global
 * CSC320 Programming I
 * Module 8 Portfolio
 * Mazen Alkhatib
 * 9/11/2022
 * 
 * Explanation:
 * Using the techniques learned in this course, the following program was created for a house 
 * inventory system to store, manipulate, and print data to the console or a file.
 * 
 * This program demonstrates the use of taking standard I/O, variables, if/else statements,
 * switch structures, try-catch statements for error checking, classes, and writing to a file.
 */

import java.util.*;
import java.io.*;
class HomeInventory {
    //main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<HouseInformation> HouseList = new ArrayList<HouseInformation>();
        HouseInformation currHouse;

        callMenu(HouseList);
        char commandChar = sc.next().charAt(0);
        while(commandChar != 'q'){
           switch(commandChar){
                case 'a': //add house to HouseList
                try{
                    System.out.println("--- ADD HOUSE ---");
                    System.out.println("Enter the square footage: ");
                    int square_feet = sc.nextInt(); sc.nextLine();
                    System.out.println("Enter the street address: ");
                    String address = sc.nextLine();
                    System.out.println("Enter the city: ");
                    String city = sc.nextLine();
                    System.out.println("Enter the state: ");
                    String state = sc.nextLine();
                    System.out.println("Enter the zip code: ");
                    int zip = sc.nextInt(); sc.nextLine();
                    System.out.println("Enter the model name: ");
                    String model = sc.nextLine();
                    System.out.println("Enter the sale status (sold, available, or under contract): ");
                    String sale_status = sc.nextLine();
                    if (sale_status.equals("sold") || sale_status.equals("available") || sale_status.equals("under contract")){
                    }else{throw new Exception("ERROR: Sale status wasn't input correctly.");}
                    currHouse = new HouseInformation(square_feet, address, city, state, zip, model, sale_status);
                    HouseList.add(currHouse);
                    System.out.println("House added to list.");
                }catch (Exception e) {
                    System.out.println(e.getMessage());
                    System.out.println("Canceling add.");
                }
                    break;
                
                case 'r': //remove house from Houselist
                try{
                    System.out.println("--- REMOVE HOUSE ---");
                    if (HouseList.size() == 0){
                        throw new Exception("ERROR: There is nothing to remove because there are no houses in the list.");}
                    System.out.println("What is the index of the house you want to see? (Input an integer between 0 and " + (HouseList.size()-1) + ")");
                    int removeIndex = sc.nextInt();
                    if (removeIndex < 0 || removeIndex > HouseList.size()-1){
                        throw new Exception("ERROR: The index you chose is out of range.");}
                    System.out.println("Here is the information for this house.");
                    HouseList.get(removeIndex).printToConsole();
                    System.out.println("Are you sure you want to remove it from the list? y/n");
                    char removeCommand =  sc.next().charAt(0);
                    if (removeCommand == 'y'){
                        HouseList.remove(removeIndex); 
                        System.out.println("House removed.");
                    } else{System.out.println("Canceling removal.");}
                }catch (Exception e){
                    System.out.println(e.getMessage());
                    System.out.println("Canceling removal.");
                }
                    break;

                case 'u': //update house in houselist
                try{
                    System.out.println("--- UPDATE HOUSE ---");
                    if (HouseList.size() == 0){
                        throw new Exception("ERROR: There is nothing to update because there are no houses in the list.");}
                    System.out.println("What is the index of the house you want to see? (Input an integer between 0 and " + (HouseList.size()-1) + ")");
                    int updateIndex = sc.nextInt();
                    if (updateIndex < 0 || updateIndex > HouseList.size()-1){
                        throw new Exception("ERROR: The index you chose is out of range.");}
                    System.out.println("Here is the information for this house.");
                    HouseList.get(updateIndex).printToConsole();
                    System.out.println("Are you sure you want to update and change the information on this home? y/n");
                    char updateCommand = sc.next().charAt(0); sc.nextLine();
                    if (updateCommand == 'y'){
                        updateHouseInList(HouseList, sc, updateIndex);
                    }
                    else {System.out.println("Canceling update");}
                }catch (Exception e){
                    System.out.println(e.getMessage());
                    System.out.println("Canceling update.");
                }
                    break;
                
                case 'v': //view houselist by printing all houses to the consol
                try{
                    if (HouseList.size() == 0){
                        throw new Exception("ERROR: There is nothing to view because there are no houses in the list.");}
                    System.out.println("Viewing house list in console.");
                    printAllHousesToConsole(HouseList);
                } catch(Exception e){
                    System.out.println(e.getMessage());
                }
                    break;

                default:
                    System.out.println(commandChar + "- is not a valid input. Try again.");
                    break;
           }
           callMenu(HouseList);
           commandChar = sc.next().charAt(0);
        }

        //quit the system and choose to print or not
        System.out.println("--- QUIT ---");
        System.out.println("How would you like to quit?");
        System.out.println("a - quit and print");
        System.out.println("q - quit without printing");
        System.out.println("--- ---- ---");
        commandChar = sc.next().charAt(0);
        char printToChar;
        switch (commandChar){
            case 'a': 
                System.out.println("Would you like to print to a new file? y/n ");
                printToChar = sc.next().charAt(0);
                if (printToChar == 'y') {       //print to a file
                    try {
                    printAllHousesToFile(HouseList);
                } catch (IOException e) {
                    e.printStackTrace();
                }}else {                        //print to the consol
                    System.out.println("A file will not be printed. Printing to console.");
                    printAllHousesToConsole(HouseList);}
                break;
            default:
                System.out.println("Quitting without printing.");
        }
        sc.close();
    }
    /****************************************************************************************************/

    //methods
    public static void callMenu(ArrayList<HouseInformation> HouseList){ 
        System.out.println("--- MAIN MENU --- ---- ---- ---");
        System.out.println("a - Add a new house");
        System.out.println("r - Remove an existing house");
        System.out.println("u - Update a house's info");
        System.out.println("v - View house list");
        System.out.println("q - Quit");
        printNumHouses(HouseList);
        System.out.println("--- ---- ---- --- ---- ---- ---");
    }

    public static void printNumHouses(ArrayList<HouseInformation> HouseList){
        System.out.println("Houses listed = " + HouseList.size());
    }//prints the number of houses in the list to the consol

    public static void printAllHousesToConsole(ArrayList<HouseInformation> HouseList){
        System.out.println("");
        System.out.println("--- --- Home Inventory List --- ---");
        for (int i = 0; i < HouseList.size(); i++){
            System.out.println("Index: " + i);
            HouseList.get(i).printToConsole();
        }
    }//prints all houses and data to the console

    public static void printAllHousesToFile(ArrayList<HouseInformation> HouseList) throws IOException{
        Random rnd = new Random();
        String fileName = "Home-"+ rnd.nextInt(10) + rnd.nextInt(10) + rnd.nextInt(10) +".txt";
        //note: I was having trouble writing to files
        FileOutputStream fileStream = new FileOutputStream(fileName);
        PrintWriter outFS = new PrintWriter(fileStream);
        outFS.println("");outFS.println("");
        outFS.println("--- --- Home Inventory List --- ---");
        for (int i = 0; i < HouseList.size(); i++){
            outFS.println("Index: "+ i);
            HouseList.get(i).printToFile(outFS);
        }
        System.out.println("Printed house list to "+ fileName);
        outFS.close();
    }//prints house list data to a new file called Home-000.txt

    public static void updateHouseInList(ArrayList<HouseInformation> HouseList, Scanner sc, int updateIndex) throws Exception{
        System.out.println("Would you like to change the square footage? y/n");
        if (sc.nextLine().charAt(0) == 'y'){
            System.out.println("Enter the new square footage: ");
            int square_feet = sc.nextInt(); sc.nextLine();
            HouseList.get(updateIndex).update_SquareFeet(square_feet);
        }
        System.out.println("Would you like to change the street address? y/n");
        if (sc.nextLine().charAt(0) == 'y'){
            System.out.println("Enter the new street address: ");
            String address = sc.nextLine();
            HouseList.get(updateIndex).update_Address(address);
        }
        System.out.println("Would you like to change the city? y/n");
        if (sc.nextLine().charAt(0) == 'y'){
            System.out.println("Enter the new city: ");
            String city = sc.nextLine();
            HouseList.get(updateIndex).update_City(city);
        }
        System.out.println("Would you like to change the state? y/n");
        if (sc.nextLine().charAt(0) == 'y'){
            System.out.println("Enter the state: ");
            String state = sc.nextLine();
            HouseList.get(updateIndex).update_State(state);
        }
        System.out.println("Would you like to change the zip code? y/n");
        if (sc.nextLine().charAt(0) == 'y'){
            System.out.println("Enter the new zip code: ");
            int zip_code = sc.nextInt(); sc.nextLine();
            HouseList.get(updateIndex).update_ZipCode(zip_code);
        }
        System.out.println("Would you like to change the house model? y/n");
        if (sc.nextLine().charAt(0) == 'y'){
            System.out.println("Enter the model name: ");
            String model = sc.nextLine();
            HouseList.get(updateIndex).update_ModelName(model);
        }
        System.out.println("Would you like to change the sale status? y/n");
        if (sc.nextLine().charAt(0) == 'y'){
            System.out.println("Enter the new sale status (sold, available, or under contract): ");
            String sale_status = sc.nextLine();
            if (sale_status.equals("sold") || sale_status.equals("available") || sale_status.equals("under contract")){
            }else{throw new Exception("ERROR: Sale status wasn't input correctly.");}
            HouseList.get(updateIndex).update_SaleStatus(sale_status);
        }
        //HouseList.get(updateIndex).update_House(square_feet, address, city, state, zip_code, model, sale_status);
        System.out.println("Displaying updated house...");
        HouseList.get(updateIndex).printToConsole();
        System.out.println("Are you satisfied with your edit? y/n");
        if (sc.nextLine().charAt(0) == 'n'){
            updateHouseInList(HouseList, sc, updateIndex);
        }
        else {System.out.println("Finished Updating.");} //recursive call to keep updating the house info
    }
}

/* Refer to ch 5.12 for arraylist storing classes
 * ch 3.10 for switch statements
 */