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
public class ChannelCatalog {
    ArrayList<Channel> channellist ;
    public ChannelCatalog(){
    channellist = new ArrayList();
    }
    
    public Channel newChannel(String type){
        
        Channel c = new Channel(type);
        channellist.add(c);
        return c;
    }
    
    public Channel findChannel(String type){
       // printfindChannel();
       System.out.println("TYPE---"+type);
        for( Channel c: channellist ){
            String cType = c.getChannelType();
            
            System.out.println("LIST TYPE---"+c.getChannelType());
          
            if ((cType.trim()).equalsIgnoreCase(type.trim())) return c;
            
        }
        return null; //not found
    }
    public void printfindChannel(){
        System.out.println("Data in findChannel");

        for (Channel channel : channellist) {
            System.out.println("For MARKET "+channel.channeltype);
            
        }

    
    }

    public ArrayList<Channel> getChannellist() {
        return channellist;
    }

    
}
