"use strict";

import {HeadGeneralInformation} from "../entities/HeadGeneralInformation.js";
import {BodyGeneralInformation} from "../entities/BodyGeneralInformation.js";
import {HeadLoanConditions} from "../entities/HeadLoanConditions.js";
import {FootGeneralInformation} from "../entities/FootGeneralInformation.js";

import {ConstructorDisplay} from "../ConstructorDisplay.js";
import {Server} from "../Server.js";
import {Status} from "../enumerations/Status.js";
import {AuthenticationDisplay} from "../authentication/AuthenticationDisplay.js";
import {BodyLoanConditions} from "../entities/BodyLoanConditions.js";
import {FootLoanConditions} from "../entities/FootLoanConditions.js";
import {ForCommercialRealEstate} from "../entities/ForCommercialRealEstate.js";

export class NewAnalysis {
    static numberOfColumns = ConstructorDisplay.NUMBERS_OF_COLUMNS;
    static numberOfRows = ConstructorDisplay.NUMBERS_OF_ROWS;

    static headGeneralInformation;
    static bodyGeneralInformation;
    static headLoanConditions;
    static forCommercialRealEstate;
    static bodyLoanConditions;
    static footLoanConditions;
    static footGeneralInformation;

    static page = () =>  {
        ConstructorDisplay.pageHTML.innerHTML = null;
        ConstructorDisplay.setColumnsRows(NewAnalysis.numberOfColumns, NewAnalysis.numberOfRows)

        ConstructorDisplay.showButton("Выйти", NewAnalysis.requestExit, 1);

        NewAnalysis.showHeadGeneralInformation();
        NewAnalysis.showBodyGeneralInformation();
        NewAnalysis.showHeadLoanConditions();
        NewAnalysis.showForCommercialRealEstate();
        NewAnalysis.showBodyLoanConditions();
        NewAnalysis.showFootLoanConditions();
        NewAnalysis.showFootGeneralInformation();

        ConstructorDisplay.showButton("Проверить на комитет", NewAnalysis.request, 1);
    }

    static showHeadGeneralInformation() {
        NewAnalysis.headGeneralInformation = new HeadGeneralInformation();
        ConstructorDisplay.showObject(NewAnalysis.headGeneralInformation);
    }

    static showBodyGeneralInformation() {
        NewAnalysis.bodyGeneralInformation = new BodyGeneralInformation();
        ConstructorDisplay.showObject(NewAnalysis.bodyGeneralInformation);
    }

    static showHeadLoanConditions() {
        NewAnalysis.headLoanConditions = new HeadLoanConditions();
        NewAnalysis.headLoanConditions.span = () => {return 2};
        ConstructorDisplay.showObject(NewAnalysis.headLoanConditions);
    }

    static showForCommercialRealEstate() {
        NewAnalysis.forCommercialRealEstate = new ForCommercialRealEstate();
        ConstructorDisplay.showObject(NewAnalysis.forCommercialRealEstate);
    }

    static showBodyLoanConditions() {
        NewAnalysis.bodyLoanConditions = new BodyLoanConditions();
        NewAnalysis.bodyLoanConditions.span = () => {return 3};
        ConstructorDisplay.showObject(NewAnalysis.bodyLoanConditions);
    }

    static showFootLoanConditions() {
        NewAnalysis.footLoanConditions = new FootLoanConditions();
        NewAnalysis.footLoanConditions.span = () => {return 2};
        ConstructorDisplay.showObject(NewAnalysis.footLoanConditions);
    }

    static showFootGeneralInformation() {
        NewAnalysis.footGeneralInformation = new FootGeneralInformation();
        ConstructorDisplay.showObject(NewAnalysis.footGeneralInformation);
    }

    static requestExit() {
        Server.POST('unsetCookie', {name: 'token'}).then(
            response => {
                switch (response.status) {
                    case Status.OK:
                        AuthenticationDisplay.page();
                        break;
                    case Status.ERROR:
                        console.log('unsetCookie error');
                        break;
                }
            }
        )
    }

    static request = () => {
        let object = ConstructorDisplay.wrapObjects({
            headGeneralInformation: NewAnalysis.headGeneralInformation,
            bodyGeneralInformation: NewAnalysis.bodyGeneralInformation,
            headLoanConditions: NewAnalysis.headLoanConditions,
            forCommercialRealEstate: NewAnalysis.forCommercialRealEstate,
            bodyLoanConditions: NewAnalysis.bodyLoanConditions,
            footLoanConditions: NewAnalysis.footLoanConditions,
            footGeneralInformation: NewAnalysis.footGeneralInformation
        })

        Server.POST('newAnalysis', object)
            .then(response => {
                switch (response.status) {
                    case Status.OK:
                        ConstructorDisplay.pageHTML.innerHTML = null;
                        let object = {
                            committee: "НЕТ",
                            getLabels() {return ["Проверка на комитет"]},
                            span: () => {
                                return 1;
                            }
                        }
                        ConstructorDisplay.showObject(object);
                        break;
                    case Status.ERROR:
                        console.log('newAnalysis error');
                        break;
                }
            })
    }
}