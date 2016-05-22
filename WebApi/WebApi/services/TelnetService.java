package services;

import utils.BetterStringBuilder;
import wrapper.HashMapWrapper;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by bloodrayne on 22.05.16.
 */
public class TelnetService implements HashMapWrapper {

    private String webAdress = "";
    private int port = 80;


    public TelnetService(String host, int port){
        this.webAdress = host;
        this.port = port;
    }

    public String getWebAdress() {
        return webAdress;
    }

    public void setWebAdress(String webAdress) {
        this.webAdress = webAdress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isOnline(){
        try{
            Socket x = new Socket();
            x.connect(new InetSocketAddress(webAdress,port),1000);
            x.close();
            return true;
        }catch(Exception e){
            return false;
        }
    }


    @Override
    public HashMap<String, Object> toHashMap() {
        HashMap<String, Object> data = new HashMap<>();

        data.put("host",getWebAdress());
        data.put("port", getPort());
        data.put("online", isOnline());

        return data;
    }
}
