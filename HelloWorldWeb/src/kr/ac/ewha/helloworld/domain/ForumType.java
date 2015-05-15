package kr.ac.ewha.helloworld.domain;

public enum ForumType {
	ALL("A"),
	DEPARTMENT("D");
	
	private String type;
	
	private ForumType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}
	
}
