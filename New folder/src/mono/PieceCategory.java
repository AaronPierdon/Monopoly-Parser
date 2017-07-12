/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mono;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Aaron Pierdon
 */
public class PieceCategory {
    public  List<String> codeSlots = new LinkedList<>();
    public List<String> filledSlots = new LinkedList<>();
    public int filledCount;
    public  int slotCount;
    public String name; 
    
    public PieceCategory(){
        slotCount = 0;
    }
   
    
    public PieceCategory(int initialCount, String initialName){
        slotCount = initialCount;
        name = initialName;
    }
    
    public PieceCategory(String initialName){
        name = initialName;
        slotCount = 0;
    }
    
   
    
    public void addSlot(String str){
        codeSlots.add(str);
        slotCount++;
    }
    
    
}
