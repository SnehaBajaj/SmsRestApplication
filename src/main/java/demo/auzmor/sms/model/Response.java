package demo.auzmor.sms.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Response {

    private String message;
    private String error;
}
