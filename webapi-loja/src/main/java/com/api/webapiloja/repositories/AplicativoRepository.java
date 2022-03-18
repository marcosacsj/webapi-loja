package com.api.webapiloja.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.webapiloja.entities.Aplicativo;


@Repository
public interface AplicativoRepository extends JpaRepository<Aplicativo, UUID>{

}
