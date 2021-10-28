package com.webdev.truckmanagementsystem.Trucks.Truck.Infrastructure.Hibernate;


import com.webdev.truckmanagementsystem.Shared.Domain.Ids.OwnerId;
import com.webdev.truckmanagementsystem.Shared.Domain.Ids.TruckId;
import com.webdev.truckmanagementsystem.Shared.Infrastructure.Hibernate.HibernateRepository;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Ports.TruckRepository;
import com.webdev.truckmanagementsystem.Trucks.Truck.Domain.Truck;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateTruckRepository extends HibernateRepository<Truck> implements TruckRepository {

    public HibernateTruckRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        super(sessionFactory, Truck.class);
    }

    @Override
    public void save(Truck truck) {
        persist(truck);
    }

    @Override
    public Optional<Truck> find(TruckId Id) {
        return byId(Id);
    }

    @Override
    public void update(Truck truck) {
        updateEntity(truck);
    }

    @Override
    public Optional<List<Truck>> all() {
        return getAll();
    }

    @Override
    public void delete(Truck truck) {
        delete(truck);
    }

    @Override
    public Optional<List<Truck>> findByOwnerId(OwnerId id) {
        Truck truck = null;
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Truck> cr = cb.createQuery(Truck.class);
        Root<Truck> root = cr.from(Truck.class);
        cr.select(root).where(cb.equal(root.get("ownerId"), id));
        List<Truck> trucks = sessionFactory.getCurrentSession().createQuery(cr).getResultList();
        return Optional.ofNullable(trucks);
    }
}
