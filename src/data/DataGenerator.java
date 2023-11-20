/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import TheBusiness.Business.Business;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author harshalneelkamal
 */
public class DataGenerator {
        
    private static DataGenerator instance;
    
    private FileWriter writer;
    private File file;
    
    private final Random rand;
    
    private final int userIdsRange;
    private final int commentIdsRange;
    private final int likeRange;
    private final int postIdsRange;
    private final int ratingRange;
    private final int prodRange = 10;
    private final int suppRange = 5;
    
    
    private final String PROD_HEADER="Prod-name,Fp,Cp,Tp,SupID";
    private final String SUPPLIER_HEADER="Supp-name";
    private final String CUSTP_HEADER = "Cust-name,Age";
    private final String SALESP_HEADER = "SalesPerson-name";
    private final String MARKETINGP_HEADER = "MarketingPerson-name";

    private final String CHANNEL_HEADER = "Channel-Name";
    private final String MARKET_HEADER = "Market-Name";
    private final String COMBO_HEADER ="Market,Channel-1,Channel-2,Channel-3";
    private final String ORDER_HEADER="Cust-name,Market,Channel,Solution-Name,Total-price,Act-price,SalesPerson-name";
    private final String LINE_BREAK = "\n";
    
    
    private final String USER_CAT_PATH = "./UserCatalogue.csv";
    private final String MARKET_FILE_PATH = "./MarketData.csv";
    private final String PROD_FILE_PATH = "./Products.csv";
    private final String SUPPLIER_FILE_PATH = "./Suppliers.csv";
    private final String CUSTP_FILE_PATH = "./Customers.csv";
    private final String SALESP_FILE_PATH = "./Sales.csv";
    private final String MARKETINGP_FILE_PATH = "./Marketing.csv";
    private final String CHANNEL_FILE_PATH = "./Channels.csv";
    private final String MarketChannelCombo_FILE_PATH = "./MarketChannelCombo.csv";
    private final String ORDER_FILE_PATH = "./Orders.csv";
    
    
    
    private DataGenerator() throws IOException {
                
        rand = new Random();
        
        userIdsRange = 10;
        commentIdsRange = 1000;
        likeRange = 200;
        postIdsRange = 40;
        ratingRange = 300;
        
        generateCustomerPersonFile();
        generateSalesPersonFile();
        generateMarketingPerson();
        generateSupplierFile();
        generateProductFile();
        generateMarketsFile();
        generateChannelFile();
        generateMarketChannelComboFile();
    }
    
    
     public String getCustomerFilePath(){
        return CUSTP_FILE_PATH;
    }

    public String getSalesFilePath() {
        return SALESP_FILE_PATH;
    }

    public String getMarketingFilePath() {
        return MARKETINGP_FILE_PATH;
    }

    public String getUserSupplierPath(){
        return SUPPLIER_FILE_PATH;
    }
    
    public String getProductFilePath(){
        return PROD_FILE_PATH;
    } 

    public String getMARKET_FILE_PATH() {
        return MARKET_FILE_PATH;
    }

    public String getCHANNEL_FILE_PATH() {
        return CHANNEL_FILE_PATH;
    }

    public String getMarketChannelCombo_FILE_PATH() {
        return MarketChannelCombo_FILE_PATH;
    }
    
    public static DataGenerator getInstance() throws IOException{
        if(instance == null)
        {
            instance = new DataGenerator();
        }
        return instance;
    }
    
