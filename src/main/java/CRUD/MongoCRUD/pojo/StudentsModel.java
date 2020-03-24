package CRUD.MongoCRUD.pojo;

public class StudentsModel {

	int id;
	String name;
	int roll;
	String sec;
	String address;

	public StudentsModel(int id, String name, int roll, String sec, String address) {
		this.id = id;
		this.name = name;
		this.roll = roll;
		this.sec = sec;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	public String getSec() {
		return sec;
	}

	public void setSec(String sec) {
		this.sec = sec;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}





}
