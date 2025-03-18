package model;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder

public class Student {
    private int id;
    private String name;
    private String gender;
    private LocalDate dob;
}
