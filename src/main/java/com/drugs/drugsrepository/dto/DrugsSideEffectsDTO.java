package com.drugs.drugsrepository.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DrugsSideEffectsDTO{
        String drug_name, medical_condition,side_effects,pregnancy_category, rx_otc, related_drugs,medical_condition_description;
}
