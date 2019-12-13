package csi.vidaplus.rcm.dataimport.controller;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.csi.microservices.base.service.BaseService;
import com.mongodb.gridfs.GridFSDBFile;

import csi.vidaplus.rcm.dataimport.service.FileStorageService;

@RestController
@RequestMapping("/rcm/import/attachment")
public class AttachmentController extends BaseService{

	@Autowired
	private FileStorageService fileStorageService;

	@PostMapping("attachment/{referenceId}/{field}/{filetype}")
	public ResponseEntity<HttpStatus> saveAttachment(@RequestParam("file") MultipartFile file,
			@PathVariable String referenceId, @PathVariable String field, @PathVariable String filetype) {

		fileStorageService.store(file, referenceId, filetype, field);

		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@GetMapping("attachment/{referenceId}/ids")
	public ResponseEntity<Map<String, List<String>>> getAttachmentIds(@PathVariable String referenceId) {
		Map<String, List<String>> fileIdMapByreferenceId = fileStorageService.getFileIdMapByReferenceId(referenceId);
		return new ResponseEntity<Map<String, List<String>>>(fileIdMapByreferenceId, HttpStatus.OK);
	}

	@GetMapping("attachment/{id}")
	public ResponseEntity<InputStreamResource> getAttachment(@PathVariable String id) throws IOException {
		GridFSDBFile gridFSDBFile = fileStorageService.getById(id);

		InputStreamResource resource = new InputStreamResource(gridFSDBFile.getInputStream());

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=" + gridFSDBFile.getFilename())
				.contentLength(gridFSDBFile.getLength())
				.contentType(MediaType.parseMediaType(gridFSDBFile.getContentType())).body(resource);

	}

	@DeleteMapping("attachment/{referenceId}/{field}")
	public ResponseEntity<HttpStatus> deleteAttachment(@PathVariable String referenceId, @PathVariable String field) {
		fileStorageService.delete(referenceId, field);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

}
