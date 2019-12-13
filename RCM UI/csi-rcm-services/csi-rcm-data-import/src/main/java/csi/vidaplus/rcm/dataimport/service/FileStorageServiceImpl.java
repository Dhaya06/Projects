package csi.vidaplus.rcm.dataimport.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;

import csi.vidaplus.rcm.dataimport.repository.FileStorageRepository;

@Service
public class FileStorageServiceImpl implements FileStorageService{

	@Autowired
	private FileStorageRepository repository; 
	
	@Override
	public String store(MultipartFile file,String referenceId,String filetype,String field) {
		
		DBObject metaData = new BasicDBObject();
		metaData.put("referenceId", referenceId);
		metaData.put("filetype", filetype);
		metaData.put("field", field);
		
		try {
			return repository.store(file.getInputStream(), file.getOriginalFilename(), file.getContentType(), metaData);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public GridFSDBFile retrieve(String fileName) {
		return repository.retrive(fileName);
	}

	@Override
	public List<GridFSDBFile> getByReferenceId(String referenceId) {
		return repository.getByReferenceId(referenceId);
	}

	@Override
	public GridFSDBFile getByFilename(String filename) {
		return repository.getByFilename(filename);
	}

	@Override
	public List<GridFSDBFile> findAll() {
		return repository.findAll();
	}

	
	@Override
	public void delete(String referenceId, String field) {
		repository.delete(referenceId, field);
	}
	
	@Override
	public Map<String,List<String>> getFileIdMapByReferenceId(String referenceId) {
		Map<String,List<String>> fileIdMap = new HashMap<>();
		
		List<GridFSDBFile> attachments = repository.getByReferenceId(referenceId);
		for (GridFSDBFile gridFSDBFile : attachments) {
			
			String id = gridFSDBFile.getId().toString();
			String field = (String)gridFSDBFile.getMetaData().get("field");
			
			if(fileIdMap.containsKey(field)) {
				List<String> list = fileIdMap.get(field);
				list.add(id);
			}else {
				List<String> list = new LinkedList<>();
				list.add(id);
				fileIdMap.put(field, list);
			}
			
		}
		
		return fileIdMap;
	}
	
	@Override
	public GridFSDBFile getById(String id) {
		GridFSDBFile fsdbFile = repository.getById(id);
		return fsdbFile;
	}
}
