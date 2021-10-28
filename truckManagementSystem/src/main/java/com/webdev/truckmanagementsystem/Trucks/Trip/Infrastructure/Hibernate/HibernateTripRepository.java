package com.webdev.truckmanagementsystem.Trucks.Trip.Infrastructure.Hibernate;

import com.webdev.truckmanagementsystem.Shared.Domain.Ids.TripId;
import com.webdev.truckmanagementsystem.Shared.Domain.Ids.TruckId;
import com.webdev.truckmanagementsystem.Shared.Infrastructure.Hibernate.HibernateRepository;
import com.webdev.truckmanagementsystem.Trucks.Trip.Domain.Ports.TripRepository;
import com.webdev.truckmanagementsystem.Trucks.Trip.Domain.Trip;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Transactional("transactional-manager")
public class HibernateTripRepository extends HibernateRepository<Trip> implements TripRepository {

    public HibernateTripRepository(@Qualifier("session-factory") SessionFactory sessionFactory) {
        super(sessionFactory, Trip.class);
    }

    @Override
    public void save(Trip trip) {
        persist(trip);
    }

    @Override
    public void update(Trip trip) {
        updateEntity(trip);
    }

    @Override
    public Optional<Trip> find(TripId id) {
        return byId(id);
    }

    @Override
    public Optional<List<Trip>> all() {
        return getAll();
    }

    @Override
    public void delete(Trip trip) {
        deleteEntity(trip);
    }

    @Override
    public Optional<List<Trip>> findByTruckId(TruckId truckId) {
        Trip trip = null;
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<Trip> cr = cb.createQuery(Trip.class);
        Root<Trip> root = cr.from(Trip.class);
        cr.select(root).where(cb.equal(root.get("truckId"), truckId));
        List<Trip> trips = sessionFactory.getCurrentSession().createQuery(cr).getResultList();
        return Optional.ofNullable(trips);
    }
}
