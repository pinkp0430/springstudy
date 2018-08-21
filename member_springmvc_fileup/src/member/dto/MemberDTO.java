package member.dto;

import org.springframework.web.multipart.MultipartFile;

public class MemberDTO {
	private String id;
	private String password;
	private String name;
	private String registerNumber1;
	private String registerNumber2;
	private int mileage;
	private String pictureFilename;
	private MultipartFile upfile;
	public MemberDTO() {
	}
	
	
	public MemberDTO(String id, String password, String name,
			String registerNumber1, String registerNumber2, int mileage,
			String pictureFilename, MultipartFile upfile) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.registerNumber1 = registerNumber1;
		this.registerNumber2 = registerNumber2;
		this.mileage = mileage;
		this.pictureFilename = pictureFilename;
		this.upfile = upfile;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getRegisterNumber1() {
		return registerNumber1;
	}


	public void setRegisterNumber1(String registerNumber1) {
		this.registerNumber1 = registerNumber1;
	}


	public String getRegisterNumber2() {
		return registerNumber2;
	}


	public void setRegisterNumber2(String registerNumber2) {
		this.registerNumber2 = registerNumber2;
	}


	public int getMileage() {
		return mileage;
	}


	public void setMileage(int mileage) {
		this.mileage = mileage;
	}


	public String getPictureFilename() {
		return pictureFilename;
	}


	public void setPictureFilename(String pictureFilename) {
		this.pictureFilename = pictureFilename;
	}


	public MultipartFile getUpfile() {
		return upfile;
	}


	public void setUpfile(MultipartFile upfile) {
		this.upfile = upfile;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + mileage;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result
				+ ((pictureFilename == null) ? 0 : pictureFilename.hashCode());
		result = prime * result
				+ ((registerNumber1 == null) ? 0 : registerNumber1.hashCode());
		result = prime * result
				+ ((registerNumber2 == null) ? 0 : registerNumber2.hashCode());
		result = prime * result + ((upfile == null) ? 0 : upfile.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberDTO other = (MemberDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mileage != other.mileage)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (pictureFilename == null) {
			if (other.pictureFilename != null)
				return false;
		} else if (!pictureFilename.equals(other.pictureFilename))
			return false;
		if (registerNumber1 == null) {
			if (other.registerNumber1 != null)
				return false;
		} else if (!registerNumber1.equals(other.registerNumber1))
			return false;
		if (registerNumber2 == null) {
			if (other.registerNumber2 != null)
				return false;
		} else if (!registerNumber2.equals(other.registerNumber2))
			return false;
		if (upfile == null) {
			if (other.upfile != null)
				return false;
		} else if (!upfile.equals(other.upfile))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "MemberDTO [id=" + id + ", password=" + password + ", name="
				+ name + ", registerNumber1=" + registerNumber1
				+ ", registerNumber2=" + registerNumber2 + ", mileage="
				+ mileage + ", pictureFilename=" + pictureFilename
				+ ", upfile=" + upfile + "]";
	}
	
	
	
}
