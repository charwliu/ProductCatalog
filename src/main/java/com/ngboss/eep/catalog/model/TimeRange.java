package com.ngboss.eep.catalog.model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author pierregauthier
 *
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Embeddable
public class TimeRange implements Serializable {

    private final static long serialVersionUID = 1L;

    @Column(name = "START_DATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDateTime;

    @Column(name = "END_DATE_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDateTime;

    public Date getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(Date startDateTime) {
        this.startDateTime = startDateTime;
    }

    public Date getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    @Override
    public String toString() {
        return "TimeRange{" + "startDateTime=" + startDateTime + ", endDateTime=" + endDateTime + '}';
    }

    @JsonIgnore
    public boolean isEmpty() {
        return (startDateTime == null && endDateTime == null);
    }

    @JsonIgnore
    public boolean isValid() {
        if (startDateTime == null || endDateTime == null) {
            return true;
        }

        return endDateTime.after(startDateTime);
    }

    public static TimeRange createProto() {
        TimeRange timeRange = new TimeRange();

        timeRange.setStartDateTime(new Date(0));
        timeRange.setEndDateTime(new Date());

        return timeRange;
    }

}
