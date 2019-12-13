package com.csi.vidaplus.rcm.claim.model.response;

import com.csi.vidaplus.rcm.claim.entity.Claim;

import java.util.List;

/**
 * Created by Ahsan on 2/19/2018.
 */
public class ClaimResponse {
    String insuranceGroupName;
    List<Company> companyList;

    public String getInsuranceGroupName() {
        return insuranceGroupName;
    }

    public void setInsuranceGroupName(String insuranceGroupName) {
        this.insuranceGroupName = insuranceGroupName;
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

    public static class Company{
        String companyName;
        List<Claim> claimList;

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public List<Claim> getClaimList() {
            return claimList;
        }

        public void setClaimList(List<Claim> claimList) {
            this.claimList = claimList;
        }
    }

}
