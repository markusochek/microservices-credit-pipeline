package com.example.coursework.newAnalysis.entities.bodyGeneralInformation;

import com.example.coursework.newAnalysis.entities.headGeneralInformation.HeadGeneralInformation;
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
public class BodyGeneralInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String date;
    @Column
    private String loanProgram;
    @Column
    private String region;
    @Column
    private boolean isSpecialProgramForMedicalWorkers;

    public BodyGeneralInformation(Object bodyGeneralInformation) throws ParseException, IllegalAccessException {
        BodyGeneralInformation newBodyGeneralInformation = this;
        Field[] fields = newBodyGeneralInformation.getClass().getDeclaredFields();
        JSONObject jo = (JSONObject)(new JSONParser().parse(bodyGeneralInformation.toString()));
        for (int i = 1; i < fields.length; i++) {
            if (fields[i].getType().equals(int.class)) {
                fields[i].setInt(newBodyGeneralInformation, Integer.parseInt(jo.get(fields[i].getName()).toString()));

            } else if (fields[i].getType().equals(boolean.class)) {
                fields[i].setBoolean(newBodyGeneralInformation, Boolean.parseBoolean(jo.get(fields[i].getName()).toString()));

            } else if (fields[i].getType().equals(double.class)) {
                fields[i].setDouble(newBodyGeneralInformation, Double.parseDouble(jo.get(fields[i].getName()).toString()));

            } else {
                fields[i].set(newBodyGeneralInformation, jo.get(fields[i].getName()));
            }
        }
    }
}