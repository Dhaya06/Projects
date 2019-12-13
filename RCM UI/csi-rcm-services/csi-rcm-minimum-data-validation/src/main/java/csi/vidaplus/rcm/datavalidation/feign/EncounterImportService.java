package csi.vidaplus.rcm.datavalidation.feign;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import csi.vidaplus.rcm.datavalidation.model.Encounter;


@FeignClient(value="rcm-claims-data-import",fallback=EncounterImportServiceFallback.class,url="http://localhost:7777/")
public interface EncounterImportService {

	@RequestMapping(value="/rcm/import/encounter/unprocessed",method=RequestMethod.GET,consumes= {"application/json"})
	public List<Encounter> getUnprocessed();
	
	@RequestMapping(value="/rcm/import/encounter",method=RequestMethod.PUT)
	public List<Encounter> updateencounter(@RequestBody List<Encounter> encounters);
	
	@RequestMapping(value="/rcm/import/attachment/attachment/{referanceId}/ids",method=RequestMethod.GET)
	public Map<String, List<String>> getAttachmentIds(@PathVariable("referanceId") String referanceId);
	
}
