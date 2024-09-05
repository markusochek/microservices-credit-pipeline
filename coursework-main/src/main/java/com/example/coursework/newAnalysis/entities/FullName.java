package com.example.coursework.newAnalysis.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FullName {
	private String lastName;
	private String firstName;
	private String patronymic;
}
