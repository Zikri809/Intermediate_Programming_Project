package my.arcadeApp;

import java.time.LocalDate;
import java.util.List;

public class ArcadeManager {

    //the <> specifies the type of element going to be inside the list
    // used as it is flexible compared to array
    //the length can increase dynamically as more object is added
    private List <ArcadeMachine> machinesList;
    private List<Technician> technicianList;
    private List<RepairLog> repairLogList;

    public void addMachine(ArcadeMachine machine){
        machinesList.add(machine);
    }
    public void updateMachineStatus ( int machineID , boolean isWorking){
        //we iterate through the list and find the object that has the
        //required id then we changes the its working status
        ArcadeMachine updateMachine = findMachineInList(machineID);
        updateMachine.setIsWorking(isWorking);

    }
    public void assignTechnician( int machineID, int technicianId){

        for (int i = 0; i <repairLogList.size(); i++){
            if(repairLogList.get(i).getMachine().getID() == machineID ){
                Technician technician = findTechnicianInList(technicianId);
                repairLogList.get(i).setTechnician(technician);
            }
        }
    }
    public void logRepair(int machineID, int technicianID, LocalDate date, String notes){
        ArcadeMachine machine = findMachineInList(machineID);
        Technician technician = findTechnicianInList(technicianID);
        repairLogList.add(new RepairLog(machine,technician, notes));
    }
    public List<ArcadeMachine> getMachineList(){
        return machinesList;

    }
    public List<Technician> getTechnicianList(){
        return technicianList;
    }
    public ArcadeMachine findMachineInList(int machineId){
        for (int i = 0; i <machinesList.size(); i++){
            if(machinesList.get(i).getID() == machineId){
                return machinesList.get(i);
            }
        }
        return null;
    }
    public Technician findTechnicianInList (int technicianId){
        for (int i = 0; i <technicianList.size(); i++){
            if(technicianList.get(i).getID() == technicianId){
                return technicianList.get(i);
            }
        }
        return null;
    }
}
