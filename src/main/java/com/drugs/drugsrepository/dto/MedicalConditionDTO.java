package com.drugs.drugsrepository.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class MedicalConditionDTO {

    private String medical_condition;
    private String medical_condition_description;
    private String medical_condition_url;

}
