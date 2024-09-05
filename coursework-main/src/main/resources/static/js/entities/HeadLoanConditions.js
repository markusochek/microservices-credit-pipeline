export class HeadLoanConditions {
    costOfHousing;
    PV;

    minLoanAmount;
    maxLoanAmount;
    loanAmount;
    term;
    constructor(costOfHousing, PV, minLoanAmount, maxLoanAmount, loanAmount, term) {
        this.costOfHousing = costOfHousing || 0;
        this.PV = PV || 0;
        this.minLoanAmount = minLoanAmount || 0;
        this.maxLoanAmount = maxLoanAmount || 0;
        this.loanAmount = loanAmount || 0;
        this.term = term || 0;
    }

    getLabels() {
        return ["Стоимость жилья(объекта)", "ПВ", "Минимальная сумма кредита",
                "максимальная сумма кредита", "сумма кредита", "Срок"];
    }
}
