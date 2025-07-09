/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.time.LocalDate;

/**
 *
 * @author MUHAMMAD NASZRUL
 */
public class CabinetGame extends ArcadeMachine {
    
    private String screenType;

    public CabinetGame(int ID, String NAME, int YEARMADE, boolean IsWorking, String SCREENTYPE, String MANUFACTURER) {
        super(ID, NAME, YEARMADE, IsWorking, MANUFACTURER);
        calculatePrice();
        this.screenType=SCREENTYPE;
    }
    
        public void setSCREENTYPE(String screenType){
        
        this.screenType=screenType;
        
        }
    
        public String getSCREENTYPE(){
        
        return screenType;
        
        }
        public void calculatePrice(){
            double price = 10000 * Math.pow((1-0.8),LocalDate.now().getYear() -  super.getYEARMADE()  );
            super.setPrice(price);
        }
        public String toString(){
        
        return super.toString() + ("Type Of Screen :"+screenType);
            
        }
}
    

