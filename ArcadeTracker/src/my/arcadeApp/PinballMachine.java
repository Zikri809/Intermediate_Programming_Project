/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.arcadeApp;

/**
 *
 * @author MUHAMMAD NASZRUL
 */
public class PinballMachine extends ArcadeMachine {
    
    private int flippersNum;

    public PinballMachine(int ID, String NAME, int YEARMADE, boolean IsWorking, int FlippersNum) {
        super(ID, NAME, YEARMADE, IsWorking);
        this.flippersNum = FlippersNum;
    }
    
        public void setFlippersNum(int flippersnum){
        
        this.flippersNum = flippersNum;
        
        }
        public int getFlippersNum(){
        
        return flippersNum;
        
        }
        
        public String toString(){
        
        return super.toString() + ("Number Of Flippers :"+flippersNum);
            
        }
}
