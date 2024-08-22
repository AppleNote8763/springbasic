package com.cys.springbasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cys.springbasic.dto.Lombok;

@SpringBootApplication
public class SpringbasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbasicApplication.class, args);
	}

	void lombokExample() {

		Lombok lombok = new Lombok("a", "b", "c", false, false);
		lombok.getField1();
		lombok.setField3(null);

		// lombok = new Lombok();
		lombok = new Lombok("d", "e");

		// lombok.getField4();	// 기본형 boolean일 경우 getter 메서드 이름은 isXXX()
		lombok.isField4();
		lombok.getField5();

	}

}
