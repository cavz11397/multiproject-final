package co.com.poli.cloud.commons;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {
    private Object data;
    private Integer status;
}