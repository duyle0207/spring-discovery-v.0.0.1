package com.duylv.springdiscovery.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
public class BaseResponseDTO extends HashMap<String, Object> {

    private String message;

    private String statusCode;

    public BaseResponseDTO(BaseResponseDTO baseResponseDTO) {
    }

    public BaseResponseDTO message(String message) {
        this.message = message;
        return this;
    }

    public BaseResponseDTO statusCode(String statusCode) {
        this.statusCode = statusCode;
        return this;
    }
    
    public BaseResponseDTO build() {
        return new BaseResponseDTO(this);
    }
}
