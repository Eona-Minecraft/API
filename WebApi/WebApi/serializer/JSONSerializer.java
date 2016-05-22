package serializer;


import com.google.gson.Gson;

import java.util.HashMap;

/**
 * Created by bloodrayne on 22.05.16.
 */
public class JSONSerializer {

    private static Gson ser = new Gson();

    public static String toJSON(String call, HashMap<String,Object> data){
        return ser.toJson(getFinalHashmap(call,data));
    }

    public static String toJSON(String call, Exception e){
        return ser.toJson(getFinalHashmapExc(call,e));
    }


    private static HashMap<String, Object> getFinalHashmap(String call,HashMap<String,Object> data){
        HashMap<String,Object> fin = new HashMap<>();
        HashMap<String,Object> inn = new HashMap<>();
        inn.put("call", call);
        inn.put("result", "success");
        inn.put("data", data);

        fin.put("response", inn);
        return fin;
    }

    private static HashMap<String, Object> getFinalHashmapExc(String call, Exception e){
        HashMap<String,Object> fin = new HashMap<>();
        HashMap<String,Object> inn = new HashMap<>();
        HashMap<String, Object> exc = new HashMap<>();

        inn.put("call", call);
        inn.put("result", "failed");

        if(e.getMessage() == null){
            exc.put("message", "no message given");
        }else{
            exc.put("message", e.getMessage());
        }

        inn.put("data", exc);

        fin.put("response", inn);
        return fin;
    }

}
