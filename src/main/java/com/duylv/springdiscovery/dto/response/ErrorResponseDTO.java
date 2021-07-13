package com.duylv.springdiscovery.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseDTO extends BaseResponseDTO {

    private String error;

    public ErrorResponseDTO(BaseResponseDTO baseResponseDTO) {
        super(baseResponseDTO);
    }
}
