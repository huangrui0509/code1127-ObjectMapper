package com.example.om.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {
	private static final long serialVersionUID = 4464233896798170487L;
	private String name;
	private int age;

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
