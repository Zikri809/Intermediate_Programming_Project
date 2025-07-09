
import java.time.LocalDate;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author MUHAMMAD NASZRUL
 */
public class PinballMachine extends ArcadeMachine {
    
    private int flippersNum;

    public PinballMachine(int ID, String NAME, int YEARMADE, boolean IsWorking, int FlippersNum,String MANUFACTURER) {
        super(ID, NAME, YEARMADE, IsWorking, MANUFACTURER);
        calculatePrice();
        this.flippersNum = FlippersNum;
    }
    
        public void setFlippersNum(int flippersnum){
        
        this.flippersNum = flippersNum;
        
        }
        public int getFlippersNum(){
        
        return flippersNum;
        
        }
        public void calculatePrice(){
            double price = 10000 * Math.pow((1-0.8),LocalDate.now().getYear() -  super.getYEARMADE()  );
            super.setPrice(price);
        }
        public String toString(){
        
        return super.toString() + ("Number Of Flippers :"+flippersNum);
            
        }
}
