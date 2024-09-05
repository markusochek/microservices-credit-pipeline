package com.example.coursework.newAnalysis;

import com.example.coursework.newAnalysis.entities.bodyGeneralInformation.BodyGeneralInformation;
import com.example.coursework.newAnalysis.entities.bodyGeneralInformation.BodyGeneralInformationRepository;
import com.example.coursework.newAnalysis.entities.bodyLoanConditions.BodyLoanConditions;
import com.example.coursework.newAnalysis.entities.bodyLoanConditions.BodyLoanConditionsRepository;
import com.example.coursework.newAnalysis.entities.footGeneralInformation.FootGeneralInformation;
import com.example.coursework.newAnalysis.entities.footGeneralInformation.FootGeneralInformationRepository;
import com.example.coursework.newAnalysis.entities.footLoanConditions.FootLoanConditions;
import com.example.coursework.newAnalysis.entities.footLoanConditions.FootLoanConditionsRepository;
import com.example.coursework.newAnalysis.entities.forCommercialRealEstate.ForCommercialRealEstate;
import com.example.coursework.newAnalysis.entities.forCommercialRealEstate.ForCommercialRealEstateRepository;
import com.example.coursework.newAnalysis.entities.headGeneralInformation.HeadGeneralInformation;
import com.example.coursework.newAnalysis.entities.headGeneralInformation.HeadGeneralInformationRepository;
import com.example.coursework.newAnalysis.entities.headLoanConditions.HeadLoanConditions;
import com.example.coursework.newAnalysis.entities.headLoanConditions.HeadLoanConditionsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NewAnalysisService {
    private final HeadGeneralInformationRepository headGeneralInformationRepository;
    private final BodyGeneralInformationRepository bodyGeneralInformationRepository;
    private final HeadLoanConditionsRepository headLoanConditionsRepository;
    private final ForCommercialRealEstateRepository forCommercialRealEstateRepository;
    private final BodyLoanConditionsRepository bodyLoanConditionsRepository;
    private final FootLoanConditionsRepository footLoanConditionsRepository;
    private final FootGeneralInformationRepository footGeneralInformationRepository;

    public Object addNewAnalysis(HeadGeneralInformation headGeneralInformation,
                                 BodyGeneralInformation bodyGeneralInformation,
                                 HeadLoanConditions headLoanConditions,
                                 ForCommercialRealEstate forCommercialRealEstate,
                                 BodyLoanConditions bodyLoanConditions,
                                 FootLoanConditions footLoanConditions,
                                 FootGeneralInformation footGeneralInformation) {
        headGeneralInformationRepository.save(headGeneralInformation);
        bodyGeneralInformationRepository.save(bodyGeneralInformation);
        headLoanConditionsRepository.save(headLoanConditions);
        forCommercialRealEstateRepository.save(forCommercialRealEstate);
        bodyLoanConditionsRepository.save(bodyLoanConditions);
        footLoanConditionsRepository.save(footLoanConditions);
        footGeneralInformationRepository.save(footGeneralInformation);
        return true;
    }
}
