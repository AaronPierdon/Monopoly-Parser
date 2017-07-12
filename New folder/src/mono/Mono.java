/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mono;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 *
 * @author Aaron Pierdon
 */
public class Mono {
public static List<String> codePieces = new LinkedList<>();
public static List<PieceCategory> categories = new LinkedList<>();
public static PieceCategory e = new PieceCategory();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  
         /*
        readPieces();
        readSlots();
        tallyMatches();
        for(int iterator = 0; iterator < categories.size(); iterator++){
            System.out.println("Prize: " + categories.get(iterator).name);
            System.out.println("Total Pieces Needed: " + categories.get(iterator).slotCount);
            System.out.println("Total Pieces Found: " + categories.get(iterator).filledCount);
            for(String output : categories.get(iterator).filledSlots){           
                System.out.println("Found Piece: " + output);
            }
        }
        */
         
         ArrayList<String> a = new ArrayList();
         a.add("a");
         a.add("b");
         System.out.println(a.get(0));
        
        
    }
    
    public static void readPieces(){
              try{
            BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Aaron Pierdon\\Desktop\\mono.txt"));
            String str;
            while((str = in.readLine()) != null)
                loadPieces(str);
            in.close();
        }catch(IOException e){
        }
    }
    
    public static void readSlots(){
                      try{
            BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Aaron Pierdon\\Desktop\\monoslots.txt"));
            String str;
            while((str = in.readLine()) != null)
                loadSlots(str);
            in.close();
        }catch(IOException e){
        }
    }
    
    public static void loadPieces(String str){
        codePieces.add(str);
    }
    
    public static void loadSlots(String str){
        /**encountered "!"*/
        if(str.contains("!") && e.slotCount != 0){
            /**if the current category object has already been filled partially
             * we know that the name has been set and slots loaded. Send to 
             * perm. data structure.
             */
            if(e.name == null){
                String string = str.substring(1);
                e = new PieceCategory(string);
            }
            categories.add(e);
            e = null;
            
            
        }
        if(str.contains("!") && e == null){
            String string = str.substring(1);
            e = new PieceCategory(string);
        } 
        /**this portion executes for slots not categories*/
            /**found last slot so take out the "@" and load it*/
            if(str.contains("@") && e != null){
            String symbol = new String("@");
            String locationOfSymbol = str.substring(0, str.indexOf(symbol));
            e.addSlot(locationOfSymbol);
            /**just found simple slot, load it*/
            }
            
            if(str.contains("!") == false && str.contains("@") == false){
                e.addSlot(str);
            }
                
            
        //last slot of the category

            
        }
    
    public static void tallyMatches(){
        //iterate through all the code pieces that I own
        for(String piece : codePieces){
            //compare each code piece with each category
            for(PieceCategory category : categories){
                //compare each code piece with a each code slot of a given category
                for(String slot : category.codeSlots){
                    //check to see if the piece matches the slot and make sure
                    //the piece has not alreadyh been counted for the category.
                    if(category.codeSlots.contains(piece) == true
                            && category.filledSlots.contains(piece) == false){
                        category.filledSlots.add(piece);
                        category.filledCount++;
                    }
                }
            }
        }
    }
        
        
    }

