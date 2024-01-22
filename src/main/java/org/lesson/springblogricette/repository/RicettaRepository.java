package org.lesson.springblogricette.repository;

import org.lesson.springblogricette.model.Ricetta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RicettaRepository extends JpaRepository<Ricetta,Integer> {
}
