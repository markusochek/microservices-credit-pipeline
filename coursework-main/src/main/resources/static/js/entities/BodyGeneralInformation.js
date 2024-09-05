export class BodyGeneralInformation {
    loanProgram
    date
    region
    isSpecialProgramForMedicalWorkers

    constructor(loanProgram, date, region, isSpecialProgramForMedicalWorkers) {
        this.loanProgram = loanProgram || null;
        this.date = date || new Date();
        this.region = region || null;
        this.isSpecialProgramForMedicalWorkers = isSpecialProgramForMedicalWorkers || false;
    }

    getLabels() {
        return ["Программа кредитования", "Дата", "Регион", "Специальная медицинская программа"];
    }
}