package csi.vidaplus.rcm.dataimport.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import csi.vidaplus.rcm.dataimport.model.Encounter;


@FeignClient(value="csi-rcm-minimum-data-validation", fallback=MinimumDataValidationServiceFallBack.class)
public interface MinimumDataValidationService {

	@RequestMapping(method=RequestMethod.GET)
	public List<Encounter> validateMinimumData();
	
	
}
