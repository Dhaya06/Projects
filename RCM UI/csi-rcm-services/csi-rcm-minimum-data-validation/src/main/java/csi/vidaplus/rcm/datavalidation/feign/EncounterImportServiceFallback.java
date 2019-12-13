package csi.vidaplus.rcm.datavalidation.feign;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import csi.vidaplus.rcm.datavalidation.model.Encounter;

@Component
public class EncounterImportServiceFallback implements EncounterImportService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public List<Encounter> getUnprocessed() {
		logger.error("Faild EncounterImportService, calling EncounterImportServiceFallback.getUnprocessed");
		return null;
	}

	@Override
	public List<Encounter> updateencounter(List<Encounter> encounters) {
		logger.error("Faild EncounterImportService, calling EncounterImportServiceFallback.updateencounter");
		return null;
	}
	
	@Override
	public Map<String, List<String>> getAttachmentIds(String referanceId) {
		logger.error("Faild EncounterImportService, calling EncounterImportServiceFallback.getAttachmentIds");
		return null;
	}
	
}
