package my.arcadeApp;

import java.time.LocalDate;

public class RepairLog {

    private ArcadeMachine machine;
    private Technician technician;
    private LocalDate repairDate;
    private String notes;

    public RepairLog(ArcadeMachine machine , Technician technician , String notes) {
        this.machine = machine;
        this.technician = technician;
        this.notes = notes;
        this.repairDate = LocalDate.now();
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
}
