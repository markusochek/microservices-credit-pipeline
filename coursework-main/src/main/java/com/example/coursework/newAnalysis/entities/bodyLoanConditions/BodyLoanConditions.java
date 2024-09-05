package com.example.coursework.newAnalysis.entities.bodyLoanConditions;

import com.example.coursework.newAnalysis.entities.forCommercialRealEstate.ForCommercialRealEstate;
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
public class BodyLoanConditions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String repaymentPeriod;
    @Column
    private boolean guarantee;
    @Column
    private String fullNameOfGuarantor;
    @Column
    private String additionalSupport;

    @Column
    private boolean isRealEstateInsurance;
    @Column
    private boolean isLifeInsurance;
    public BodyLoanConditions(Object bodyLoanConditions) throws ParseException, IllegalAccessException {
        BodyLoanConditions newBodyLoanConditions = this;
        Field[] fields = newBodyLoanConditions.getClass().getDeclaredFields();
        JSONObject jo = (JSONObject)(new JSONParser().parse(bodyLoanConditions.toString()));
        for (int i = 1; i < fields.length; i++) {
            if (fields[i].getType().equals(int.class)) {
                fields[i].setInt(newBodyLoanConditions, Integer.parseInt(jo.get(fields[i].getName()).toString()));

            } else if (fields[i].getType().equals(boolean.class)) {
                fields[i].setBoolean(newBodyLoanConditions, Boolean.parseBoolean(jo.get(fields[i].getName()).toString()));

            } else if (fields[i].getType().equals(double.class)) {
                fields[i].setDouble(newBodyLoanConditions, Double.parseDouble(jo.get(fields[i].getName()).toString()));

            } else {
                fields[i].set(newBodyLoanConditions, jo.get(fields[i].getName()));
            }
        }
    }

}