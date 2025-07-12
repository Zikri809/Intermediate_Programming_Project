package my.arcadeApp;

import java.time.LocalDate;

public class RepairLog {

    private ArcadeMachine machine;
    private Technician technician;
    private LocalDate repairDate;
    private String notes;
    private String description;
    private String priority;
    private boolean isCompleted;

    public RepairLog(ArcadeMachine machine , Technician technician , String notes, String description, String priority) {
        this.machine = machine;
        this.technician = technician;
        this.notes = notes;
        this.repairDate = LocalDate.now();
        this.description = description;
        this.priority = priority;
        this.isCompleted = false;
    }

    public ArcadeMachine getMachine (){
        return machine;
    }
    public Technician getTechnician() {
        return technician;
    }
    public LocalDate getRepairDate() {
        return repairDate;
    }
    public String getNotes() {
        return notes;
    }
    public String getDescription() {
        return description;
    }
    public String getPriority() {
        return priority;
    }
    public boolean getIsCompleted() {
        return isCompleted;
    }


    public void setTechnician(Technician technician) {
        this.technician = technician;
    }
    public void setNotes (String notes) {
        this.notes = notes;
    }
    public void setMachine(ArcadeMachine machine){
        this.machine = machine;
    }
    public void setRepairDate(LocalDate repairDate) {
        this.repairDate = repairDate;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }
    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }
}
