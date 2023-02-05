package com.metrix.webportal.domains;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SellForm {
    private int eventId;
    //1. Annotation for checking minimum value = 1, if not, view will show error message "Number of ticket must at least 1"
    //2. Annotation for checking maximum value = 100, if not, view will show error message "Number of ticket must less than 100"
    //to prevent the do while of generating unique qr code long run
    private int numberOfTicket;
}
