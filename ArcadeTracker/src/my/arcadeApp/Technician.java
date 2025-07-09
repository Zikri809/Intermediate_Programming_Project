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
    
        public Technician (int ID, String NAME, String SPECIALTY){
        this.id = ID;   
        this.name = NAME;
        this.specialty = SPECIALTY;        
                
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

            public int getID(){

            return id;

            }

            public String getNAME(){

            return name;

            }

            public String getSPECIALTY(){

            return specialty;

            }

                public String toString(){

                return ("ID :"+id+"NAME :"+name+"Technician Specialty :"+specialty);

                }

    
}

