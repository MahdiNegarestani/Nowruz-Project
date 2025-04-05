package org.project.Entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class entity {
    private String Id;
    private final LocalDateTime Created_at;
    private final LocalDateTime Modified_T;

    public entity() {
        this.Id = UUID.randomUUID().toString();
        this.Created_at = LocalDateTime.now();
        this.Modified_T = LocalDateTime.now();
    }

    public String getId() {return Id;}

    public LocalDateTime getCreated_at() {return Created_at;}

    public LocalDateTime getModified_T() {return Modified_T;}
}