import {Confirmation} from "./Confirmation.js";
import {Status} from "./Status.js";
import {VerificationResult} from "./VerificationResult.js";

export class Enumerations {
    confirmation;
    status;
    verificationResult;


    constructor() {
        this.confirmation = Confirmation;
        this.status = Status;
        this.verificationResult = VerificationResult;
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
