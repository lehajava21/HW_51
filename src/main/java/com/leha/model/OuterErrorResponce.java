package com.leha.model;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class OuterErrorResponce {
    private Integer errorStatus;
    private String message;
    private Map<String, List<String>> errorResponse;
}
