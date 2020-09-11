/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soketi;

/**
 *
 * @author user
 */



public class ClientProtocol
{
    public static void main(String args[])
    {  
    }  
        
//    Client Functions
    public String toy_identification(String code, String name)
    {
        String output = code + ":" + name;
        return output;
    }
    
    public String  toy_info(String toy_name, String toy_desc, String toy_price, String toy_date_of_man, String toy_batch)
    {
        String output = toy_name + ":" + toy_desc + ":" + toy_price + ":" + toy_date_of_man + ":" + toy_batch;
        return output;
    }
    
    public String toy_manufacturer(String company_name, String address, String zip_code, String country)
    {
        String output = company_name + ":" + address + ":" + zip_code + ":" + country;
        return output;
    }
    
    public String thankyou(String message)
    {
        Integer random;
        random = (int)(Math.random()) + (int) System.currentTimeMillis();
        String output = message + ":" + random;
        return output;
    }
    
    public String entire_form(String code, String name, String toy_desc, String toy_price, String toy_date_of_man, String toy_batch, String company_name, String address, String zip_code, String country)
    {
        String output = code + ":" + name + ":" + toy_desc + ":" + toy_price + ":" + toy_date_of_man + ":" + toy_batch + ":" + company_name + ":" + address + ":" + zip_code + ":" + country;
        return output;
    }
    
    
}
