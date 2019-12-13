package csi.vidaplus.rcm.datavalidation.feign;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import csi.vidaplus.rcm.datavalidation.model.MessageInfo;
import csi.vidaplus.rcm.datavalidation.model.ValidationClass;

@Component
public class MinimumDataSetServiceFallback implements MinimumDataSetService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public ValidationClass getValidationClass(String classToValidate) {
		logger.error("Faild MinimumDataSetService, calling MinimumDataSetServiceFallback.getValidationClass");
		
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(classToValidate + "-minimum-data.json").getFile());

		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(file, ValidationClass.class);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	@Override
	public MessageInfo gteValidationMessageInfo() {
		logger.error("Faild MinimumDataSetService, calling MinimumDataSetServiceFallback.gteValidationMessageInfo");
		
		MessageInfo info = new MessageInfo();
		info.setRecevierId("db2cb850-f9d9-11e7-9c6c-1d4e612ab27c");
		info.setRecevierUserId("KASUN");
		info.setNotificationType("PUSH");
		info.setNotificationMessageType("ALERT");
		return info;
	}

}
