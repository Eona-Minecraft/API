package test;

import api.ApiClass;

/**
 * Created by bloodrayne on 22.05.16.
 */
public class Test {

    public static void main(String args[]){
        ApiClass c = ApiClass.getInstance();

        System.out.println("Test Bungee");
        System.out.println(c.getMinecraftServer("eona","json"));
    }

}
