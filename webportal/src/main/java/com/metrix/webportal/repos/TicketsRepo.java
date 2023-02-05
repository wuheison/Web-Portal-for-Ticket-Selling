package com.metrix.webportal.repos;

import java.util.*;
import org.springframework.data.jpa.repository.*;
import com.metrix.webportal.models.Tickets;

public interface TicketsRepo extends JpaRepository<Tickets, Integer>/*
                                                                     * 1. extends a JPA class that provide CRUD function
                                                                     * on Tickets object
                                                                     */ {
    // 1. Annotation for abstract function, filter the tickets records in DB against
    // QR Code
    @Query("SELECT t FROM Tickets t where t.qrcode = :qrcode")
    // 2. Abstract function the return a Optional<Tickets> and accept a String
    // parameter "qrcode"
    Optional<Tickets> filterQrcode(String qrcode);
}