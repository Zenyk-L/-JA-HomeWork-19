package ua.lviv.lgs.dto;

public class PhotoUploadResponse {

	private String firstName;
	private String lastName;
	private Integer age;

	private String fileName;
	private String fileDownloadUri;
	private String fileType;
	private long size;

	public PhotoUploadResponse() {
	}

	public PhotoUploadResponse(String firstName, String lastName, Integer age, String fileName, String fileDownloadUri,
			String fileType, long size) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.fileName = fileName;
		this.fileDownloadUri = fileDownloadUri;
		this.fileType = fileType;
		this.size = size;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileDownloadUri() {
		return fileDownloadUri;
	}

	public void setFileDownloadUri(String fileDownloadUri) {
		this.fileDownloadUri = fileDownloadUri;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "PhotoUploadResponse [firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", fileName="
				+ fileName + ", fileDownloadUri=" + fileDownloadUri + ", fileType=" + fileType + ", size=" + size + "]";
	}
	
	

}
