/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package github;

/**
 *
 * @author roger
 */
import java.util.*; 
public class Detection {
    String [] rules; 
    ArrayList<String> tokens = new ArrayList<String>(); 
    int size;
    int count=0; 
    RBT tree = new RBT(); 
    public Detection(String [] therules, String thetext, int size) // initialization 
    {
        this.size=size; 
        rules= new String [therules.length]; 
        for(int i=0; i<rules.length; i++)
            rules[i]=therules[i]; 
        StringBuilder text= new StringBuilder(thetext);  
        int currentstart=0; 
        while(text.length()>=size)
        {
           if(text.length()-currentstart+1<size)
           {
               tokens.add(text.substring(currentstart,text.length())); 
               break;
           }
           String temp = text.substring(currentstart, currentstart+size-1); 
           tokens.add(temp); 
           currentstart +=size; 
        }
        
    }
    public int detect() //actual detection 
    {   
        for(int i=0; i<rules.length; i++)
        {
            tree.put(rules[i].hashCode()); 
        }
        for(String x : tokens)
        {
            if(tree.isThere(x.hashCode()))
                count++; 
        }
        return count; 
            
    }
    
   
}
