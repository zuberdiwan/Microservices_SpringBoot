package com.microservices.ratingservice.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rating {
    @Id
    private  String ratingId;
    private  String userId;
    private  String hotelId;
    private  int rating;
    private  String feedback;
}
