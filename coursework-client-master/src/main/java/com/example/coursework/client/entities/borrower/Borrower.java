package com.example.coursework.client.entities.borrower;

import jakarta.persistence.*;
import lombok.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.lang.reflect.Field;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Borrower {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String fullName;
	@Column
	private String dateOfBirth;
	@Column
	private boolean isSalaryProject;
	@Column
	private int dependents;
	@Column
	private double income;
	@Column
	private String confirmation;
	@Column
	private boolean isDelayOfMoreThanDays;
	@Column
	private boolean isBankrupt;
	@Column
	private int scoring;

    public Borrower(Object borrower) throws ParseException, IllegalAccessException {
		Borrower newBorrower = this;
		Field[] fields = newBorrower.getClass().getDeclaredFields();
		JSONObject jo = (JSONObject)(new JSONParser().parse(borrower.toString()));
		for (int i = 1; i < fields.length; i++) {
			if (fields[i].getType().equals(int.class)) {
				fields[i].setInt(newBorrower, Integer.parseInt(jo.get(fields[i].getName()).toString()));

			} else if (fields[i].getType().equals(boolean.class)) {
				fields[i].setBoolean(newBorrower, Boolean.parseBoolean(jo.get(fields[i].getName()).toString()));

			} else if (fields[i].getType().equals(double.class)) {
				fields[i].setDouble(newBorrower, Double.parseDouble(jo.get(fields[i].getName()).toString()));

			} else {
				fields[i].set(newBorrower, jo.get(fields[i].getName()));
			}
		}
    }
}
