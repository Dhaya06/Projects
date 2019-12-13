package com.csi.vidaplus.rcm.claim.repository.specification;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;

import com.csi.vidaplus.rcm.claim.entity.Claim;
import com.csi.vidaplus.rcm.claim.entity.ClaimStatus;
import com.csi.vidaplus.rcm.claim.request.ClaimSearchModel;
import com.google.common.base.Objects;

public class ClaimSpecification {

	private static final Logger logger = LoggerFactory.getLogger(Specification.class);

	public static Specification<Claim> searchClaim(ClaimSearchModel model) {

		return new Specification<Claim>() {

			@Override
			public Predicate toPredicate(Root<Claim> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> filters = new ArrayList<>();
				if (model.getFacilities() != null && !model.getFacilities().isEmpty()) {
					ClaimSpecification.logger.info("Searching from Facilities" + model.getFacilities());
					filters.add(root.<String>get("facilityId").in(model.getFacilities()));
				}

				if (model.getClaimStatus() != null && !model.getClaimStatus().isEmpty()) {
					List<ClaimStatus> claimStatus = new ArrayList();
					for (String status : model.getClaimStatus()) {
						claimStatus.add(ClaimStatus.valueOf(status));
					}
					ClaimSpecification.logger.info("Searching from ClaimStatus" + model.getClaimStatus());
					filters.add(root.<String>get("claimStatus").in(claimStatus));
				}

				if (model.getInsuranceGroups() != null && !model.getInsuranceGroups().isEmpty()) {
					ClaimSpecification.logger.info("Searching from InsuranceGroups" + model.getInsuranceGroups());
					filters.add(root.<String>get("payerId").in(model.getInsuranceGroups()));
				}

				if (model.getCompanyIDs() != null && !model.getCompanyIDs().isEmpty()) {
					ClaimSpecification.logger.info("Searching from CompanyIDs" + model.getCompanyIDs());
					filters.add(root.<String>get("companyId").in(model.getCompanyIDs()));
				}

				if (model.getCompanyNames() != null && !model.getCompanyNames().isEmpty()) {
					ClaimSpecification.logger.info("Searching from CompanyIDs" + model.getCompanyNames());
					filters.add(root.<String>get("companyId").in(model.getCompanyNames()));
				}

				if (model.getPolicies() != null && !model.getCompanyNames().isEmpty()) {
					ClaimSpecification.logger.info("Searching from CompanyNames" + model.getCompanyNames());
					filters.add(root.<String>get("policyNumber").in(model.getPolicies()));
				}

				if (model.getMemberID() != null && !model.getMemberID().isEmpty()) {
					ClaimSpecification.logger.info("Searching from MemberIDs" + model.getCompanyNames());
					filters.add(root.join("patient").get("memberId").in(model.getMemberID()));
				}

				if (model.getEncounterTypes() != null && !model.getEncounterTypes().isEmpty()) {
					ClaimSpecification.logger.info("Searching from EncounterTyps" + model.getEncounterTypes());
					filters.add(root.<String>get("encounterType").in(model.getEncounterTypes()));
				}

				if (model.getClinics() != null && !model.getClinics().isEmpty()) {
					ClaimSpecification.logger.info("Searching from Clinics" + model.getClinics());
					filters.add(root.<String>get("clinicId").in(model.getClinics()));
				}

				if (model.getAssignees() != null && !model.getAssignees().isEmpty()) {
					ClaimSpecification.logger.info("Searching from Assignee" + model.getAssignees());
					filters.add(root.<String>get("process").in(model.getAssignees()));
				}

				if (model.getClaimLabels() != null && !model.getClaimLabels().isEmpty()) {
					ClaimSpecification.logger.info("Searching from Assignee" + model.getClaimLabels());
					filters.add(root.<String>get("claimLable").in(model.getClaimLabels()));
				}

				if (model.getClaimLabelTypes() != null && !model.getClaimLabelTypes().isEmpty()) {
					ClaimSpecification.logger.info("Searching from ClaimLable Type" + model.getClaimLabelTypes());
					filters.add(root.<String>get("claimLableType").in(model.getClaimLabelTypes()));
				}

				if (Objects.equal(model.getDateFilterField(), "serviceDate")) {
					if (model.getDateFrom() != null) {
						ClaimSpecification.logger
								.info("Searching from Company serviceDate greater than or equal " + model.getDateFrom());

						Predicate fromDateFilter = cb.greaterThanOrEqualTo(root.<Date>get("invoiceDateTime"),
								model.getDateFrom());
						filters.add(fromDateFilter);
					}

					if (model.getDateTo() != null) {
						ClaimSpecification.logger
								.info("Searching from Company serviceDate less than or equal " + model.getDateTo());

						Predicate toDateFilter = cb.lessThanOrEqualTo(root.<Date>get("invoiceDateTime"), model.getDateTo());
						filters.add(toDateFilter);
					}
				}

				if (Objects.equal(model.getDateFilterField(), "invoiceDate")) {
					if (model.getDateFrom() != null) {
						ClaimSpecification.logger
								.info("Searching from Company invoiceDate greater than or equal " + model.getDateFrom());

						Predicate fromDateFilter = cb.greaterThanOrEqualTo(root.<Date>get("invoiceDateTime"),
								model.getDateFrom());
						filters.add(fromDateFilter);
					}

					if (model.getDateTo() != null) {
						ClaimSpecification.logger
								.info("Searching from Company invoiceDate less than or equal " + model.getDateTo());

						Predicate toDateFilter = cb.lessThanOrEqualTo(root.<Date>get("invoiceDateTime"), model.getDateTo());
						filters.add(toDateFilter);
					}
				}


				return cb.and(filters.toArray(new Predicate[0]));
			}

		};
	}

}
