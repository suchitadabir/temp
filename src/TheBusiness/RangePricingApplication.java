/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness;

import MarketingManagement.MarketingPersonProfile;
import TheBusiness.Business.Business;
import TheBusiness.CustomerManagement.CustomerProfile;
import TheBusiness.MarketModel.Channel;
import TheBusiness.MarketModel.ChannelCatalog;
import TheBusiness.MarketModel.Market;
import TheBusiness.MarketModel.MarketCatalog;
import TheBusiness.MarketModel.MarketChannelAssignment;
import TheBusiness.MarketModel.MarketChannelComboCatalog;
import TheBusiness.MarketModel.SolutionOffer;
import TheBusiness.MarketModel.SolutionOfferCatalog;
import TheBusiness.Personnel.Person;
import TheBusiness.ProductManagement.Product;
import TheBusiness.SalesManagement.SalesPersonProfile;
import TheBusiness.SolutionOrders.MasterSolutionOrderList;
import TheBusiness.SolutionOrders.SolutionOfferMap;
import TheBusiness.SolutionOrders.SolutionOrder;
import TheBusiness.Supplier.Supplier;
import data.DataGenerator;
import data.DataReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author kal bugrara
 */
public class RangePricingApplication {
    
   DataReader productReader;
   DataReader supplierReader;
   DataReader marketReader;
   DataReader channelReader;
   DataReader comboReader;
   DataReader customerReader;
   DataReader salesReader;
   DataReader marketingReader;
   Map<String, List<String>> supplProdMap = new HashMap<>();
   Map<Supplier, List<Product>> supplProdObjMap = new HashMap<>();
  // Map<String, SolutionOffer> solutionOfferMap = new HashMap<>();
   private static int keyCounter = 0;
   Business business;
   private static DataGenerator instance;
   private static RangePricingApplication rpinstance;
    
    public RangePricingApplication(Business b) throws IOException {
        this.business = b;
       DataGenerator generator = DataGenerator.getInstance();
       
       supplierReader = new DataReader(generator.getUserSupplierPath());
       productReader = new DataReader(generator.getProductFilePath());
       marketReader =new DataReader(generator.getMARKET_FILE_PATH());
       channelReader =new DataReader(generator.getCHANNEL_FILE_PATH());
       comboReader =new DataReader(generator.getMarketChannelCombo_FILE_PATH());
       customerReader = new DataReader(generator.getCustomerFilePath());
       salesReader = new DataReader(generator.getSalesFilePath());
       marketingReader = new DataReader(generator.getMarketingFilePath());

    }
    
     public static  RangePricingApplication getInstance(Business b) throws IOException{
        if(rpinstance == null)
        {
            rpinstance = new RangePricingApplication(b);
        }
        return rpinstance;
    }
    /**
     * @param args the command line arguments
     */
   /* public static void main(String[] args) throws IOException {
        // TODO code application logic here
        business = ConfigureABusiness.initializeMarkets();

        RangePricingApplication inst = new RangePricingApplication();
        inst.readData();

 //      business = ConfigureABusiness.initializeMarkets();
          
    }*/

    public void readData() throws IOException {
        
        String[] row;
        while((row = supplierReader.getNextRow()) != null ){
            generateSupplier(row);
        }
        
        while((row = productReader.getNextRow()) != null ){
            generateProduct(row);
        }        
        
        while((row = marketReader.getNextRow()) != null ){
            generateMarket(row);
        }
        
        while((row = channelReader.getNextRow()) != null ){
            generateChannel(row);
        }
        
       while((row = comboReader.getNextRow()) != null ){
            generateCombo(row);
        }

        while ((row = customerReader.getNextRow()) != null) {
        generateCustomerPerson(row);
        }
        
        while ((row = salesReader.getNextRow()) != null) {
        generateSalesPerson(row);
        }
        
        while ((row = marketingReader.getNextRow()) != null) {
        generateMarketingPerson(row);
        }
        System.out.println("HashMap with String keys and List<String> values:");
        for (Map.Entry<String, List<String>> entry : supplProdMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Values: " + entry.getValue());
        }

        
    /*    for(Supplier s:    business.getSupplierDirectory().getSuplierList()){
            System.out.println("----NEW SUP "+ s.getName());
            
        } */

       // runAnalysis();
    }

