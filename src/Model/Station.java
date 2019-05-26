package Model;

public class Station {

	private String name;
	private String adress;
	private String buses;

	public Station(String n, String a, String b) {
		name = n;
		adress = a;
		buses = b;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getBuses() {
		return buses;
	}

	public void setBuses(String buses) {
		this.buses = buses;
	}

	@Override
	public String toString() {
		return name;
	}

}
