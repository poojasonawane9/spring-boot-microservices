package com.capgemini.springbootmicroservicecurrencyconversion;

import java.math.BigDecimal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversionController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	private CurrencyExchangeServiceProxy proxy;
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to,
		      @PathVariable BigDecimal quantity) {
		CurrencyConversionBean response = proxy.retrieveExchangeValue(from, to);
		logger.info("{}", response);
		return  new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
		        quantity.multiply(response.getConversionMultiple()), response.getPort());
		
	}

//	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
//	public CurrencyConversionBean convertCurrency(@PathVariable String from,@PathVariable String to,@PathVariable BigDecimal quantity) {
//		
//		Map<String,String> urivariables = new HashMap<>();
//		urivariables.put("from", from);
//		urivariables.put("to", to);
//		
//		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8080/currency-exchange/from/{from}/to/{to}",
//				CurrencyConversionBean.class,urivariables);
//		
//		CurrencyConversionBean response = responseEntity.getBody();
//		
//		return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
//		        quantity.multiply(response.getConversionMultiple()), response.getPort());
//	}
}
