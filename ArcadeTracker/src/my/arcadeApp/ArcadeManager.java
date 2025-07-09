
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
    public void removeMachine(ArcadeMachine machine){
        machinesList.remove(machine);
    }
    public void addTechnician(Technician technician){
        technicianList.add(technician);
    }
    public void removeTechnician(Technician technician){
        technicianList.remove(technician);
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
    public void logRepair(int machineID, int technicianID, LocalDate date, String notes,String description, String priority){
        ArcadeMachine machine = findMachineInList(machineID);
        Technician technician = findTechnicianInList(technicianID);
        repairLogList.add(new RepairLog(machine,technician, notes, description, priority));
    }
    public void addRepairLog(RepairLog repairLog){
        repairLogList.add(repairLog);
    }
    public List<ArcadeMachine> getMachineList(){
        return machinesList;

    }
    public List<Technician> getTechnicianList(){
        return technicianList;
    }
    public List<RepairLog> getRepairLogList(){
        return repairLogList;
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
    public ArcadeMachine findMachineInList(String machineName){
        for (int i = 0; i <machinesList.size(); i++){
            if (machinesList.get(i).getNAME().equals(machineName)){
                return machinesList.get(i);
            }
        }
        return null;
    }
    public Technician findTechnicianInList(String technicianName){
        for (int i = 0; i <technicianList.size(); i++){
            if (technicianList.get(i).getNAME().equals(technicianName)){
                return technicianList.get(i);
            }
        }
        return null;
    }
    public int[] getPrioritylogCount(){
        int lowcount = 0;
        int mediumcount = 0;
        int highcount = 0;
        for (int i = 0; i <repairLogList.size(); i++){
            if(repairLogList.get(i).getPriority().equals("Low priority")){
                lowcount++;
            }
            else if(repairLogList.get(i).getPriority().equals("Medium priority")){
                mediumcount++;
            }
            else if(repairLogList.get(i).getPriority().equals("High priority")){
                highcount++;
            }
        }
        //0-low 1-med 2-high
        int [] logcount = {lowcount,mediumcount,highcount};
        return logcount;
    }
}
