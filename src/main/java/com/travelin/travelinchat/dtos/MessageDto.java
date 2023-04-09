package com.travelin.travelinchat.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author : Mihai-Cristian Popescu
 * @since : 4/2/2023, Sun
 **/

@Data @NoArgsConstructor @AllArgsConstructor
public class MessageDto implements Serializable {

    private String senderName;
    private String receiverName;
    private String message;
    private String date;
    private String status;
}
