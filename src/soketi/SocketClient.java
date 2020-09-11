/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soketi;

import java.io.*;
import java.net.*;

/**
 *
 * @author user
 */

public class SocketClient extends ClientProtocol
{
//    public static String serverStatus = null;
    String ServerError;
    static Socket kkSocket = null;
    static PrintWriter pw = null;
    static BufferedReader br = null;
    static Boolean failed = false;
    static String fromServer;
    static StringBuffer buf = new StringBuffer(50);
    static int c;
    static Boolean status = false;
    
    Runnable serverTask;
    
    public void connect(String ippadress, Integer portnumber)
    {
        serverTask = new Runnable()
        {
            @Override
            public void run() 
            {
                try
                    {
                        kkSocket = new Socket(ippadress, portnumber);
                        pw = new PrintWriter(kkSocket.getOutputStream());
                        br = new BufferedReader(new InputStreamReader(kkSocket.getInputStream()));

                        System.out.println("\r\nConnected to Server: Dr. H");
                        status = true;

                        while ((fromServer = br.readLine()) != null && status == true) 
                        {
                            System.out.println("Server: " + fromServer);

                            if (fromServer.equals("Bye."))
                            {
                                break;
                            }
                        }
                    }
                    catch (Exception e) 
                    {
                        System.err.println("IOException:  " + e);
                        ServerError = "" + e;
                        
                        if(status != true)
                        {
                            failed = true;
                        }
                    }
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
        
        Thread runThread = new Thread(serverTask);
        runThread.start();
        
    }
    
    public void sendDetails(String details)
    {
        serverTask = new Runnable()
        {
            @Override
            public void run() 
            {
                
                if (kkSocket != null && pw != null && br != null) 
                {
                    try 
                    {
                        buf.append(details);

                        System.out.println("Client: " + buf);
                        pw.println(buf.toString());
                        pw.flush();
                        buf.setLength(0);

                        while ((fromServer = br.readLine()) != null) 
                        {
                            System.out.println("Server: " + fromServer);
                            if (fromServer.equals("Bye."))
                            {
                                break;
                            }
                        }
                    } 
                    catch (UnknownHostException e) 
                    {
                        System.err.println("Trying to connect to unknown host: " + e);
                    }
                    catch (IOException e) 
                    {
                        System.err.println("IOException:  " + e);
                    }
                }
                
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        
        Thread runThread = new Thread(serverTask);
        runThread.start();
    }
    
    public void closeConnection()
    {
        serverTask = new Runnable()
        {
            @Override
            public void run() 
            {
                try
                {
                    pw.close();
                    br.close();
                    kkSocket.close();
                    status = false;
                    failed = false;
                }
                catch (IOException e) 
                {
                    System.err.println("IOException:  " + e);
                }
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        
        Thread runThread = new Thread(serverTask);
        runThread.start();
        
    }
    
    
    public static void main(String[] args) 
    {
        
    }
}
