import {FullName} from "./FullName.js";

export class Borrower {
	fullName;
	
	dateOfBirth;
	isSalaryProject;
	dependents;
	income;
	
	confirmation;

	isDelayOfMoreThanDays;
	isBankrupt;
	scoring;

	constructor(fullName, dateOfBirth, isSalaryProject, dependents, income, confirmation, isDelayOfMoreThanDays, isBankrupt, scoring) {
		this.fullName = fullName || new FullName();
		this.dateOfBirth = dateOfBirth || new Date();
		this.isSalaryProject = isSalaryProject || false;
		this.dependents = dependents || 0;
		this.income = income || 0;
		this.confirmation = confirmation || null;
		this.isDelayOfMoreThanDays = isDelayOfMoreThanDays || false;
		this.isBankrupt = isBankrupt || false;
		this.scoring = scoring || 0;
	}


	getLabels() {
		return ["ФИО", "Дата рождения", "ЗП проект", "Иждивенцы", "Доход", "Подтверждение","Просрочка >20д", "Банкрот", "Скоринг"];
	}

	toString() {
		return this.fullName.toString();
	};
}
