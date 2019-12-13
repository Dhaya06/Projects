package com.csi.vidaplus.rcm.claim.repository;

import com.csi.vidaplus.rcm.claim.entity.Claim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by Ahsan on 2/4/2018.
 */
@Repository
public interface ClaimRepository extends JpaRepository<Claim, String>,JpaSpecificationExecutor<Claim> {
}
