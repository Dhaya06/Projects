package csi.vidaplus.rcm.dataimport.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.mongodb.gridfs.GridFSDBFile;

public interface FileStorageService {

	public String store(MultipartFile file,String referenceId,String filetype,String field);

	public GridFSDBFile getById(String id);
	
	public GridFSDBFile retrieve(String fileName);

	public List<GridFSDBFile> getByReferenceId(String referenceId);
	
	public Map<String,List<String>> getFileIdMapByReferenceId(String referenceId);

	public GridFSDBFile getByFilename(String filename);

	public List<GridFSDBFile> findAll();
	
	public void delete(String referenceId,String field);
}
