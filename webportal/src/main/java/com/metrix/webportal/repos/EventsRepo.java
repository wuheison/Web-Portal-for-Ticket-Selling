package com.metrix.webportal.repos;

import org.springframework.data.jpa.repository.*;
import com.metrix.webportal.models.Events;

public interface EventsRepo extends JpaRepository<Events, Integer>/*
                                                                   * 1. extends a JPA class that provide CRUD
                                                                   * function on Events object
                                                                   */ {

}
