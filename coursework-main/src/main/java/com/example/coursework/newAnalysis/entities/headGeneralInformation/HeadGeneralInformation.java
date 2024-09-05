package com.example.coursework.newAnalysis.entities.headGeneralInformation;

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
public class HeadGeneralInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String version;
    @Column
    private String analysisStatus;
    @Column
    private String view;

    public HeadGeneralInformation(Object headGeneralInformation) throws ParseException, IllegalAccessException {
        HeadGeneralInformation newHeadGeneralInformation = this;
        Field[] fields = newHeadGeneralInformation.getClass().getDeclaredFields();
        JSONObject jo = (JSONObject)(new JSONParser().parse(headGeneralInformation.toString()));
        for (int i = 1; i < fields.length; i++) {
            if (fields[i].getType().equals(int.class)) {
                fields[i].setInt(newHeadGeneralInformation, Integer.parseInt(jo.get(fields[i].getName()).toString()));

            } else if (fields[i].getType().equals(boolean.class)) {
                fields[i].setBoolean(newHeadGeneralInformation, Boolean.parseBoolean(jo.get(fields[i].getName()).toString()));

            } else if (fields[i].getType().equals(double.class)) {
                fields[i].setDouble(newHeadGeneralInformation, Double.parseDouble(jo.get(fields[i].getName()).toString()));

            } else {
                fields[i].set(newHeadGeneralInformation, jo.get(fields[i].getName()));
            }
        }
    }
}