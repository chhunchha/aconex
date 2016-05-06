package com.aconex.cost.contract.controllers;

import com.aconex.cost.contract.models.Contract;
import com.aconex.cost.contract.services.ContractService;
import com.codahale.metrics.MetricRegistry;
import com.google.common.collect.Lists;
import com.google.common.io.ByteStreams;
import io.dropwizard.testing.junit.ResourceTestRule;
import io.dropwizard.views.ViewMessageBodyWriter;
import io.dropwizard.views.mustache.MustacheViewRenderer;
import org.joda.time.DateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.ByteArrayInputStream;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class ContractsControllerTest {

    private static final ContractService contractService = mock(ContractService.class);

    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addProvider(new ViewMessageBodyWriter(new MetricRegistry(), Collections.singleton(new MustacheViewRenderer())))
            .addResource(new ContractsController(contractService))
            .build();

    @Before
    public void setup() {
        when(contractService.findAll()).thenReturn(Lists.newArrayList(
                new Contract().setCode("CON-01").setCreatedAt(DateTime.now()).setBudget(1000)
        ));
    }

    @After
    public void tearDown() throws Exception {
        reset(contractService);
    }

    @Test
    public void testGetIndex() throws Exception {
        Response response = resources.client().target("/contracts").request().get();
        assertEquals(MediaType.TEXT_HTML, response.getMediaType().toString());

        String html = new String(ByteStreams.toByteArray(ByteArrayInputStream.class.cast(response.getEntity())));
        assertTrue(html.contains("CON-01"));
        verify(contractService).findAll();

    }
}
