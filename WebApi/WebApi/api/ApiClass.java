package api;

import mc.MinecraftAccess;
import serializer.JSONSerializer;
import services.TelnetService;

import java.util.HashMap;

/**
 * Created by bloodrayne on 22.05.16.
 */
public class ApiClass {

    private HashMap<String, MinecraftAccess> mcServer = new HashMap<>();
    private HashMap<String, TelnetService> webServices = new HashMap<>();

    private static ApiClass instance = null;

    public static ApiClass getInstance(){
        if(instance == null){
            instance = new ApiClass();
        }
        return instance;
    }


    private ApiClass(){

        mcServer.put("eona",new MinecraftAccess("root2.eona-minecraft.de",0));
        mcServer.put("games", new MinecraftAccess("eona-minecraft.de",0));

        webServices.put("webserver", new TelnetService("root1.eona-minecraft.de",0));
        webServices.put("bungee", new TelnetService("root1.eona-minecraft.de", 0));
        webServices.put("teamspeakEONA", new TelnetService("ts3.eona-minecraft.de",0));
        webServices.put("teamspeakTEST", new TelnetService("ts3.eona-minecraft.de",0));
        webServices.put("teamspeakNOX", new TelnetService("nox.eona-minecraft.de",0));

    }




    public String getMinecraftServer(String name, String format){
        if(format.equalsIgnoreCase("xml")){
            return "Not yet implemented";
        }else{
            try{
                return JSONSerializer.toJSON("test",mcServer.get(name).toHashMap());
            }catch(Exception e){
                return JSONSerializer.toJSON("test",e);
            }
        }
    }

    public String getWebService(String name, String format){
        if(format.equalsIgnoreCase("xml")){
            return "Not yet implemented";
        }else{
            try{
                return JSONSerializer.toJSON("test",webServices.get(name).toHashMap());
            }catch(Exception e){
                return JSONSerializer.toJSON("test",e);
            }
        }
    }



}
