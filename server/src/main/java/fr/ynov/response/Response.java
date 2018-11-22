package fr.ynov.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


@JsonRootName(value = "Response")
/**
 * Class that represents a Response object
 *
 * @author Ludovic
 * @since v0
 */
public class Response {
    /**
     * type of Response
     */
	@JsonProperty("type")
    private String type;
    /**
     * code of Response
     */
	@JsonProperty("code")
    private String code;
    /**
     * description of Response
     */
	@JsonProperty("desc")
    private String desc;
    /**
     * payload of Response
     * */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("payload")
    private Object payload;

    /**
     * Constructor.
     * @param type of Response
     * @param code of Response
     * @param desc of Response
     */
    public Response(String type, String code, String desc) {
        this.type = type;
        this.code = code;
        this.desc = desc;
        this.payload = null;
    }

    /**
     * Constructor.
     * @param type of Response
     * @param code of Response
     * @param desc of Response
     * @param payload of Response
     */
    public Response(String type, String code, String desc, Object payload) {
        this.type = type;
        this.code = code;
        this.desc = desc;
        this.payload = payload;
    }

    /**
     * Getter for type property
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Setter for type property
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Getter for code property
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter for code property
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Getter for description property
     * @return description
     */
    public String getDesc() {
        return desc;
    }

    /**
     * Setter for description property
     * @param desc
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * Getter for payload property
     * @return payload
     */
    public Object getPayload() {
        return payload;
    }

    /**
     * Setter for payload property
     * @param payload
     */
    public void setPayload(Object payload) {
        this.payload = payload;
    }
}

