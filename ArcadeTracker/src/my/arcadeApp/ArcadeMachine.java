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
    
        public ArcadeMachine (int ID,String NAME, int YEARMADE, boolean IsWorking){
        
        this.id=ID;
        this.isWorking = IsWorking;
        this.name = NAME;
        this.yearMade = YEARMADE;
        
        }
            
                public void setID(int id){

                this.id=id;
                }

                public void setNAME(String name){

                this.name=name;
                }

                public void setYEARMADE(int yearMade){

                this.yearMade=yearMade;
                }

                public void setIsWorking(boolean isWorking){

                this.isWorking=isWorking;
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

                public boolean getIsWorking(){

                return isWorking;    

                }

                public String toString(){

                return ("ID :"+id+"NAME :"+name+"YearMade :"+yearMade+"Machine is Working :"+isWorking);

                }
}
