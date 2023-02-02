package com.hotelService.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="hotels")
public class Hotel {

    @Id
    private String hotel_Id= UUID.randomUUID().toString();;
    private String name;
    private String location;
    private String about;


}
