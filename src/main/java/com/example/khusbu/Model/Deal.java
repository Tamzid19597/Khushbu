package com.example.khusbu.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Deal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dealId;
    private Long productId;
    private String productName;
    private String productPrice;
    private String orderTime;
    private String userName;
    private String email;
    private String number;
    private String address;
    private String status;
}
