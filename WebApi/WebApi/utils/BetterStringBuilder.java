package utils;

/**
 * Created by bloodrayne on 22.05.16.
 */
public class BetterStringBuilder {

    private StringBuilder builder = new StringBuilder();

    public void append(String x){
        builder.append(x);
    }

    public void newLine(){
        builder.append("\n");
    }

    public void addTab(){
        builder.append("\t");
    }

    public String toString(){
        return builder.toString();
    }

}
