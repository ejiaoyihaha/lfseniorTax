package junit.test.entity;

import java.io.Serializable;

public class Person implements Serializable {
	private String id;//UUID保存该数据（uuid是唯一的）
	private String name;
	
	public Person() {
		super();
	}
	public Person(String name){
		this.name=name;
	}
	public Person(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
	
}
