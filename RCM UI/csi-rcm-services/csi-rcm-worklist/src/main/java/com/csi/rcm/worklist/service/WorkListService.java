package com.csi.rcm.worklist.service;

import java.util.List;

import com.csi.rcm.worklist.model.WorkList;
import com.csi.rcm.worklist.request.WorklistSearchModel;

/**
 * @author Kasun
 * @version 0.0.1
 * @since 2018/01/26
 */
public interface WorkListService {

	/**
	 * Method is use to save new {@link WorkList}
	 * @param workList
	 */
	public void save(WorkList workList);

	/**
	 * Method is use to update {@link WorkList}
	 * @param workList
	 */
	public void update(WorkList workList);
	
	/**
	 * Method is use to get all {@link WorkList}s
	 * @return
	 */
	public List<WorkList> getAll();
	
	/**
	 * Method is use to get {@link WorkList} from {@code id}
	 * @param id if the worklist
	 * @return worklist
	 */
	public WorkList getById(Long id);

	/**
	 * Method us use to delete {@link WorkList} from id
	 * @param id of the worklist to be deleted
	 */
	public void deleteById(Long id);
	
	/**
	 * Method is used to search active {@link WorkList}
	 * @param searchModel
	 */
	
	public List<WorkList> search(WorklistSearchModel searchModel);

	/**
	 * Method is used to get active {@link WorkList} from name 
	 * @return list of {@link WorkList} 
	 */
	public List<WorkList> getWorklistByName(String name);

	
	/**
	 * Method is used to get active worklists.
	 * @return list of active {@link WorkList}
	 */
	public List<WorkList> getActiveWorklist();
	
}
