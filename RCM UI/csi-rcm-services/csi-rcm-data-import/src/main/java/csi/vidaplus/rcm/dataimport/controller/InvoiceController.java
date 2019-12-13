package csi.vidaplus.rcm.dataimport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.csi.microservices.base.service.BaseService;

import csi.vidaplus.rcm.dataimport.model.EncounterInvoice;
import csi.vidaplus.rcm.dataimport.service.EncounterInvoiceService;

@RestController
@RequestMapping("/rcm/import/encounterinvoice")
public class InvoiceController extends BaseService {

	@Autowired
	private EncounterInvoiceService invoiceService;

	@PostMapping
	public ResponseEntity<List<EncounterInvoice>> importEncounterInvoice(
			@RequestBody List<EncounterInvoice> encounterInvoices) {

		List<EncounterInvoice> insertedInvoices = invoiceService.insert(encounterInvoices);

		return new ResponseEntity<List<EncounterInvoice>>(insertedInvoices, HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<List<EncounterInvoice>> updateEncounterInvoice(
			@RequestBody List<EncounterInvoice> encounterInvoices) {

		List<EncounterInvoice> updatedInvoices = invoiceService.update(encounterInvoices);

		return new ResponseEntity<List<EncounterInvoice>>(updatedInvoices, HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<List<EncounterInvoice>> deleteEncounterInvoice(@RequestParam("ids") List<String> ids) {

		List<EncounterInvoice> deletedInvoices = invoiceService.delete(ids);

		return new ResponseEntity<List<EncounterInvoice>>(deletedInvoices, HttpStatus.OK);
	}

}
