package io.devzona.interview_practices.company.ukg.model;

import jakarta.annotation.Nonnull;
import lombok.Data;

import java.io.Serializable;

@Data
public class Employee implements Serializable {

    @Nonnull
    private Integer id;
    //@NotEmpty
    //@Pattern(regx = "")
    private String email;
}
