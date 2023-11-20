/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TheBusiness.MarketModel;

import java.util.ArrayList;

/**
 *
 * @author kal bugrara
 */
public class SolutionOfferCatalog {

    ArrayList<SolutionOffer> solutionoffers;

    public SolutionOfferCatalog() {
        solutionoffers = new ArrayList();
    }
    
    public SolutionOffer newSolutionOffer(MarketChannelAssignment mca){
        
        SolutionOffer so = new SolutionOffer(mca);
        solutionoffers.add(so);
        
        return so;
    }
    
    

    //return all solution offers that match m/c combination
    public ArrayList<SolutionOffer> findSolutionsForMarketChannelCombo(MarketChannelAssignment mcc) {
        printso();
        System.out.println("------------------------------MarketChannelAssignment "+mcc);

        ArrayList<SolutionOffer> foundsolutions = new ArrayList();
     
        for (SolutionOffer so : solutionoffers) {
            System.out.println(so+" -----");
            if (so.isSolutionOfferMatchMarketChannel(mcc) == true) {
                System.out.println(so+" -----INSIDE");
                foundsolutions.add(so);
            }
            //find all solution offers available in the market/channel combin
        }
        return foundsolutions;

    }
    public void printso(){
            System.out.println("Solution Offers:");
        for (SolutionOffer offer : solutionoffers) {
            System.out.println("Name: " + offer.marketchannelcomb.market.getName() + ", Price: $" + offer.marketchannelcomb.channel.channeltype);
        }
    }

}
