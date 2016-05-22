package dal;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by bloodrayne on 22.05.16.
 */
public class Datei {



    private String filePath = "";
    private ArrayList<String> zeilen = new ArrayList<String>();


    /**
     * Creates a new Datei instance for reading local files
     */
    public Datei()
    {

    }

    /**
     * Creates a new Datei instance for reading local files
     * @param dateiPfad Path of the File
     */
    public Datei(String dateiPfad){
        this();
        filePath = dateiPfad;
    }

    /**
     * Creates a new Datei instance for reading local files
     * @param dateiPfad Path of the file
     * @param loadFile Indicates whether the file shall be read or not
     */
    public Datei(String dateiPfad, boolean loadFile){
        this(dateiPfad);
        if(loadFile){
            this.loadFile();
        }
    }

    /**
     * Load the file into internal ArrayList
     */
    public void loadFile(){
        try(FileInputStream fi = new FileInputStream(filePath); InputStreamReader isr = new InputStreamReader(fi); BufferedReader br = new BufferedReader(isr)){
            String zeile = br.readLine();
            while (zeile != ""){
                zeilen.add(zeile);
                zeile = br.readLine();
            }
        }catch(Exception e){
            //TODO: Exception handling with an LogSystem
        }
    }

    /**
     * Save the content of the internal ArrayList to disk
     */
    public void saveFile(){
        try(FileOutputStream fo = new FileOutputStream(filePath); OutputStreamWriter isw = new OutputStreamWriter(fo); BufferedWriter br = new BufferedWriter(isw)){
            for (String s:zeilen
                 ) {
                br.write(s);
                br.newLine();
                br.flush();
            }
        }catch(Exception e){
            //TODO: Exception handling with an LogSystem
        }
    }

    /**
     * Returns a line of the file
     * @param lineNumber line number
     * @return
     */
    public String readLine(int lineNumber){
        try{
            return zeilen.get(lineNumber);
        }catch(Exception e){
            //TODO: Exception handling with an LogSystem
            return "";
        }
    }

    /**
     * Writes a line of text on the giving line number
     * @param txt line of text
     * @param lineNumber line where it should been
     */
    public void writeLine(String txt, int lineNumber){
        try{
            if(lineNumber > zeilen.size()){
                zeilen.add(txt);
            }else{
                zeilen.set(lineNumber,txt);
            }
        }catch(Exception e){
            //TODO: Exception handling with an LogSystem
        }
    }

    /**
     * Writes a line of text at the end of the file
     * @param txt line of text
     */
    public void writeLine(String txt){
        try{
            writeLine(txt,zeilen.size() + 1);
        }catch(Exception e){
            //TODO: Exception handling with an LogSystem
        }
    }

    /**
     * Get Lines Count
     * @return
     */
    public int getLineCount(){
        return zeilen.size();
    }

    /**
     * Get the Iterator, to go through the internal array
     * @return
     */
    public Iterator<String> getIterator(){
        return zeilen.iterator();
    }

    /**
     * Returns the actual file path
     * @return
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * Sets the actual file path
     * @param filePath new file path
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }



}
