package com.drugs.drugsrepository.dto;

import com.opencsv.bean.CsvBindByName;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DrugsBankDTO {
    @CsvBindByName(column = "drug_name")
    private String drug_name;
    @CsvBindByName(column = "medical_condition")
    private String medical_condition;
    @CsvBindByName(column = "side_effects")
    private String side_effects;
    @CsvBindByName(column = "generic_name")
    private String generic_name;
    @CsvBindByName(column = "drug_classes")
    private String drug_classes;
    @CsvBindByName(column = "brand_names")
    private String brand_names;
    @CsvBindByName(column = "activity")
    private String activity;
    @CsvBindByName(column = "rx_otc")
    private String rx_otc;
    @CsvBindByName(column = "pregnancy_category")
    private String pregnancy_category;
    @CsvBindByName(column = "csa")
    private String csa;
    @CsvBindByName(column = "alcohol")
    private String alcohol;
    @CsvBindByName(column = "related_drugs")
    private String related_drugs;
    @CsvBindByName(column = "medical_condition_description")
    private String medical_condition_description;
    @CsvBindByName(column = "rating")
    private String rating;
    @CsvBindByName(column = "no_of_reviews")
    private String no_of_reviews;
    @CsvBindByName(column = "drug_link")
    private String drug_link;
    @CsvBindByName(column = "medical_condition_url")
    private String medical_condition_url;
}
