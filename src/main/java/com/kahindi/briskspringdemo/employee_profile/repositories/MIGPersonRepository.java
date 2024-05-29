package com.kahindi.briskspringdemo.employee_profile.repositories;


import com.kahindi.briskspringdemo.employee_profile.entities.MIGPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MIGPersonRepository extends JpaRepository<MIGPerson, Long> {
}
