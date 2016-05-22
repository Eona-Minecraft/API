package mc;


import wrapper.HashMapWrapper;

import java.util.HashMap;

/**
 * Created by bloodrayne on 22.05.16.
 */
public class MinecraftAccess implements HashMapWrapper{

    private String hostname = "";
    private int port = 0;
    private QueryResponse resp = null;


    public MinecraftAccess(String hostname, int port){
        this.setPort(port);
        this.setHostname(hostname);
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    private void loadResponse(){
        MCQuery x = new MCQuery(hostname,port);
        resp = x.fullStat();
    }


    @Override
    public HashMap<String, Object> toHashMap() {
        loadResponse();
        HashMap<String, Object> data = new HashMap<>();

        data.put("host",getHostname());
        data.put("port", getPort());

        HashMap<String,Object> info = new HashMap<>();
        info.put("maxPlayers", resp.getMaxPlayers());
        info.put("onlinePlayer", resp.getOnlinePlayers());
        info.put("motd", resp.getMOTD());
        info.put("gamemode", resp.getGameMode());
        info.put("mapname", resp.getMapName());

        data.put("information",info);


        String pl[] = new String[resp.getPlayerList().size()];

        for(int i=0; i < pl.length;i++){
            pl[i] = resp.getPlayerList().get(i);
        }

        data.put("players", pl);

        return data;
    }
}