    private void generateProduct(String[] row) {
        String prodName = row[0];
        int fp = Integer.parseInt(row[1]);
        int cp = Integer.parseInt(row[2]);
        int tp = Integer.parseInt(row[3]);
        String supplier = row[4];

        Product product = new Product(row[0],fp,cp,tp);

        Supplier tempsup = business.getSupplierDirectory().findSupplier(supplier);
        Product tmpProd = tempsup.getProductCatalog().newProduct(prodName, fp, cp, tp);
        List<String> val = supplProdMap.get(tempsup.getName());
        
        if(val == null){
         List<String> newList = new ArrayList<>();
         newList.add(prodName);
         supplProdMap.put(tempsup.getName(), newList);

        }else{
         val.add(prodName);   
         supplProdMap.put(tempsup.getName(), val);

        }

        List<Product> valObj = supplProdObjMap.get(tempsup );
        
        if(valObj == null){
         List<Product> newOList = new ArrayList<>();
         newOList.add(tmpProd);
         supplProdObjMap.put(tempsup, newOList);

        }else{
         valObj.add(tmpProd);   
         supplProdObjMap.put(tempsup, valObj);

        }

        
    
    }

    private void generateSupplier(String[] row) {
        
        String supplierid = row[0];
        
        Supplier ss = business.getSupplierDirectory().newSupplier(supplierid);
        
        
        supplProdMap.put(supplierid,null);
        supplProdObjMap.put(ss, null);
        for(Supplier s:    business.getSupplierDirectory().getSuplierList()){
            System.out.println("SupplierOBJ "+ s.getName());
            
        }

    }

     private void generateMarket(String[] row) {
        
        String marketName = row[0];
        MarketCatalog mc = business.getMarketCatalog();
        
        mc.newMarket(marketName);
        
 

    }

    private void generateChannel(String[] row) {
        
        String channelName = row[0];
        
        ChannelCatalog channelCatalog = business.getChannelCatalog();
        
        channelCatalog.newChannel(channelName);
        

    }
    private static String generateAutomatedKey() {
        return "SOLUTION" + (++keyCounter);
    }
    
