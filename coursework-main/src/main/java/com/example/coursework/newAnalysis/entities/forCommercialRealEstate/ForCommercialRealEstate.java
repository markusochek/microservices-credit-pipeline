package com.example.coursework.newAnalysis.entities.forCommercialRealEstate;

import com.example.coursework.newAnalysis.entities.headLoanConditions.HeadLoanConditions;
import com.example.coursework.newAnalysis.enumerations.Postponement;
import com.example.coursework.newAnalysis.enumerations.TypeOfRepayment;
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
public class ForCommercialRealEstate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String typeOfRepayment;
    @Column
    private String postponement;
    public ForCommercialRealEstate(Object forCommercialRealEstate) throws ParseException, IllegalAccessException {
        ForCommercialRealEstate newForCommercialRealEstate = this;
        Field[] fields = newForCommercialRealEstate.getClass().getDeclaredFields();
        JSONObject jo = (JSONObject)(new JSONParser().parse(forCommercialRealEstate.toString()));
        for (int i = 1; i < fields.length; i++) {
            if (fields[i].getType().equals(int.class)) {
                fields[i].setInt(newForCommercialRealEstate, Integer.parseInt(jo.get(fields[i].getName()).toString()));

            } else if (fields[i].getType().equals(boolean.class)) {
                fields[i].setBoolean(newForCommercialRealEstate, Boolean.parseBoolean(jo.get(fields[i].getName()).toString()));

            } else if (fields[i].getType().equals(double.class)) {
                fields[i].setDouble(newForCommercialRealEstate, Double.parseDouble(jo.get(fields[i].getName()).toString()));

            } else {
                fields[i].set(newForCommercialRealEstate, jo.get(fields[i].getName()));
            }
        }
    }
}