package fr.ynov.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
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
    private String type;
    /**
     * code of Response
     */
    private String code;
    /**
     * description of Response
     */
    private String desc;
    /**
     * payload of Response
     */
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
    @XmlElement(name="type")
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
    @XmlElement(name="code")
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
    @XmlElement(name="description")
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
    @XmlElement(name="payload", nillable = true)
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
