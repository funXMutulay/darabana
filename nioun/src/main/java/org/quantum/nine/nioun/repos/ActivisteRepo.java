package org.quantum.nine.nioun.repos;

import org.quantum.nine.nioun.entities.Activiste;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivisteRepo extends JpaRepository<Activiste, Long> {

}
