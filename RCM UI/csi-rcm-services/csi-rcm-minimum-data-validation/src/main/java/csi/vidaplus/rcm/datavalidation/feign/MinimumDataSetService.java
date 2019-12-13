package csi.vidaplus.rcm.datavalidation.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import csi.vidaplus.rcm.datavalidation.model.MessageInfo;
import csi.vidaplus.rcm.datavalidation.model.ValidationClass;

@FeignClient(value="csi-rcm-minimum-data",fallback=MinimumDataSetServiceFallback.class)
public interface MinimumDataSetService {

	@RequestMapping(value="validationfields/{classToValidate}",method=RequestMethod.GET)
	public ValidationClass getValidationClass(@PathVariable("classToValidate") String classToValidate);
	
	@RequestMapping(value="validationmessageinfo",method=RequestMethod.GET)
	public MessageInfo gteValidationMessageInfo();
	
}
