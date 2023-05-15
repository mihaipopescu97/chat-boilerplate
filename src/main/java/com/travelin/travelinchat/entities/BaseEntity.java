package com.travelin.travelinchat.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

/**
 * @author : Mihai-Cristian Popescu
 * @since : 5/13/2023, Sat
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseEntity {

    @Id
    private String id;

    @Version
    @Field(name = "databaseVersion")
    private Long version;

    @Field(name = "createDate")
    private LocalDateTime createDate = LocalDateTime.now();

}
