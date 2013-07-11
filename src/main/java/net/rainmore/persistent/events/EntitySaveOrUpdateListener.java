package net.rainmore.persistent.events;

import net.rainmore.common.DataEntity;
import net.rainmore.common.EntityAuditableInterface;
import org.hibernate.event.internal.DefaultSaveOrUpdateEventListener;
import org.hibernate.event.spi.SaveOrUpdateEvent;
import org.joda.time.DateTime;

public class EntitySaveOrUpdateListener extends DefaultSaveOrUpdateEventListener {
    @Override
    public void onSaveOrUpdate(SaveOrUpdateEvent event) {
        System.out.println("Save or Update Event");

        if (event.getObject() instanceof DataEntity) {
            DataEntity record = (DataEntity) event.getObject();

            // set the Updated date/time
            record.setSysUpdatedDate(new DateTime());

            // set the Created date/time
            if (record.getSysCreatedDate() == null) {
                record.setSysCreatedDate(new DateTime());
            }

            System.out.println(record.getSysCreatedDate().toString());
            System.out.println(record.getSysUpdatedDate().toString());
        }
    }
}
