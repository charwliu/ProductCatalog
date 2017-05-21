package com.ngboss.eep.catalog.hub.service.productOffering;

import java.util.Date;
import javax.ejb.Local;

import com.ngboss.eep.catalog.model.product.ProductOffering;
import com.ngboss.eep.catalog.hub.model.productOffering.ProductOfferingEvent;

/**
 *
 * @author bahman.barzideh
 *
 */
@Local
public interface ProductOfferingEventPublisherLocal {

    void publish(ProductOfferingEvent event);

    public void createNotification(ProductOffering bean, String reason, Date date);

    public void deletionNotification(ProductOffering bean, String reason, Date date);

    public void updateNotification(ProductOffering bean, String reason, Date date);

    public void valueChangedNotification(ProductOffering bean, String reason, Date date);
}
