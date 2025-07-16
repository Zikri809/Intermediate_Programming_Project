
package my.arcadeApp;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;
import java.util.*;


public class ArcadeManager {

    //the <> specifies the type of element going to be inside the list
    // used as it is flexible compared to array
    //the length can increase dynamically as more object is added, polymorphism used
    private List<ArcadeMachine> machinesList = new ArrayList<>();
    private List<Technician> technicianList = new ArrayList<>();
    private List<RepairLog> repairLogList = new ArrayList<>();

    //add or remove the object from the array list
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
    public void addRepairLog(RepairLog repairLog){
        repairLogList.add(repairLog);
    }

    //returns the array list
    public List<ArcadeMachine> getMachineList(){
        return machinesList;

    }
    public List<Technician> getTechnicianList(){
        return technicianList;
    }
    public List<RepairLog> getRepairLogList(){
        return repairLogList;
    }

    //find the object in the list by the paams id or name
    //use method overloading
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
    public RepairLog findRepairLogInList(int logId){
        for (int i = 0; i <repairLogList.size(); i++){
            if (repairLogList.get(i).getId()== logId){
                return repairLogList.get(i);
            }
        }
        return null;
    }

    //returns an array of values with each index are noted by the meaning
    public int[] getPrioritylogCount(){
        int lowcount = 0;
        int mediumcount = 0;
        int highcount = 0;
        for (int i = 0; i <repairLogList.size(); i++){
            if(repairLogList.get(i).getPriority().equals("Low Priority") && !repairLogList.get(i).getIsCompleted()){
                lowcount++;
            }
            else if(repairLogList.get(i).getPriority().equals("Medium Priority") && !repairLogList.get(i).getIsCompleted()){
                mediumcount++;
            }
            else if(repairLogList.get(i).getPriority().equals("High Priority") && !repairLogList.get(i).getIsCompleted()){
                highcount++;
            }
        }
        //0-total 1-low 2-mde 3-high
        int total = lowcount + mediumcount + highcount;
        int [] logcount = {total,lowcount,mediumcount,highcount};
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

    //get num of log completed in the list
    private int getCompleted(){
        int total = 0;
        for(int i = 0;i<repairLogList.size();i++){
            if(repairLogList.get(i).getIsCompleted()){
                total++;
            }
        }
        return total;
    }

    //methods below uses encapsulation as the refreshing logic is hidden under a class
    public void loadLogPanel(DefaultTableModel TbModel, javax.swing.JTextField completedLogTF, javax.swing.JTextField waitingLogTF, javax.swing.JTextField highTF, javax.swing.JTextField lowTF, javax.swing.JTextField mediumTF,DefaultComboBoxModel<String> repairLogCb ){
        if (repairLogList == null) return;
        //this 2 ensures that the previous addition is removed thus preventing any duplicates as this is bind to 2 button
        TbModel.setRowCount(0);
        repairLogCb.removeAllElements();

        int [] logCount = getPrioritylogCount();
        waitingLogTF.setText(String.valueOf(logCount[0]));
        highTF.setText(String.valueOf(logCount[3]));
        lowTF.setText(String.valueOf(logCount[1]));
        mediumTF.setText(String.valueOf(logCount[2]));

        completedLogTF.setText(String.valueOf(getCompleted()));

        //log table
        for (int i =0; i<repairLogList.size(); i++){
            RepairLog log = repairLogList.get(i);
            String [] stringarr = {String.valueOf(log.getId()),log.getMachine().getNAME(), log.getTechnician().getNAME(),log.getDescription(), log.getNotes(), log.getPriority(), log.getIsCompleted() ? "Yes" : "No" };
            TbModel.addRow(stringarr);
        }
        //load the comboBox
        for (int i =0; i<repairLogList.size(); i++){
            repairLogCb.addElement(repairLogList.get(i).getId()+" - "+repairLogList.get(i).getMachine().getNAME());
        }

    }
    public void loadAddLOgPanel(DefaultComboBoxModel<String> machineNameModel , DefaultComboBoxModel<String> technicianNameModel ){
        machineNameModel.removeAllElements();
        technicianNameModel.removeAllElements();
        for(int i =0 ; i<machinesList.size(); i++){
            machineNameModel.addElement(machinesList.get(i).getNAME());
        }
        for(int i =0 ; i<technicianList.size(); i++){
            technicianNameModel.addElement(technicianList.get(i).getNAME());
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
                    machine.getIsWorking() ? "Yes" : "No",
                    String.format("RM %.2f",machine.getPrice()),
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
    public void loadTechnicainPanel(DefaultTableModel technicianTBModel ,javax.swing.JTextField totalTechTF,javax.swing.JTextField availableTF,javax.swing.JTextField busyTF, DefaultComboBoxModel<String>technicianName_Model){
        //load table
        technicianTBModel.setRowCount(0); // clear table first
        for (Technician tech : getTechnicianList()) {
            technicianTBModel.addRow(new Object[]{
                    tech.getID(),
                    tech.getNAME(),
                    tech.getBusy() ? "Busy" : "Free"
            });
        }
        //load text field
        int [] technicianCount = getTechnicianAvail();
        totalTechTF.setText(String.valueOf(technicianCount[0]));
        availableTF.setText(String.valueOf(technicianCount[1]));
        busyTF.setText(String.valueOf(technicianCount[2]));

    }

    //checking the variable types
    public boolean isInteger(String value){
        try{
            Integer.parseInt(value);
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
            System.out.println("this is a valid double");
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }
}
