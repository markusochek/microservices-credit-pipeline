export class FullName {
    lastName;
    firstName;
    patronymic;

    constructor(lastName, firstName, patronymic) {
        this.lastName = lastName || "";
        this.firstName = firstName || "";
        this.patronymic = patronymic || "";
    }

    toString() {
        return `${this.lastName} ${this.firstName} ${this.patronymic}`;
    }

}
