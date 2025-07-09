/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.arcadeApp;

/**
 *
 * @author MUHAMMAD NASZRUL
 */
public class ArcadeMachine {
    
    private int id;
    private String name;
    private int yearMade;    
    private boolean isWorking;
    
            
            public void setID(){
            
            int ID=id;
            }
            
            public void setNAME(){
            
            String NAME=name;
            }
            
            public void setYEARMADE(){
            
            int YEARMADE=yearMade;
            }
            
            public int getID (){
            
            return id;
            }
            
            public String getNAME (){
            
            return name;
            }
            
            public int getYEARMADE (){
            
            return yearMade;
            }
            
            public String toString(){
            
            return ("ID :"+id+"NAME :"+name+"YearMade :"+yearMade);
            
            }
}
