package com.example.coursework.newAnalysis.entities.footGeneralInformation;

import com.example.coursework.newAnalysis.entities.footLoanConditions.FootLoanConditions;
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
public class FootGeneralInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String executor;
    public FootGeneralInformation(Object footGeneralInformation) throws ParseException, IllegalAccessException {
        FootGeneralInformation newFootGeneralInformation = this;
        Field[] fields = newFootGeneralInformation.getClass().getDeclaredFields();
        JSONObject jo = (JSONObject)(new JSONParser().parse(footGeneralInformation.toString()));
        for (int i = 1; i < fields.length; i++) {
            if (fields[i].getType().equals(int.class)) {
                fields[i].setInt(newFootGeneralInformation, Integer.parseInt(jo.get(fields[i].getName()).toString()));

            } else if (fields[i].getType().equals(boolean.class)) {
                fields[i].setBoolean(newFootGeneralInformation, Boolean.parseBoolean(jo.get(fields[i].getName()).toString()));

            } else if (fields[i].getType().equals(double.class)) {
                fields[i].setDouble(newFootGeneralInformation, Double.parseDouble(jo.get(fields[i].getName()).toString()));

            } else {
                fields[i].set(newFootGeneralInformation, jo.get(fields[i].getName()));
            }
        }
    }
}