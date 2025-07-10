/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.arcadeApp;

/**
 *
 * @author MUHAMMAD NASZRUL
 */
public class Technician {
    
    private int id;
    private String name;
    private String specialty;
    private double experience;
    private String certification;
    private boolean isBusy;
    
    public Technician (int ID, String NAME, String SPECIALTY,double EXPERIENCE,String CERTIFICATION){
        this.id = ID;
        this.name = NAME;
        this.specialty = SPECIALTY;
        this.experience = EXPERIENCE;
        this.certification = CERTIFICATION;
        this.isBusy = false;
    }
    
    public void setID(int id){
        this.id=id;
    }
    public void setNAME(String name){
        this.name=name;
    }
    public void setSPECIALTY(String specialty){
        this.specialty=specialty;
    }
    public void setEXPERIENCE(double experience){
        this.experience=experience;
    }
    public void setCERTIFICATION(String certification){
        this.certification=certification;
    }

    public void setBusy(boolean busy) {
        this.isBusy = busy;
    }

    public int getID(){
        return id;
    }

    public String getNAME(){
        return name;
    }
    public String getSPECIALTY(){
        return specialty;
    }
    public double getEXPERIENCE(){
        return experience;
    }
    public String getCERTIFICATION(){
        return certification;
    }
    public boolean getBusy(){
        return isBusy;
    }
    public String toString(){
        return ("ID :"+id+"NAME :"+name+"Technician Specialty :"+specialty);
    }

    
}

