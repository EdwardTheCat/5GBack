package fr.ynov.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "Response")
public class Response {
	
	
    private String type;
    private String code;
    private String desc;
    private Object payload;
    
    public Response() {}
    
    public Response(String type, String code, String desc) {
        this.type = type;
        this.code = code;
        this.desc = desc;
        this.payload = null;
    }

    public Response(String type, String code, String desc, Object payload) {
        this.type = type;
        this.code = code;
        this.desc = desc;
        this.payload = payload;
    }
    
    @JsonProperty("type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("description")
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Object getPayload() {
        return payload;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("payload")
    public void setPayload(Object payload) {
        this.payload = payload;
    }
}
