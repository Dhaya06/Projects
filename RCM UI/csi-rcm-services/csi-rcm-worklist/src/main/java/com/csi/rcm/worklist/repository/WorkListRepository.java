package com.csi.rcm.worklist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.csi.rcm.worklist.model.WorkList;
import com.csi.rcm.worklist.model.type.Status;

/**
 * @author Kasun
 * @version 0.0.1
 * @since 2018/01/26
 */
@Repository
public interface WorkListRepository extends JpaRepository<WorkList, Long>,JpaSpecificationExecutor<WorkList>{

	public List<WorkList> findByNameAndDeleted(String name,Boolean deleted);
	
	public List<WorkList> findByDeleted(Boolean deleted);
	
	public List<WorkList> findByStatusAndDeleted(Status status,Boolean deleted);

}
