package com.mastercard.billingsearch.ReportAPI.controller;

import com.mastercard.billingsearch.ReportAPI.entity.OfflineRequests;
import com.mastercard.billingsearch.ReportAPI.model.OfflineGetResponse;
import com.mastercard.billingsearch.ReportAPI.model.OfflinePostRequest;
import com.mastercard.billingsearch.ReportAPI.model.OfflinePostResponse;
import com.mastercard.billingsearch.ReportAPI.service.BillingReportService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/billing/requests")
public class BillingReportController {
    @Autowired
    BillingReportService billingReportService;


    @PostMapping()
    public ResponseEntity<OfflinePostResponse> postRequestReportDetails(@RequestBody OfflinePostRequest offlinePostRequest){
               Integer id=billingReportService.postRequestReportService(offlinePostRequest).getRequestId();
               OfflinePostResponse offlinePostResponse = new OfflinePostResponse("Successfully created the offline request",id);
                 return  ResponseEntity.ok(offlinePostResponse);
    }

    @GetMapping("/{requestId}")
    public OfflineGetResponse getRequestReportDetailsById(@PathVariable Integer  requestId){
      return billingReportService.getRequestReportServiceById(requestId);
    }

    @DeleteMapping("/{requestId}")
    public ResponseEntity<String> deleteRequestReportById(@PathVariable Integer requestId){
        billingReportService.deleteRequestReportServiceById(requestId);
        return  ResponseEntity.ok("Successfully deleted the offline request");
    }

    @PutMapping("/{requestId}")
        public ResponseEntity<String> updateRequestReportById(@RequestBody OfflinePostRequest offlinePostRequest,@PathVariable Integer requestId){
        billingReportService.updateRequestReportServiceById(offlinePostRequest,requestId);
        return  ResponseEntity.ok("Successfully updated the offline request");
    }
}
