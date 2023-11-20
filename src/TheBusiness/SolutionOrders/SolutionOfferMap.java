/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TheBusiness.SolutionOrders;

import TheBusiness.MarketModel.SolutionOffer;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author suchitadabir
 */
public class SolutionOfferMap {
       Map<String, SolutionOffer> solutionOfferMap = new HashMap<>();

    public Map<String, SolutionOffer> getSolutionOfferMap() {
        return solutionOfferMap;
    }

    public void setSolutionOfferMap(Map<String, SolutionOffer> solutionOfferMap) {
        this.solutionOfferMap = solutionOfferMap;
    }
       
    public void printMe(){
            for (Map.Entry<String, SolutionOffer> entry : solutionOfferMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
     }
    }
            
     public SolutionOffer findKey(String key){
         
        for (Map.Entry<String, SolutionOffer> entry : solutionOfferMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());

            if(entry.getKey().equalsIgnoreCase(key)){
            return entry.getValue();
            }
     }
           return null;

     }

    

}
