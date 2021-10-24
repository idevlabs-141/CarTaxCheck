package com.cartaxcheck;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import util.BeanLibrary;

@SpringBootTest(classes={BeanLibrary.class})
@TestPropertySource(value={"classpath:application.properties"})
class CarTaxCheckApplicationTests {

	@Test
	void contextLoads() {
	}
}