        private void generateCombo(String[] row) {
        
        String marketName = row[0];
        System.out.println("-------------------------------------------------");
        System.out.println("*********** THIS MARKET IS------"+marketName);
        Market m = business.getMarketCatalog().findMarket(marketName);
        System.out.println("*********** GOT MARKET OBJ ------"+m);

        MarketChannelComboCatalog mccc = business.getMarketChannelComboCatalog();
        System.out.println("*********** CREATED MC CATALOG ------"+ mccc.getClass().getName());

        SolutionOfferCatalog solutionoffercatalog = business.getSolutionOfferCatalog();
        System.out.println("*********** CREATED SolutionOfferCatalog CATALOG ------"+ solutionoffercatalog.getClass().getName());

        MasterSolutionOrderList msol = business.getMasterSolutionOrderList();
        System.out.println("*********** CREATED MasterSolutionOrderList  ------"+ msol.getClass().getName());
        SolutionOfferMap solutionOfferMap = business.getSolOfferMap();
       // SolutionOffer temp = null;
     //   MarketChannelAssignment ma = null;
        Channel c = null;
        // Create a Random object
        Random random = new Random();
        
        for(int i = 1; i<row.length ; i++){
        String ro = row[i];
        if(ro.isBlank()|| ro.length() == 0){
        i++;
        continue;
        }else{
           System.out.println("*********** FOR LOOP FOR ::"+i);
           c = business.getChannelCatalog().findChannel(ro);
           System.out.println("*********** FINDING I/P CHANNEL FOR MARKET ::"+ro);
        
        
          if(c == null){
          System.out.println("*********** c is null for "+ro+"and count "+i);
          i++;
          continue;
          }else{
          m.addValidChannel(c);}
           System.out.println("*********** addValidChannel ---> [Market]validchannels.add(c); ::"+ro);
          /* m.printValidChannel();*/

           MarketChannelAssignment ma = mccc.newMarketChannelCombo(m, c); 
           System.out.println("*********** newMarketChannelCombo --->     public MarketChannelAssignment(Market m, Channel c) {\n" +
"\n" +
"        market = m;\n" +
"        channel = c;\n" +
"        solutionofferlist = new ArrayList();\n" +
"        solutionorderlist = new ArrayList();\n" +
"\n" +
"    }\n" +
":"+ma.getClass().getName());
        
        
        }
        }
        }


    
    private void generateCombo1(String[] row) {
        
        String marketName = row[0];
        System.out.println("-------------------------------------------------");
        System.out.println("*********** THIS MARKET IS------"+marketName);
        Market m = business.getMarketCatalog().findMarket(marketName);
        System.out.println("*********** GOT MARKET OBJ ------"+m);

        MarketChannelComboCatalog mccc = business.getMarketChannelComboCatalog();
        System.out.println("*********** CREATED MC CATALOG ------"+ mccc.getClass().getName());

        SolutionOfferCatalog solutionoffercatalog = business.getSolutionOfferCatalog();
        System.out.println("*********** CREATED SolutionOfferCatalog CATALOG ------"+ solutionoffercatalog.getClass().getName());

        MasterSolutionOrderList msol = business.getMasterSolutionOrderList();
        System.out.println("*********** CREATED MasterSolutionOrderList  ------"+ msol.getClass().getName());
        SolutionOfferMap solutionOfferMap = business.getSolOfferMap();
       // SolutionOffer temp = null;
     //   MarketChannelAssignment ma = null;
        Channel c = null;
        // Create a Random object
        Random random = new Random();
        
        for(int i = 1; i<row.length ; i++){
        String ro = row[i];
        if(ro.isBlank()|| ro.length() == 0){
        i++;
        continue;
        }else{
           System.out.println("*********** FOR LOOP FOR ::"+i);
           c = business.getChannelCatalog().findChannel(ro);
           System.out.println("*********** FINDING I/P CHANNEL FOR MARKET ::"+ro);
        
        
          if(c == null){
          System.out.println("*********** c is null for "+ro+"and count "+i);
          i++;
          continue;
          }else{}
         // m.addValidChannel(c);}
           System.out.println("*********** addValidChannel ---> [Market]validchannels.add(c); ::"+ro);
          /* m.printValidChannel();*/

           MarketChannelAssignment ma = mccc.newMarketChannelCombo(m, c); 
           System.out.println("*********** newMarketChannelCombo --->     public MarketChannelAssignment(Market m, Channel c) {\n" +
"\n" +
"        market = m;\n" +
"        channel = c;\n" +
"        solutionofferlist = new ArrayList();\n" +
"        solutionorderlist = new ArrayList();\n" +
"\n" +
"    }\n" +
":"+ma.getClass().getName());

           SolutionOffer temp = solutionoffercatalog.newSolutionOffer(ma);
          // String key1 = generateAutomatedKey();
           solutionOfferMap.getSolutionOfferMap().put(String.valueOf(temp.getId()), temp);

           int totalPrice = 0;
           for (Map.Entry<Supplier, List<Product>> entry : supplProdObjMap.entrySet()) {
           System.out.println("Key: " + entry.getKey() + ", Values: " + entry.getValue());
           List<Product> newList = entry.getValue();

           // Generate a random number between 1 and 5 (inclusive)
           int bnd = newList.size();
           int randomNumber = random.nextInt(bnd);

           // Print the random number
           System.out.println("Random Number: " + randomNumber);
           Product tempProd = newList.get(randomNumber);
           temp.addProduct(tempProd);
           totalPrice = totalPrice + tempProd.getTargetPrice();
           temp.setTotalPrice(totalPrice);
           
        }
       // SolutionOrder so = msol.newSolutionOrder(temp, ma);
      //  int revenue = msol.getRevenueByMarketChannelCombo(ma);
      //  System.out.println("Revenue - "+revenue);
      //  msol.getRevenueByChannel(c);           
      }            
     
        System.out.println("-------------------------------------------------");
    
        }
        solutionOfferMap.printMe();
        
    
    }

  private void generateCustomerPerson(String[] row) {
    String customerId = row[0];
    Integer age = Integer.parseInt(row[1]);
    String market = determineGeneration(age);
    System.out.println("----"+market);
    Person customerPerson = new Person(customerId); 
    CustomerProfile customerProfile = business.getCustomerDirectory().newCustomerProfile(customerPerson);
    Market m = business.getMarketCatalog().findMarket(market);
    if(m == null)
    {
    }else{
    customerProfile.getMarkets().add(m);}
    System.out.println("Customer profile created for ID: " + customerId);
    
}
 private static String determineGeneration(int age) {
     
     String gen;
        if (age >= 75) {
            gen = "SilentGeneration";
        } else if (age >= 56) {
            gen = "BabyBoomers";
        } else if (age >= 41) {
            gen = "GenerationX";
        } else if (age >= 26) {
            gen = "Millennials";
        } else {
            gen = "GenerationZ";
        }
        
        return gen;
 }
    private void generateSalesPerson(String[] row) {
    String name = row[0];  
    Person salesPerson = new Person(name); 
    SalesPersonProfile salesProfile = business.getSalesPersonDirectory().newSalesPersonProfile(salesPerson);
    System.out.println("Sales person profile created for: " + name);
}

    private void generateMarketingPerson(String[] row) {
    String name = row[0];  
    Person marketingPerson = new Person(name); 
    MarketingPersonProfile marketingProfile = business.getMarketingPersonDirectory().newMarketingPersonProfile(marketingPerson);
    System.out.println("Marketing person profile created for: " + name);
    }
}
   
    
  

