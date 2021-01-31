package com.warbabank.car;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.warbabank.car.controller.CarServiceController;
import com.warbabank.car.model.CarService;
import com.warbabank.car.service.CarServices;

@RunWith(SpringRunner.class)
@WebMvcTest(CarServiceController.class)
public class CarServiceControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	CarServices carServices;
	
	@Test
	public void getServicesTest() {
		
		List<CarService> carService = new ArrayList<CarService>();
		carService.add(new CarService(1,100,101,"Bens","FirstService","Done Full service",null));
		carService.add(new CarService(2,100,101,"Benz","FirstService","Done Full service",null));
		carService.add(new CarService(3,100,101,"Benz","FirstService","Done Full service",null));
		carService.add(new CarService(4,100,104,"Benz","FirstService","Done Full service",null));
		
		try {
			when(carServices.getCarServices("Benz")).thenReturn(carService);
			
			mockMvc.perform(get("/carservice/Benz").contentType(MediaType.APPLICATION_JSON))
		      .andExpect(status().isOk()).andExpect(jsonPath("$.length()", is((4))));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void addServiceTest() {
		
		String exampleService="{\"serviceId\": \"100\",\"carId\":\" 130\",\"customerId\": \"101\",\"carName\": \"RolseRoice\",\"serviceName\": \"FirstService\",\"serviceNotes\": \"Done Full service\",\"serviceDate\": \"null\"	}";
		
		try {
			RequestBuilder requestBuilder = MockMvcRequestBuilders
					.post("/carservice/new")
					.accept(MediaType.APPLICATION_JSON).content(exampleService)
					.contentType(MediaType.APPLICATION_JSON);

			MvcResult result = mockMvc.perform(requestBuilder).andReturn();
			MockHttpServletResponse response = result.getResponse();
			assertEquals(HttpStatus.CREATED.value(), response.getStatus());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
