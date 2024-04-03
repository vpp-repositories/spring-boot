package com.virtualpairprogrammers.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.virtualpairprogrammers.domain.Vehicle;

//http://localhost:8080/h2-console/
//jdbc:h2:mem:testdb
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    /*
        "select vehicle from Vehicle as vehicle where vehicle.name =:name "
     */
    public Vehicle findByName(String name);
}
