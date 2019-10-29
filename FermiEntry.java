package application;

public class FermiEntry {
	private String name, phone;
	private double overtime;
	private int seniority;
	private boolean inBison;
	
	public FermiEntry(String name, String phone, double overtime, int seniority, boolean inBison) {
		this.name = name;
		this.phone = phone;
		this.overtime = overtime;
		this.seniority = seniority;
		this.inBison = inBison;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public double getOvertime() {
		return overtime;
	}

	public void setOvertime(double overtime) {
		this.overtime = overtime;
	}

	public int getSeniority() {
		return seniority;
	}

	public void setSeniority(int seniority) {
		this.seniority = seniority;
	}

	public boolean isInBison() {
		return inBison;
	}

	public void setInBison(boolean inBison) {
		this.inBison = inBison;
	}
}