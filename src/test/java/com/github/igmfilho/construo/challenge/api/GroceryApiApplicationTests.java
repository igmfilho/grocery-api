package com.github.igmfilho.construo.challenge.api;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.github.igmfilho.construo.challenge.GroceryApiApplication;

import lombok.extern.java.Log;

@ExtendWith(OutputCaptureExtension.class)
@ExtendWith(SpringExtension.class)
@Log
class GroceryApiApplicationTests {
	
	private static final String SPRING_APP_STARTED = "Started GroceryApiApplication";

	/**
	 * Setting up properties for the tests.
	 * @author ivan.filho
	 */
	@BeforeAll
    public static void setup() {
		log.info("All settings have been completed");
	}

	@Test
	
	public void whenAppIsStarted_thenOutputShouldContainsAString(CapturedOutput output) {
		GroceryApiApplication.main(new String[0]);
		assertThat(output.toString()).contains(SPRING_APP_STARTED);
	}
}
