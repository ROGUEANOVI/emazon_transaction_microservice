package com.pragma.emazon.transaction_microservice.infrastructure.out.jpa.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

import static com.pragma.emazon.transaction_microservice.infrastructure.constant.SupplyTableFields.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = TABLE_NAME)
public class SupplyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = FIELD_ARTICLE_ID)
    private Long articleId;

    @Column(name = FIELD_QUANTITY)
    private Integer quantity;

    @Column(name = FIELD_CREATED_BY_USER_ID)
    private Long createdByUserId;

    @Column(name = FIELD_SUPPLY_DATE)
    private LocalDateTime supplyDate;
}
