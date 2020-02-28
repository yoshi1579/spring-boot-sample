package com.sample.login.domain.model;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

@Data
public class SignupForm {

    @NotBlank
    private Integer id;

    @NotBlank(message = "{required_check", groups = ValidGroup1.class)
    @Email(groups = ValidGroup2.class)
    private String username;

    @NotBlank
    @Length(min = 4, max = 100)
    @Pattern(regexp="^[a-zA-Z0-9]+$")
    private String password;

    @NotBlank
    private String name;

    @Min(20)
    @Max(100)
    private Integer age;

    @AssertFalse
    private Boolean marriage;

    @NotNull
    @DateTimeFormat(pattern="yyyy/MM/dd")
    private Date birthday;

}
