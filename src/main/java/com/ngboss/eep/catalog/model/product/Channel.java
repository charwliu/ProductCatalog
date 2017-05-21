package com.ngboss.eep.catalog.model.product;

import com.ngboss.eep.commons.Utilities;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author bahman.barzideh
 *
 * {
 *     "id": "13",
 *     "href": "http://serverlocation:port/marketSales/channel/13",
 *     "name": "Online Channel"
 * }
 *
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Embeddable
public class Channel implements Serializable {

    public final static long serialVersionUID = 1L;

    @Column(name = "CHANNEL_ID")
    private String id;

    @Column(name = "CHANNEL_HREF")
    private String href;

    @Column(name = "CHANNEL_NAME")
    private String name;

    public Channel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 7;

        hash = 97 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 97 * hash + (this.href != null ? this.href.hashCode() : 0);
        hash = 97 * hash + (this.name != null ? this.name.hashCode() : 0);

        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        final Channel other = (Channel) object;
        return Utilities.areEqual(this.id, other.id) && Utilities.areEqual(this.href, other.href) && Utilities.areEqual(this.name, other.name);

    }

    @Override
    public String toString() {
        return "Channel{" + "id=" + id + ", href=" + href + ", name=" + name + '}';
    }

    public static Channel createProto() {
        Channel channel = new Channel();

        channel.id = "id";
        channel.href = "href";
        channel.name = "name";

        return channel;
    }

}
