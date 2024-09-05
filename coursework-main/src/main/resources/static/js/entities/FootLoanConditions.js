export class FootLoanConditions {
    isDoubleBid;

    basicPercentage;
    percentageIncludingInsurance;
    maximumPayment;
    averageEPOnRequest;
    EPIncludingInsurance;

    constructor(isDoubleBid, basicPercentage, percentageIncludingInsurance,
                maximumPayment, averageEPOnRequest, EPIncludingInsurance) {
        this.isDoubleBid = isDoubleBid || false;
        this.basicPercentage = basicPercentage || 0;
        this.percentageIncludingInsurance = percentageIncludingInsurance || 0;
        this.maximumPayment = maximumPayment || 0;
        this.averageEPOnRequest = averageEPOnRequest || 0;
        this.EPIncludingInsurance = EPIncludingInsurance || 0;
    }

    getLabels() {
        return ["Двойная ставка", "Основной процент", "Процент с учетом страховки",
            "Максимальный платеж", "Средний ЕП по заявке", "ЕП с учетом страховки"];
    }
}