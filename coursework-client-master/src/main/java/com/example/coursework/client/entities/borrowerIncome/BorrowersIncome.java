package com.example.coursework.client.entities.borrowerIncome;

import jakarta.persistence.*;
import lombok.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.lang.reflect.Field;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class BorrowersIncome {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private double minimumIncome;
	@Column
	private double FSSP;
	@Column
	private String verificationResult;

	public BorrowersIncome(Object borrowersIncome) throws ParseException, IllegalAccessException {
		BorrowersIncome newBorrowersIncome = this;
		Field[] fields = newBorrowersIncome.getClass().getDeclaredFields();
		JSONObject jo = (JSONObject)(new JSONParser().parse(borrowersIncome.toString()));
		for (int i = 1; i < fields.length; i++) {
			if (fields[i].getType().equals(int.class)) {
				fields[i].setInt(newBorrowersIncome, Integer.parseInt(jo.get(fields[i].getName()).toString()));

			} else if (fields[i].getType().equals(boolean.class)) {
				fields[i].setBoolean(newBorrowersIncome, Boolean.parseBoolean(jo.get(fields[i].getName()).toString()));

			} else if (fields[i].getType().equals(double.class)) {
				fields[i].setDouble(newBorrowersIncome, Double.parseDouble(jo.get(fields[i].getName()).toString()));

			} else {
				fields[i].set(newBorrowersIncome, jo.get(fields[i].getName()));
			}
		}
	}
}
