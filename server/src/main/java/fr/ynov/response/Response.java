package fr.ynov.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Response {
    private String type;
    private String code;
    private String desc;
    private Object payload;

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

    @XmlElement(name="type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlElement(name="code")
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @XmlElement(name="description")
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @XmlElement(name="payload", nillable = true)
    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }
}
