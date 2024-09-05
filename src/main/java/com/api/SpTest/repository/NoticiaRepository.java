package com.api.SpTest.repository;

import com.api.SpTest.entity.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticiaRepository extends JpaRepository<Noticia, String> {
}
