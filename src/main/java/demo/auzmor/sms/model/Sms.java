package demo.auzmor.sms.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Sms {

    private String from;
    private String to;
    private String text;
}
