package com.ngboss.eep.catalog.exception;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.ngboss.eep.commons.exceptions.ExceptionBean;
import com.ngboss.eep.commons.exceptions.KeyValue;

@XmlRootElement
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class JsonError {

    private ExceptionBean error;
    private String detail;
    private List<KeyValue> keyValue;

    public JsonError(ExceptionBean error) {
        this.error = error;
    }

    public JsonError(ExceptionBean error, String detail) {
        this.error = error;
        this.detail = detail;
    }

    public JsonError(ExceptionBean error, String detail, List<KeyValue> keyValue) {
        this.error = error;
        this.detail = detail;
        this.keyValue = keyValue;
    }

    /**
     * @return the type
     */
    public ExceptionBean getError() {
        return error;
    }

    /**
     * @param type the type to set
     */
    public void setError(ExceptionBean error) {
        this.error = error;
    }

    /**
     * @return the detail
     */
    public String getDetail() {
        return detail;
    }

    /**
     * @param detail the detail to set
     */
    public void setDetail(String detail) {
        this.detail = detail;
    }

    /**
     * @return the keyValue
     */
    public List<KeyValue> getKeyValue() {
        return keyValue;
    }

    public void addKeyValue(KeyValue keyValue) {
        if (this.keyValue == null)  {
            this.keyValue = new ArrayList<>();
        }
        this.keyValue.add(keyValue);
    }
}
