package com.lopessystem.notification.repository;

import com.lopessystem.notification.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Notification repository.
 */
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
