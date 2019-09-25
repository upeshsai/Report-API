package com.mastercard.billingsearch.ReportAPI.service;

import com.mastercard.billingsearch.ReportAPI.entity.OfflineRequests;
import com.mastercard.billingsearch.ReportAPI.model.OfflineGetResponse;
import com.mastercard.billingsearch.ReportAPI.model.OfflinePostRequest;
import com.mastercard.billingsearch.ReportAPI.repository.BillingReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class BillingReportService {
@Autowired
    BillingReportRepository billingReportRepository;

public OfflineGetResponse getRequestReportServiceById(Integer requestId){
    OfflineGetResponse offlineGetResponse=new OfflineGetResponse();
    offlineGetResponse.setLink(billingReportRepository.findById(requestId).get().getPath());
    offlineGetResponse.setRequestId(billingReportRepository.findById(requestId).get().getRequestId());
    offlineGetResponse.setStatus(billingReportRepository.findById(requestId).get().getStatus());
    offlineGetResponse.setRequestedTimestamp(billingReportRepository.findById(requestId).get().getCreatedTimestamp());
    return offlineGetResponse;
}

public OfflineRequests postRequestReportService(OfflinePostRequest offlinePostRequest){
     OfflineRequests offlineRequests=new OfflineRequests();
     offlineRequests.setSearchCriteria(offlinePostRequest.getSearchCriteria());
     offlineRequests.setFeederType(offlinePostRequest.getFeederType());
     offlineRequests.setReportType(offlinePostRequest.getReportType());
     offlineRequests.setUserId("SN20098787");//need to fetch it from SAML token
     offlineRequests.setPath("http://www.google.com");//temp
     offlineRequests.setStatus("INITIATED");//temp
    offlineRequests.setIsDeleted("Y");//temp
     offlineRequests.setCreatedTimestamp(getDate());
    billingReportRepository.save(offlineRequests);
     return  offlineRequests;
}

    public String getDate() {

        LocalDateTime current = LocalDateTime.now();
        System.out.println("current date and time : " +
                current);
        DateTimeFormatter format =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        String formatedDateTime = current.format(format);
        System.out.println("formatedDateTime :" + formatedDateTime);
        return formatedDateTime;

    }
}
