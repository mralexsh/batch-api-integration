package com.integration.batch;

import com.integration.batch.dto.ApiInfo;
import com.integration.batch.helpers.Payload;
import org.apache.camel.EndpointInject;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.junit5.CamelSpringBootTest;
import org.apache.camel.test.spring.junit5.MockEndpoints;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.annotation.DirtiesContext;

@CamelSpringBootTest
@SpringBootApplication
@MockEndpoints
class BatchApplicationTests {
	@Autowired
	private ProducerTemplate template;

	@Autowired
	private ApiInfo apiInfo;

	@EndpointInject("mock:direct:output")
	private MockEndpoint mock;

	@AfterEach
	void cleanUp() {
		mock.reset();
	}

	@Test
	public void testInfo() throws Exception {
		mock.expectedBodiesReceived(apiInfo);
		template.sendBody("direct:info", "");
		mock.assertIsSatisfied();
	}

	@Test
	public void given_valid_format_return_enriched_employees() throws Exception {
		// TODO: 18.10.2021 Improve this test
		var payload = Payload.fetch("1.json");
		mock.expectedBodiesReceived(payload);
		template.sendBody("direct:action", payload);
		mock.assertIsSatisfied();
	}

}
