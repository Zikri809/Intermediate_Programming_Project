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
    
        public void setFlippersNum(){
        
        int FlippersNum=flippersNum;
        
        }
    
        public int getFlippersNum(){
        
        return flippersNum;
        
        }
        
        public String toString(){
        
        return super.toString + ("Number Of Flippers :"+flippersNum);
            
        }
}
