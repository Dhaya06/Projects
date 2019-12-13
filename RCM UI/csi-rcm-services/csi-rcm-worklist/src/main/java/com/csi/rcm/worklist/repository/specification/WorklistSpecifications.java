package com.csi.rcm.worklist.repository.specification;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;

import com.csi.rcm.worklist.model.WorkList;
import com.csi.rcm.worklist.request.WorklistSearchModel;

public class WorklistSpecifications {

	private static final Logger logger = LoggerFactory.getLogger(WorklistSpecifications.class);
	
	public static Specification<WorkList> searchWorkList(WorklistSearchModel model) {
		
		return new Specification<WorkList>() {

			@Override
			public Predicate toPredicate(Root<WorkList> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> filters =  new ArrayList<>();
				if(model.getName() != null) {
					WorklistSpecifications.logger.info("Searching from name -"+ model.getName());
					
					Predicate equal = cb.like(root.<String>get("name"), "%"+model.getName()+"%");
					filters.add(equal);
				}
				if(model.getFacilities() != null && !model.getFacilities().isEmpty()) {
					WorklistSpecifications.logger.info("Searching from Facilities"+ model.getFacilities());
					
					Predicate predicate = createFilterTypeFilter(root, query, cb, "Facility", model.getFacilities());
					filters.add(predicate);
				}
				
				if(model.getInsuranceGroup() != null && !model.getInsuranceGroup().isEmpty()) {
					WorklistSpecifications.logger.info("Searching from Insurance Groups"+ model.getInsuranceGroup());
					
					Predicate predicate = createFilterTypeFilter(root, query, cb, "Insurance Group", model.getInsuranceGroup());
					filters.add(predicate);
				}
				
				if(model.getCompany() != null && !model.getCompany().isEmpty()) {
					WorklistSpecifications.logger.info("Searching from Company"+ model.getCompany());
					
					Predicate predicate = createFilterTypeFilter(root, query, cb, "Company Name / ID", model.getCompany());
					filters.add(predicate);
				}
				
				if(model.getDateFrom() != null) {
					WorklistSpecifications.logger.info("Searching from Company activeFrom greater than or equal "+ model.getDateFrom());
					
					Predicate fromDateFilter = cb.greaterThanOrEqualTo(root.<Date>get("activeFrom"), model.getDateFrom());
					filters.add(fromDateFilter);
				}
				
				if(model.getDateTo() != null) {
					WorklistSpecifications.logger.info("Searching from Company activeFrom less than or equal "+ model.getDateTo());
					
					Predicate fromDateFilter = cb.lessThanOrEqualTo(root.<Date>get("activeFrom"), model.getDateTo());
					filters.add(fromDateFilter);
				}
				
				if(model.getAssignee() != null && !model.getAssignee().isEmpty()) {
					WorklistSpecifications.logger.info("Searching from Company activeFrom staffMember "+ model.getAssignee());
					
					Predicate in = root.join("process").join("staffMember").get("id").in(model.getAssignee());
					filters.add(in);
				}
				
				Predicate equal = cb.equal(root.<String>get("deleted"), Boolean.FALSE);
				filters.add(equal);
				
				query.distinct(true);
				return cb.and(filters.toArray(new Predicate[0]));
			}
			
			private Predicate createFilterTypeFilter(Root<WorkList> root, CriteriaQuery<?> query, CriteriaBuilder cb,String name,List<String> values) {
				
				Subquery<WorkList> subquery = query.subquery(WorkList.class);
				Root<WorkList> subRoot = subquery.from(WorkList.class);
				subquery.select(subRoot);
				
				Predicate filter = cb.equal(subRoot.join("claimFilters").join("filterType").get("name"), name);
				Predicate filterValues = subRoot.join("claimFilters").join("filterValues").get("filterId").in(values);
				subquery.where(cb.and(filter,filterValues));
				
				return root.get("id").in(subquery);
				
			}
		};
	    
	}
	
	
}
