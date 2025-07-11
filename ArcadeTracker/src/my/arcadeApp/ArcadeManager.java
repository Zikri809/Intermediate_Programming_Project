
package my.arcadeApp;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.util.*;


public class ArcadeManager {

    //the <> specifies the type of element going to be inside the list
    // used as it is flexible compared to array
    //the length can increase dynamically as more object is added
    private List<ArcadeMachine> machinesList = new ArrayList<>();
    private List<Technician> technicianList = new ArrayList<>();
    private List<RepairLog> repairLogList = new ArrayList<>();


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
    public RepairLog findRepairLogInList(ArcadeMachine machine){
        for (int i = 0; i <repairLogList.size(); i++){
            if (repairLogList.get(i).getMachine().getNAME().equals(machine.getNAME())){
                return repairLogList.get(i);
            }
        }
        return null;
    }
    public int[] getPrioritylogCount(){
        int lowcount = 0;
        int mediumcount = 0;
        int highcount = 0;
        for (int i = 0; i <repairLogList.size(); i++){
            System.out.println("search looping start");
            if(repairLogList.get(i).getPriority().equals("Low Priority")){
                lowcount++;
                System.out.println("found 1 low");
            }
            else if(repairLogList.get(i).getPriority().equals("Medium Priority")){
                mediumcount++;
                System.out.println("found 1 mdeium");
            }
            else if(repairLogList.get(i).getPriority().equals("High Priority")){
                highcount++;
                System.out.println("found 1 high");
            }
            else{
                System.out.println("not found");
            }
        }
        //0-low 1-med 2-high
        int [] logcount = {lowcount,mediumcount,highcount};
        return logcount;
    }
    public int[] getOperationalCount(){
        int total = 0;
        int operational=0, needRepair=0;
        for (ArcadeMachine machine : machinesList){
            total++;
            if (machine.getIsWorking()){
                operational++;
            }else{
                needRepair++;
            }
        };
        //total-0 operational-1 needRepair-2
        int [] operationalCount = {total,operational,needRepair};
        return operationalCount;
    }
    private int[] getTechnicianAvail() {
        int total = 0;
        int available = 0;
        int busy = 0;

        for (Technician tech : getTechnicianList()) {
            total++;
            if (tech.getBusy()) {
                busy++;
            } else {
                available++;
            }
        }
        return new int[]{total,available,busy};
    }
    public void loadLogPanel(DefaultTableModel TbModel, javax.swing.JTextField totalLogTF, javax.swing.JTextField highTF, javax.swing.JTextField lowTF, javax.swing.JTextField mediumTF){
        if (repairLogList == null) return;
        totalLogTF.setText(String.valueOf(repairLogList.size()));
        int [] logCount = getPrioritylogCount();
        highTF.setText(String.valueOf(logCount[2]));
        lowTF.setText(String.valueOf(logCount[0]));
        mediumTF.setText(String.valueOf(logCount[1]));

        //log table
        for (int i =0; i<repairLogList.size(); i++){
            RepairLog log = repairLogList.get(i);
            String [] stringarr = {log.getMachine().getNAME(), log.getTechnician().getNAME(),log.getDescription(), log.getNotes(), log.getPriority() };
            TbModel.addRow(stringarr);
        }
    }
    public void loadMachinePanel(DefaultTableModel MachineDatabaseTbModel, javax.swing.JTextField totalUnitTF, javax.swing.JTextField operationalTF, javax.swing.JTextField needRepairTF, DefaultComboBoxModel<String> machineNameModel){
        //load the table
        MachineDatabaseTbModel.setRowCount(0); // clear old rows

        for (ArcadeMachine machine : getMachineList()) {
            MachineDatabaseTbModel.addRow(new Object[]{
                    machine.getID(),
                    machine.getNAME(),
                    machine.getYEARMADE(),
                    machine.getIsWorking() ? "Yes" : "No"
            });
        }
        //load the text field
        int [] operationalCount = getOperationalCount();
        totalUnitTF.setText(String.valueOf(operationalCount[0]));
        operationalTF.setText(String.valueOf(operationalCount[1]));
        needRepairTF.setText(String.valueOf(operationalCount[2]));

        //load the comboBox
        machineNameModel.removeAllElements();
        for (ArcadeMachine machine : getMachineList()){
            machineNameModel.addElement(machine.getNAME());
        }
    }
    public void loadTechnicainPanel(DefaultTableModel technicianTBModel ,javax.swing.JTextField totalTechTF,javax.swing.JTextField availableTF,javax.swing.JTextField busyTF){
        //load table
        technicianTBModel.setRowCount(0); // clear table first
        for (Technician tech : getTechnicianList()) {
            technicianTBModel.addRow(new Object[]{
                    tech.getID(),
                    tech.getNAME(),
                    tech.getBusy() ? "Yes" : "No"
            });
        }
        //load text field
        int [] technicianCount = getTechnicianAvail();
        totalTechTF.setText(String.valueOf(technicianCount[0]));
        availableTF.setText(String.valueOf(technicianCount[1]));
        busyTF.setText(String.valueOf(technicianCount[2]));

    }
    public boolean isInteger(String value){
        try{
            int valueOfString = Integer.parseInt(value);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }
    public boolean isDouble(String value){
        System.out.println("start checking double");
        try{
            Double.parseDouble(value);
            System.out.println("this is a vlid double");
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }
}
