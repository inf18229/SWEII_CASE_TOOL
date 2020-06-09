package Model.projectData;

public abstract class M_projectData_Estimation {

	/**
	 * actual value
	 */
	public double actualValue = 0;
	/**
	 * nominal value
	 */
	public double setpoint = 0;

	/**
	 *
	 * @param actualValue
	 * @param setpoint
	 */
	public M_projectData_Estimation(double actualValue, double setpoint) {
		// TODO - implement M_projectData_Estimation.M_projectData_Estimation
		throw new UnsupportedOperationException();
	}

	public abstract void estimate();

}