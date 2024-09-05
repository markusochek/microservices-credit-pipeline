package com.example.coursework.newAnalysis;

import com.example.coursework.answer.Answer;
import com.example.coursework.authentication.enumerations.Status;
import com.example.coursework.cookies.CookieController;
import com.example.coursework.newAnalysis.entities.bodyGeneralInformation.BodyGeneralInformation;
import com.example.coursework.newAnalysis.entities.bodyLoanConditions.BodyLoanConditions;
import com.example.coursework.newAnalysis.entities.footGeneralInformation.FootGeneralInformation;
import com.example.coursework.newAnalysis.entities.footLoanConditions.FootLoanConditions;
import com.example.coursework.newAnalysis.entities.forCommercialRealEstate.ForCommercialRealEstate;
import com.example.coursework.newAnalysis.entities.headGeneralInformation.HeadGeneralInformation;
import com.example.coursework.newAnalysis.entities.headLoanConditions.HeadLoanConditions;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class NewAnalysisController {
    private final NewAnalysisService newAnalysisService;
    private Answer<Object> answerObject;
    private final CookieController cookieController;

    @PostMapping("newAnalysis")
    public String newAnalysis(@RequestBody String object, HttpServletRequest request)
            throws JsonProcessingException, ParseException, IllegalAccessException {
        if(cookieController.checkToken(request) != null) {
            JSONObject jo = (JSONObject) (new JSONParser().parse(object));
            HeadGeneralInformation headGeneralInformation = new HeadGeneralInformation(jo.get("headGeneralInformation"));
            BodyGeneralInformation bodyGeneralInformation = new BodyGeneralInformation(jo.get("bodyGeneralInformation"));
            HeadLoanConditions headLoanConditions = new HeadLoanConditions(jo.get("headLoanConditions"));
            ForCommercialRealEstate forCommercialRealEstate = new ForCommercialRealEstate(jo.get("forCommercialRealEstate"));
            BodyLoanConditions bodyLoanConditions = new BodyLoanConditions(jo.get("bodyLoanConditions"));
            FootLoanConditions footLoanConditions = new FootLoanConditions(jo.get("footLoanConditions"));
            FootGeneralInformation footGeneralInformation = new FootGeneralInformation(jo.get("footGeneralInformation"));

            return answerObject.json(Status.OK, newAnalysisService.addNewAnalysis(
                    headGeneralInformation,
                    bodyGeneralInformation,
                    headLoanConditions,
                    forCommercialRealEstate,
                    bodyLoanConditions,
                    footLoanConditions,
                    footGeneralInformation
            ));
        }
        return answerObject.json(Status.ERROR);
    }
}
