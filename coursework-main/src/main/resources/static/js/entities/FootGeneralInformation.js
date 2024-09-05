import {FullName} from "./FullName.js";

export class FootGeneralInformation {
    executor
    // committee

    constructor(executor) {
        this.executor = executor || new FullName();
        // this.committee = committee || false;
    }

    getLabels() {
        return ["Исполнитель"]// , "Проверка на комитет"];
    }
}