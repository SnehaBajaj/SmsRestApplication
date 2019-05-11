package demo.auzmor.sms.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Size;

@Getter
public class Sms {

    @JsonProperty
    @Size(min = 6, max = 16)
    private String from;

    @JsonProperty
    @Size(min = 6, max = 16)
    private String to;

    @JsonProperty
    @Size(min = 1, max = 120)
    private String text;

    @JsonCreator
    public Sms(String from, String to, String text) {
        this.from = from;
        this.to = to;
        this.text = text;
    }
}
