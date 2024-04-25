package com.drugs.drugsrepository.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DrugsBank implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(columnDefinition="TEXT", length = 1000)
    private String drug_name;
    @Column(columnDefinition="TEXT", length = 1000)
    private String medical_condition;
    @Column(columnDefinition="TEXT", length = 1000)
    private String side_effects;
    @Column(columnDefinition="TEXT", length = 1000)
    private String generic_name;
    @Column(columnDefinition="TEXT", length = 1000)
    private String drug_classes;
    @Column(columnDefinition="TEXT", length = 1000)
    private String brand_names;
    @Column(columnDefinition="TEXT", length = 1000)
    private String activity;
    @Column(columnDefinition="TEXT", length = 1000)
    private String rx_otc;
    @Column(columnDefinition="TEXT", length = 1000)
    private String pregnancy_category;
    @Column(columnDefinition="TEXT", length = 1000)
    private String csa;
    @Column(columnDefinition="TEXT", length = 1000)
    private String alcohol;
    @Column(columnDefinition="TEXT", length = 1000)
    private String related_drugs;
    @Column(columnDefinition="TEXT", length = 1000)
    private String medical_condition_description;
    @Column(columnDefinition="TEXT", length = 1000)
    private String rating;
    @Column(columnDefinition="TEXT", length = 1000)
    private String no_of_reviews;
    @Column(columnDefinition="TEXT", length = 1000)
    private String drug_link;
    @Column(columnDefinition="TEXT", length = 1000)
    private String medical_condition_url;
}
