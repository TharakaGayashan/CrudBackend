package com.itfac.amc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.itfac.amc.entity.AmcSerial;

@Repository
public interface AmcSerialRepository extends JpaRepository<AmcSerial, String> {
	@Modifying(clearAutomatically = true, flushAutomatically = true)
	@Query(value = "INSERT INTO amc_number_serial (amc_no, last_serial) VALUES (:amcNo, :lastSerial)", nativeQuery = true)
	void setAmcSerialNo(@Param("amcNo") String amcNo, @Param("lastSerial") int lastSerial);

	@Query(value = "SELECT last_serial FROM amc_number_serial where amc_no = :amcNo ORDER BY ans_id DESC LIMIT 1", nativeQuery = true)
	int getAmcLastSerialNo(@Param("amcNo") String amcNo);
}
