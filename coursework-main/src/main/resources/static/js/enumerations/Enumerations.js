import {AdditionalSupport} from "./AdditionalSupport.js";
import {AnalysisStatus} from "./AnalysisStatus.js";
import {LoanProgram} from "./LoanProgram.js";
import {Postponement} from "./Postponement.js";
import {Region} from "./Region.js";
import {RepaymentPeriod} from "./RepaymentPeriod.js";
import {Status} from "./Status.js";
import {TypeOfRepayment} from "./TypeOfRepayment.js";
import {View} from "./View.js";

export class Enumerations {
    additionalSupport;
    analysisStatus;
    loanProgram;
    postponement;
    region;
    repaymentPeriod;
    status;
    typeOfRepayment;
    view;


    constructor() {
        this.additionalSupport = AdditionalSupport;
        this.analysisStatus = AnalysisStatus;
        this.loanProgram = LoanProgram;
        this.postponement = Postponement;
        this.region = Region;
        this.repaymentPeriod = RepaymentPeriod;
        this.status = Status;
        this.typeOfRepayment = TypeOfRepayment;
        this.view = View;
    }

    static getEnumeration(objectKey) {
        let enumerations = new Enumerations();
        for (const enumerationKey in enumerations) {
            if (objectKey === enumerationKey) {
                return enumerations[enumerationKey];
            }
        }
        return null;
    }

    static showEnumeration(div, enumeration) {
        let select = document.createElement("select");

        for (const enumerationKey in enumeration) {
            let option = document.createElement("option");
            option.value = enumeration[enumerationKey];
            option.textContent = enumeration[enumerationKey];
            select.append(option);
        }
        div.append(select);
    }

    static getKeyByValue(object, value) {
        return Object.keys(object).find(key => object[key] === value);
    }
}
