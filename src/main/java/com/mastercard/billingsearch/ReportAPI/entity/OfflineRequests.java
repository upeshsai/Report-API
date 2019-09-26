package com.mastercard.billingsearch.ReportAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OfflineRequests {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer requestId;
    private String userId;
    private String feederType;
    private String searchCriteria;
    private String status;
    private String path;
    private String isDeleted;
    private String reportType;
    private String createdTimestamp;
    private String requestedTimestamp;
}