     private void generateCustomerPersonFile() throws IOException {
          try {
            file = new File(CUSTP_FILE_PATH);
            if(file.exists()){
                file.delete();
            }
            file.createNewFile();
            System.out.println("New Customer File Created");
            writer = new FileWriter(file);
        
            writer.append(CUSTP_HEADER);
            writer.append(LINE_BREAK);
            
            generateCustomerColumns();   
            
        }finally{
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }
    
    private void generateCustomerColumns() throws IOException {
    int customerCnt = 1;
    int[] ages = {85, 60, 45, 30, 25, 22, 18, 12, 8, 13,65};

    while (customerCnt <= userIdsRange) {
        int age = ages[customerCnt];

        String customerName = "Customer" + customerCnt+","+age ;
        String column = customerName;

        try {
            writer.append(column);
            writer.append(LINE_BREAK);
        } catch (IOException e) {
            e.printStackTrace(); // Print the exception details
        }
        customerCnt++;
    }
    }

    private void generateSalesPersonFile() throws IOException {
         try {
            file = new File(SALESP_FILE_PATH);
            if(file.exists()){
                file.delete();
            }
            file.createNewFile();
            System.out.println("New Sales File Created");
            writer = new FileWriter(file);
        
            writer.append(SALESP_HEADER);
            writer.append(LINE_BREAK);
            
            generateSalesColumns();   
            
        }finally{
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }

    
    private void generateSalesColumns() throws IOException {
        int salesPersonCnt = 1;

    while (salesPersonCnt <= userIdsRange) {
        String salesPersonName = "SalesPerson" + salesPersonCnt;
        String column = salesPersonName + ",";

        try {
            writer.append(column);
            writer.append(LINE_BREAK);
        } catch (IOException e) {
            e.printStackTrace(); // Print the exception details
        }
        salesPersonCnt++;
    }
    }
    
    
    private void generateMarketingPerson() throws IOException {
         try {
            file = new File(MARKETINGP_FILE_PATH);
            if(file.exists()){
                file.delete();
            }
            file.createNewFile();
            System.out.println("New Marketing File Created");
            writer = new FileWriter(file);
        
            writer.append(MARKETINGP_HEADER);
            writer.append(LINE_BREAK);
            
            generateMarketingColumns();   
            
        }finally{
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }

   
    private void generateMarketingColumns() throws IOException {
     int marketingPersonCnt = 1;

    while (marketingPersonCnt <= userIdsRange) {
        String marketingPersonName = "MarketingPerson" + marketingPersonCnt;
        String column = marketingPersonName + ",";

        try {
            writer.append(column);
            writer.append(LINE_BREAK);
        } catch (IOException e) {
            e.printStackTrace(); // Print the exception details
        }
        marketingPersonCnt++;
    }
    }

    

    private void generateProductFile() throws IOException {
        
        
                //generate Order file
        try {
            file = new File(PROD_FILE_PATH);
            if(file.exists()){
                file.delete();
            }
            file.createNewFile();
            System.out.println("New Product File Created");
            writer = new FileWriter(file);
        
            writer.append(PROD_HEADER);
            writer.append(LINE_BREAK);
            
            generateProductColumns();   
            
        }finally{
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
        

    }
    
  
   
    private void generateProductColumns() throws IOException {
    int prodCnt = 1;
    int numberOfRows;
    String column;
        Path filePath = Paths.get(SUPPLIER_FILE_PATH);
        List<String> lines;
        try {
            // Read all lines from the file into a List of Strings
            lines = Files.readAllLines(filePath);
            System.out.println("Data in the file:");
            for (String line : lines) {
                System.out.println(line);
            }

            // Get the total number of rows
             numberOfRows = lines.size();

            // Print the result
            System.out.println("Total number of Suppliers: " + numberOfRows);
        } catch (IOException e) {
            // Handle exceptions, e.g., if the file is not found or there's an issue reading it
            e.printStackTrace();
            return;
        }
        
        //the loop for orders
        while(prodCnt <= prodRange){
            //items for a order.
            String prodName = "PRODUCT "+prodCnt;
           // int fp = rand.nextInt(ratingRange);
           int tp = 100*prodCnt;
           int fp = tp+10;
           int cp= tp-10;
           
           if(numberOfRows >  prodCnt)
           {
             System.out.println("IN IF "+ lines.get(prodCnt));
             column = prodName+","+fp+","+cp+","+tp+","+lines.get(prodCnt);
           }else{
             column = prodName+","+fp+","+cp+","+tp+","+lines.get(1);           
           }
           System.out.println("MAPP "+column);
            writer.append(column);
            writer.append(LINE_BREAK);
                        
            prodCnt++;
        }      
        
    }

 


    private void generateSupplierFile() throws IOException {
         try {
            file = new File(SUPPLIER_FILE_PATH);
            if(file.exists()){
                file.delete();
            }
            file.createNewFile();
            System.out.println("New Supplier File Created");
            writer = new FileWriter(file);
        
            writer.append(SUPPLIER_HEADER);
            writer.append(LINE_BREAK);
            
            generateSupplierColumns();   
            
        }finally{
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
        
       
        
    }
    
    
   private void generateSupplierColumns() throws IOException {
    int supCnt = 1;
        //the loop for orders
        while(supCnt <= suppRange){
            //items for a order.
            String prodName = "SUPPLIER"+supCnt;
           // int fp = rand.nextInt(ratingRange);
 

            
            String column = prodName;
                
            writer.append(column);
            writer.append(LINE_BREAK);
                        
            supCnt++;
        }      
        
    }

    private void generateMarketsFile() throws IOException {
        try {
            file = new File(MARKET_FILE_PATH);
            if(file.exists()){
                file.delete();
            }
            file.createNewFile();
            System.out.println("New Markets File Created");
            writer = new FileWriter(file);
        
            writer.append(MARKET_HEADER);
            writer.append(LINE_BREAK);
            
            generateMarketColumns();   
            
        }finally{
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
        
    }
    
   private void generateMarketColumns() throws IOException {
        ArrayList<String> generations = new ArrayList<>();

        // Add generation names to the ArrayList
        generations.add("SilentGeneration");
        generations.add("BabyBoomers");
        generations.add("GenerationX");
        generations.add("Millennials");
        generations.add("GenerationZ");
        generations.add("GenerationAlpha");

        // Print the names
        System.out.println("Generations ArrayList:");
        for (String generation : generations) {
            System.out.println(generation);
            //items for a order.
            String prodName = generation;
         
            
            String column = prodName;
                
            writer.append(column);
            writer.append(LINE_BREAK);
                        
        }      
        
    }

    private void generateChannelFile() throws IOException {
        try {
            file = new File(CHANNEL_FILE_PATH);
            if(file.exists()){
                file.delete();
            }
            file.createNewFile();
            System.out.println("New channel File Created");
            writer = new FileWriter(file);
        
            writer.append(CHANNEL_HEADER);
            writer.append(LINE_BREAK);
            
            generateChanelColumns();   
            
        }finally{
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
        
    }
    
   private void generateChanelColumns() throws IOException {
       
             // Create an ArrayList of channel names
        ArrayList<String> channels = new ArrayList<>();

        // Add channel names to the ArrayList
        channels.add("Traditional Media Channels");
        channels.add("Direct Mail");
        channels.add("Television Advertising");
        channels.add("Email Marketing");
        channels.add("In-Store Promotions");
        channels.add("Social Media Marketing");
        channels.add("E-commerce Platforms");
        channels.add("Content Marketing");
        channels.add("Social Media Platforms");
        channels.add("Influencer Marketing");
        channels.add("Messaging Apps");
        channels.add("Online Marketplaces");
        channels.add("Mobile Apps");
        channels.add("Short-Form Video Platforms");
        channels.add("Online Platforms and Apps");
        channels.add("Parental Influencers");
        channels.add("Interactive Content");

        // Print the channel names
        System.out.println("Channels ArrayList:");
        for (String channel : channels) {
            System.out.println(channel);
        
            //items for a order.
            String prodName = channel;
         
        
            String column = prodName;
                
            writer.append(column);
            writer.append(LINE_BREAK);
                        
        }      
        
    }
   
   
   private void generateMarketChannelComboFile(){
   
        Map<String, String[]> generationalChannels = new HashMap<>();
        generationalChannels.put("SilentGeneration", new String[]{"Traditional Media Channels", "Direct Mail"});
        generationalChannels.put("BabyBoomers", new String[]{"Television Advertising", "Email Marketing", "In-Store Promotions"});
        generationalChannels.put("GenerationX", new String[]{"Social Media Marketing", "E-commerce Platforms", "Content Marketing"});
        generationalChannels.put("Millennials", new String[]{"Social Media Platforms", "E-commerce and Online Marketplaces", "Influencer Marketing"});
        generationalChannels.put("GenerationZ", new String[]{"Social Media and Messaging Apps", "E-commerce and Mobile Apps", "Short-Form Video Platforms"});
        generationalChannels.put("GenerationAlpha", new String[]{"Online Platforms and Apps", "Parental Influencers", "Interactive Content"});


        try (FileWriter writer = new FileWriter(MarketChannelCombo_FILE_PATH)) {
            // Write the generational channels data to the file
            writer.append(COMBO_HEADER);
            writer.append(LINE_BREAK);
            for (Map.Entry<String, String[]> entry : generationalChannels.entrySet()) {
                writer.write(entry.getKey() +"," + String.join(", ", entry.getValue()) + System.lineSeparator());
            }

            System.out.println("Generational channels data has been written to the file: " );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   

}