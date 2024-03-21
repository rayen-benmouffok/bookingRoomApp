package com.amayas.roomApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.amayas.roomApp.Entity.Utilisateur;

public interface UtilisateurRepository  extends JpaRepository<Utilisateur, Long> {
	Utilisateur findByUserName(String userName);
}
