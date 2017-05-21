package com.ngboss.eep.catalog.hub.service.productSpecification;

import java.util.Date;
import javax.ejb.Local;

import com.ngboss.eep.catalog.hub.model.productSpecification.ProductSpecificationEvent;
import com.ngboss.eep.catalog.model.product.ProductSpecification;

/**
 *
 * @author bahman.barzideh
 *
 */
@Local
public interface ProductSpecificationEventPublisherLocal {

    void publish(ProductSpecificationEvent event);

    public void createNotification(ProductSpecification bean, String reason, Date date);

    public void deletionNotification(ProductSpecification bean, String reason, Date date);

    public void updateNotification(ProductSpecification bean, String reason, Date date);

    public void valueChangedNotification(ProductSpecification bean, String reason, Date date);
}
