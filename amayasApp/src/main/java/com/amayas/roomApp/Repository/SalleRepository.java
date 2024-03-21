package com.amayas.roomApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amayas.roomApp.Entity.Salle;

@Repository
public interface SalleRepository extends JpaRepository<Salle, Long> {
}