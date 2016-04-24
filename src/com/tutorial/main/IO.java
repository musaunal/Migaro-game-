package com.tutorial.main;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IO {
	
	protected String temp;
	
	public void write (String path){	
		try{	
			FileWriter fileWriter = new FileWriter (path);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			int x = Menu.temp;
			bufferedWriter.write("" + x);
			bufferedWriter.close();
		}catch (IOException ex){
			System.out.println("error writing to file");
		}
	}
	
	public void read (String path){
        String line = null;

        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader =  new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
            	temp = line ;
            }   
            
            bufferedReader.close();  
        }
        catch(FileNotFoundException ex) {
            System.out.println( "Unable to open file");                
        } catch(IOException ex) {
            System.out.println("Error reading file ");                  
        }
	}
}