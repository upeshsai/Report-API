package com.mastercard.billingsearch.ReportAPI;

import com.mastercard.billingsearch.ReportAPI.entity.OfflineRequests;
import com.mastercard.billingsearch.ReportAPI.repository.BillingReportRepository;
import com.mastercard.billingsearch.ReportAPI.service.BillingReportService;
import javafx.application.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.*;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.MOCK, classes={ Application.class })
@AutoConfigureMockMvc
public class ReportApiApplicationTests {
	@InjectMocks
	BillingReportService billingReportService;
    @Mock
	BillingReportRepository billingReportRepository;
    @Mock
	OfflineRequests offlineRequests;
//	@Before
//	public void setUp() {
//		this.mockMvc = webAppContextSetup(webApplicationContext).build();
//	}


    @Test
	public void getRequestReportDetailsByIdTests(){
    	billingReportService.getRequestReportServiceById(1);

	}

}
