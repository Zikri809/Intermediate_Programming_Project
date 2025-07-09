/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.time.LocalDate;


/**
 *
 * @author MUHAMMAD NASZRUL
 */
public class ArcadeMachine {
    
    private int id;
    private String name;
    private int yearMade;    
    private boolean isWorking;
    private String manufacturer;
    private double price;
    

        public ArcadeMachine (int ID,String NAME, int YEARMADE, boolean IsWorking, String Manufacturer){
        
        this.id=ID;
        this.isWorking = IsWorking;
        this.name = NAME;
        this.yearMade = YEARMADE;
        this.manufacturer = Manufacturer;
        
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
                
                public void setManufacturer(String manufacturer){
                    this.manufacturer = manufacturer;
                }
                public void setPrice(double price ){
                    this.price = price;
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
                public String getManufaturer(){
                    return this.manufacturer;
                }
                public double getPrice(){
                    return this.price;
                }
                public void calculatePrice(){
                 this.price = 5000 * Math.pow((1-0.8),LocalDate.now().getYear() - this.yearMade   );
                }
                public String toString(){

                return ("ID :"+id+"NAME :"+name+"YearMade :"+yearMade+"Machine is Working :"+isWorking);

                }

}
