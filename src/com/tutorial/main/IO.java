package com.tutorial.main;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IO extends HUD{
	
	//private HUD hud = new HUD();
	protected String highScore;
	public String level;
	
	public void write (){	
		try{	
			FileWriter fileWriter = new FileWriter ("highScore.txt");
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			int x = Menu.temp;
			bufferedWriter.write("" + x);
			/*FileWriter fileWriter2 = new FileWriter ("level.txt");
			BufferedWriter bufferedWriter2 = new BufferedWriter(fileWriter2);
			bufferedWriter2.write(hud.getLevel());
			*/
			bufferedWriter.close();
			//bufferedWriter2.close();
		}catch (IOException ex){
			System.out.println("error writing to file");
		}
	}
	
	public void read (){
        String line = null;

        try {
            FileReader fileReader = new FileReader("highScore.txt");
            BufferedReader bufferedReader =  new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {
            	highScore = line ;
            }   
            
            FileReader fileReader2 = new FileReader("highScore.txt");
            BufferedReader bufferedReader2 =  new BufferedReader(fileReader2);
            while((line = bufferedReader.readLine()) != null) {
                level = line;
             } 
            
            bufferedReader.close();  
            bufferedReader2.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println( "Unable to open file");                
        } catch(IOException ex) {
            System.out.println("Error reading file ");                  
        }
	}
}