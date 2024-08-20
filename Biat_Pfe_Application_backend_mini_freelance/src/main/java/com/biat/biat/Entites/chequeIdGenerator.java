package com.biat.biat.Entites;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;


public class chequeIdGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) {
        String prefix = "2024"; // Current year
        String query = String.format("SELECT max(c.numero) FROM %s c WHERE c.numero LIKE :prefix",
                obj.getClass().getSimpleName());

        String maxId = (String) session.createQuery(query)
                .setParameter("prefix", prefix + "%")
                .uniqueResult();

        int newId = 1;
        if (maxId != null) {
            int id = Integer.parseInt(maxId.substring(prefix.length()));
            newId = id + 1;
        }

        return prefix + String.format("%06d", newId);
    }
}
