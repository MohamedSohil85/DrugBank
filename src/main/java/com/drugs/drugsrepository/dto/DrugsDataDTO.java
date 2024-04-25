package com.drugs.drugsrepository.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DrugsDataDTO {
    private String drug_name,medical_condition, generic_name, drug_classes, brand_names, related_drugs, drug_link;

}