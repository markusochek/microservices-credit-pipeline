package com.example.coursework.newAnalysis.entities.headLoanConditions;

import com.example.coursework.newAnalysis.entities.bodyGeneralInformation.BodyGeneralInformation;
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
public class HeadLoanConditions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private int costOfHousing;
    @Column
    private double PV;

    @Column
    private double minLoanAmount;
    @Column
    private double maxLoanAmount;
    @Column
    private double loanAmount;
    @Column
    private int term;

    public HeadLoanConditions(Object headLoanConditions) throws ParseException, IllegalAccessException {
        HeadLoanConditions newHeadLoanConditions = this;
        Field[] fields = newHeadLoanConditions.getClass().getDeclaredFields();
        JSONObject jo = (JSONObject)(new JSONParser().parse(headLoanConditions.toString()));
        for (int i = 1; i < fields.length; i++) {
            if (fields[i].getType().equals(int.class)) {
                fields[i].setInt(newHeadLoanConditions, Integer.parseInt(jo.get(fields[i].getName()).toString()));

            } else if (fields[i].getType().equals(boolean.class)) {
                fields[i].setBoolean(newHeadLoanConditions, Boolean.parseBoolean(jo.get(fields[i].getName()).toString()));

            } else if (fields[i].getType().equals(double.class)) {
                fields[i].setDouble(newHeadLoanConditions, Double.parseDouble(jo.get(fields[i].getName()).toString()));

            } else {
                fields[i].set(newHeadLoanConditions, jo.get(fields[i].getName()));
            }
        }
    }
}
