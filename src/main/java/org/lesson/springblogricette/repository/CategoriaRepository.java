package org.lesson.springblogricette.repository;

import org.lesson.springblogricette.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {
}
