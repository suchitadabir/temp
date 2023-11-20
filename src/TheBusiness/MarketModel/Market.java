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
public class Market {

    String name;
    ArrayList<Channel> validchannels;
    ArrayList<String> characteristics; //a way to describe in plain language what is that group
    ArrayList<Market> submarkets;
    int size;

    public Market(String m) {
        name = m;
        characteristics = new ArrayList();
        submarkets = new ArrayList();
        validchannels = new ArrayList();
    }

    public void addCharactersitic(String c) {
        characteristics.add(c);
    }

    public void addValidChannel(Channel c) {
        System.out.println("BEFORE ADDING  Channel Name: " + c.channeltype);
        validchannels.add(c);
    }

    public String getName() {
        return name;
    }
    
    public void printValidChannel(){
        System.out.println("Data in ArrayList<Channel>:");

        for (Channel channel : validchannels) {
            if(channel != null){
            System.out.println("For MARKET "+this.name +" Channel Name: " + channel.channeltype);}
            else{System.out.println("For MARKET "+this.name +" YET NO CHANNEL  " );
            }
        }

    
    }

    public ArrayList<Channel> getValidchannels() {
        return validchannels;
    }

    public void setValidchannels(ArrayList<Channel> validchannels) {
        this.validchannels = validchannels;
    }
    
    
    

}
