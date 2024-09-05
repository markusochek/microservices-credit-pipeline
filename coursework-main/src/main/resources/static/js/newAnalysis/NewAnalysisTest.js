// import {HeadGeneralInformation} from "../entities/HeadGeneralInformation.java";
// import {AnalysisStatus} from "../enumerations/AnalysisStatus.js";
// import {View} from "../enumerations/View.js";
// import {BodyGeneralInformation} from "../entities/BodyGeneralInformation.java";
// import {LoanProgram} from "../enumerations/LoanProgram.js";
// import {Region} from "../enumerations/Region.js";
// import {Borrower} from "../entities/Borrower.js";
// import {FullName} from "../entities/FullName.js";
// import {Confirmation} from "../enumerations/Confirmation.js";
// import {BorrowersIncome} from "../entities/BorrowersIncome.js";
// import {HeadLoanConditions} from "../entities/HeadLoanConditions.java";
// import {TypeOfRepayment} from "../enumerations/TypeOfRepayment.js";
// import {Postponement} from "../enumerations/Postponement.js";
// import {RepaymentPeriod} from "../enumerations/RepaymentPeriod.js";
// import {AdditionalSupport} from "../enumerations/AdditionalSupport.js";
// import {Enumerations} from "../enumerations/Enumerations.js";
// import {jsDatepicker} from "./jsDatepicker.js";
//
// export class NewAnalysisTest {
//
//     showHeadGeneralInformation() {
//         let headGeneralInformation = new HeadGeneralInformation(
//             new Date(2022, 8, 2),
//             AnalysisStatus.DECORATION,
//             View.CREDIT_CONSUMER_COOPERATIVE,);
//
//         // let headGeneralInformation = new HeadGeneralInformation();
//         this.showObject(headGeneralInformation);
//     }
//
//     showBodyGeneralInformation() {
//         let bodyGeneralInformation = new BodyGeneralInformation(
//             LoanProgram.MORTGAGE_6_MONTHS,
//             new Date(2023, 3, 28),
//             Region.UDMURT_REPUBLIC,
//             false);
//
//         // let bodyGeneralInformation = new BodyGeneralInformation();
//         this.showObject(bodyGeneralInformation);
//     }
//
//     showBorrowers() {
//         let borrower = new Borrower(
//             new FullName("Алокова", "Шамкыз", "Зейтуновна"),
//             new Date(1995, 2, 2),
//             28,
//             false,
//             3,
//             70000,
//             Confirmation.QUESTIONNAIRE,
//             false,
//             false,
//             1111);
//         let coBorrower = new Borrower(
//             new FullName("Алоков", " Альбек", "Русланович"),
//             new Date(1994, 10, 27),
//             28,
//             false,
//             2,
//             50000,
//             Confirmation.QUESTIONNAIRE,
//             false,
//             false,
//             1111);
//
//         // let borrower = new Borrower();
//         // let coBorrower = new Borrower();
//         this.showObject(borrower);
//         this.showObject(coBorrower);
//     }
//
//     showBorrowersIncome() {
//         let borrowersIncome = new BorrowersIncome(
//             1111,
//             1111,
//             false);
//
//         // let borrowersIncome = new BorrowersIncome();
//         this.showObject(borrowersIncome);
//     }
//
//     showFootGeneralInformation() {
//         let footGeneralInformation = new FootGeneralInformation(
//             new FullName("Сагалаев", " Эдуард", " Николаевич"),
//             true);
//
//         // let footGeneralInformation = new FootGeneralInformation();
//         this.showObject(footGeneralInformation);
//     }
//
//     showLoanConditions() {
//         let loanConditions = new HeadLoanConditions(
//             500000,
//             0.4825,
//             TypeOfRepayment.DIFFERENTIATED_PAYMENT,
//             Postponement._12_MONTHS,
//             100000,
//             450000,
//             258741,
//             6,
//             RepaymentPeriod.AT_END_OF_THE_TERM,
//             new Guarantee(false, null),
//             AdditionalSupport.DEPOSIT,
//             false,
//             false,
//             false,
//             1111,
//             1111,
//             1111,
//             1111,
//             1111
//         );
//
//         // let loanConditions = new HeadLoanConditions();
//         this.showObject(loanConditions);
//     }
//
//     showObject(object) {
//         for (const objectKey in object) {
//             let div = document.createElement("div");
//             div.className = `box`;
//             div.style.gridColumn = `span ${12 / Object.keys(object).length}`;
//             console.log(`span ${12 / Object.keys(object).length}`);
//             this.pageHTML.append(div);
//
//             let label = document.createElement("label");
//             label.innerHTML = objectKey;
//             div.append(label);
//
//             let enumeration = Enumerations.getEnumeration(objectKey);
//             if (enumeration) {
//                 Enumerations.showEnumeration(div, enumeration);
//             } else if (typeof object[objectKey] === "boolean") {
//                 let select = document.createElement("select");
//
//                 let option = document.createElement("option");
//                 option.value = "false";
//                 option.textContent = "Нет";
//                 select.append(option);
//
//                 option = document.createElement("option");
//                 option.value = "true";
//                 option.textContent = "Да";
//                 select.append(option);
//
//                 div.append(select);
//
//             } else {
//                 let input = document.createElement("input");
//                 input.placeholder = object;
//                 input.value = object[objectKey];
//                 div.append(input);
//
//                 if (objectKey === "version" || objectKey === "date" || objectKey === "dateOfBirth") {
//                     jsDatepicker(input);
//                     input.value = object[objectKey].toLocaleDateString();
//                 }
//             }
//         }
//     }
// }