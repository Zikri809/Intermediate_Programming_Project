/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.arcadeApp;

/**
 *
 * @author MUHAMMAD NASZRUL
 */
public class CabinetGame extends ArcadeMachine {
    
    private String screenType;

    public CabinetGame(int ID, String NAME, int YEARMADE, boolean IsWorking, String SCREENTYPE, String MANUFACTURER) {
        super(ID, NAME, YEARMADE, IsWorking, MANUFACTURER);
        this.screenType=SCREENTYPE;
    }
    
        public void setSCREENTYPE(String screenType){
        
        this.screenType=screenType;
        
        }
    
        public String getSCREENTYPE(){
        
        return screenType;
        
        }
        
        public String toString(){
        
        return super.toString() + ("Type Of Screen :"+screenType);
            
        }
}
    

