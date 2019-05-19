package demo.auzmor.sms.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SmsResponse {

    private String message;
    private String error;
}
