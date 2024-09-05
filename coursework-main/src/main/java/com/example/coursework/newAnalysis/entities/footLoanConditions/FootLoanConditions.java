package com.example.coursework.newAnalysis.entities.footLoanConditions;

import com.example.coursework.newAnalysis.entities.bodyLoanConditions.BodyLoanConditions;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.lang.reflect.Field;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class FootLoanConditions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private boolean isDoubleBid;

    @Column
    private double basicPercentage;
    @Column
    private double percentageIncludingInsurance;
    @Column
    private double maximumPayment;
    @Column
    private double averageEPOnRequest;
    @Column
    private double EPIncludingInsurance;

    public FootLoanConditions(Object footLoanConditions) throws ParseException, IllegalAccessException {
        FootLoanConditions newFootLoanConditions = this;
        Field[] fields = newFootLoanConditions.getClass().getDeclaredFields();
        JSONObject jo = (JSONObject)(new JSONParser().parse(footLoanConditions.toString()));
        for (int i = 1; i < fields.length; i++) {
            if (fields[i].getType().equals(int.class)) {
                fields[i].setInt(newFootLoanConditions, Integer.parseInt(jo.get(fields[i].getName()).toString()));

            } else if (fields[i].getType().equals(boolean.class)) {
                fields[i].setBoolean(newFootLoanConditions, Boolean.parseBoolean(jo.get(fields[i].getName()).toString()));

            } else if (fields[i].getType().equals(double.class)) {
                fields[i].setDouble(newFootLoanConditions, Double.parseDouble(jo.get(fields[i].getName()).toString()));

            } else {
                fields[i].set(newFootLoanConditions, jo.get(fields[i].getName()));
            }
        }
    }
}