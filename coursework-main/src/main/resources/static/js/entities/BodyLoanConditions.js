import {FullName} from "./FullName.js";

export class BodyLoanConditions {
    repaymentPeriod;
    guarantee;
    fullNameOfGuarantor;
    additionalSupport;

    isRealEstateInsurance;
    isLifeInsurance;
    constructor(repaymentPeriod, guarantee, fullNameOfGuarantor, additionalSupport, isRealEstateInsurance, isLifeInsurance) {
        this.repaymentPeriod = repaymentPeriod || null;
        this.guarantee = guarantee || false;
        this.fullNameOfGuarantor = fullNameOfGuarantor || new FullName();
        this.additionalSupport = additionalSupport || null;
        this.isRealEstateInsurance = isRealEstateInsurance || false;
        this.isLifeInsurance = isLifeInsurance || false;
    }

    getLabels() {
        return ["Период погашения", "Гарантия", "ФИО поручителя",
                "Дополнительное обеспечение", "Страхование недвижимости", "Страхование жизни"];
    }
}