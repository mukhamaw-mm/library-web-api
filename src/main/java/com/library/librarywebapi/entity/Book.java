package com.library.librarywebapi.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private String publishingHouse;

    private LocalDate publishedYear;

    private String description;

    private String page;

    private String type;

    private String image;

    private String orgPrice;

    private String chargesFee;

    private Long libraryId;

    private Long authorId;

    private Long categoryId;

    private Boolean isDeleted;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime updatedDate;



}
