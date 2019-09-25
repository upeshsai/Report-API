package com.mastercard.billingsearch.ReportAPI.repository;

import com.mastercard.billingsearch.ReportAPI.entity.OfflineRequests;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingReportRepository extends JpaRepository<OfflineRequests, Integer> {
}
