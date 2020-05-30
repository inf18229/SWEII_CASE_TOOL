package Model.projectData;

public abstract class M_projectData_Estimation {
    //actual value
    public double actualValue = 0;
    //nominal value
    public double setpoint = 0;

    public M_projectData_Estimation(double actualValue, double setpoint) {
        this.actualValue = actualValue;
        this.setpoint = setpoint;
    }
    public abstract void estimate();
}
