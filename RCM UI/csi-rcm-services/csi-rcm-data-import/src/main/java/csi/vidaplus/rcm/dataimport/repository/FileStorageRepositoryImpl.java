package csi.vidaplus.rcm.dataimport.repository;

import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Repository;

import com.mongodb.DBObject;
import com.mongodb.gridfs.GridFSDBFile;

@Repository
public class FileStorageRepositoryImpl implements FileStorageRepository {

	@Autowired
	private GridFsTemplate gridFsTemplate;
	
	@Autowired
	private GridFsOperations gridFsOperations;

	public String store(InputStream inputStream, String fileName, String contentType, DBObject metaData) {
		return this.gridFsTemplate.store(inputStream, fileName, contentType, metaData).getId().toString();
	}

	public List<GridFSDBFile> getByReferenceId(String referenceId) {
		return this.gridFsOperations.find(new Query(Criteria.where("metadata.referenceId").is(referenceId)));
	}
	
	public GridFSDBFile getByFilename(String fileName) {
		return gridFsTemplate.findOne(new Query(Criteria.where("filename").is(fileName)));
	}

	public GridFSDBFile retrive(String fileName) {
		return gridFsOperations.findOne(new Query(Criteria.where("filename").is(fileName)));
	}

	public List<GridFSDBFile> findAll() {
		return gridFsTemplate.find(null);
	}

	public void delete(String referenceId,String field) {
		gridFsOperations.delete(new Query(Criteria.where("metadata.referenceId").is(referenceId).and("metadata.field").is(field)));
	}
	
	@Override
	public GridFSDBFile getById(String id) {
		return gridFsOperations.findOne(new Query(Criteria.where("_id").is(id)));
	}
}
