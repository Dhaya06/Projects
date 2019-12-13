package csi.vidaplus.rcm.dataimport.repository;

import java.io.InputStream;
import java.util.List;

import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;

public interface FileStorageRepository {

	public String store(InputStream inputStream, String fileName, String contentType, DBObject metaData);

	public GridFSDBFile retrive(String fileName);

	public GridFSDBFile getById(String id);
	
	public List<GridFSDBFile> getByReferenceId(String referenceId);

	public GridFSDBFile getByFilename(String filename);

	public List<GridFSDBFile> findAll();

	public void delete(String referenceId,String field);
	
}
