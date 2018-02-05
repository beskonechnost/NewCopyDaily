package Entity;

/**
 * Created by Андрей on 26.01.2018.
 */
public class Employee {

    private int codeFilial;
    private int idEmployee;
    private String employeeName;
    private int instruction;

    public Employee() {
    }
    public Employee(int codeFilial, int idEmployee, String employeeName, int instruction) {
        this.codeFilial = codeFilial;
        this.idEmployee = idEmployee;
        this.employeeName = employeeName;
        this.instruction = instruction;
    }

    public int getCodeFilial() {
        return codeFilial;
    }
    public void setCodeFilial(int codeFilial) {
        this.codeFilial = codeFilial;
    }

    public int getIdEmployee() {
        return idEmployee;
    }
    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public int getInstruction() {
        return instruction;
    }
    public void setInstruction(int instruction) {
        this.instruction = instruction;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "codeFilial=" + codeFilial +
                ", idEmployee=" + idEmployee +
                ", employeeName='" + employeeName + '\'' +
                ", instruction=" + instruction +
                '}';
    }
}
