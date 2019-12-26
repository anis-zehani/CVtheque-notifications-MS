package com.odix.fr.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.odix.fr.model.Candidat;
import com.odix.fr.model.Notification;
import com.odix.fr.model.Opportunite;
import com.odix.fr.model.PartenaireTemporaire;
import com.odix.fr.model.Utilisateur;
import com.odix.fr.service.NotificationService;

@CrossOrigin
@RestController
@RequestMapping("/api/notification")
public class NotificationController {
	
	@Autowired
	NotificationService notificationService;
	
	@GetMapping("/all/{idDestinataire}/{etatNotification}")
	public List<Notification> getAllNotifications(@PathVariable UUID idDestinataire, @PathVariable String etatNotification) {
	    return notificationService.getAllNotificationsByUtilisateur(idDestinataire, etatNotification);
	}
	
	@PostMapping("/generateSimpleNotification")
	public void generateSimpleNotification
	(
			   @PathVariable  String objetNotification, 
			   @PathVariable  String corpsNotification,
			   @PathVariable List<Utilisateur> listeDestinatairesNotification, 
			   @PathVariable Utilisateur generateurNotification,
			   @PathVariable Candidat candidatNotification,
			   @PathVariable PartenaireTemporaire partenaireNotification,
			   @PathVariable Opportunite opportuniteNotification
	) 
	{
		notificationService.generateSimpleNotification
		(
				objetNotification, 
				corpsNotification, 
				listeDestinatairesNotification, 
				generateurNotification, 
				candidatNotification, 
				partenaireNotification, 
				opportuniteNotification
		);
	}
	
	@DeleteMapping("/{idNotification}")
	public Boolean deactivateNotification(@PathVariable UUID idNotification) {
	    return notificationService.deactivateNotification(idNotification);
	}

}
