"use strict";

import {BorrowersIncome} from "./entities/BorrowersIncome.js";
import {Borrower} from "./entities/Borrower.js";
import {ConstructorDisplay} from "../ConstructorDisplay.js";
import {Server} from "../Server.js";
import {Status} from "./enumerations/Status.js";
import {AuthenticationDisplay} from "../authentication/AuthenticationDisplay.js";


export class Client {
    static numberOfColumns = ConstructorDisplay.NUMBERS_OF_COLUMNS;
    static numberOfRows = ConstructorDisplay.NUMBERS_OF_ROWS;

    static borrower;
    static coBorrower;
    static borrowersIncome;

    static page = () => {
        ConstructorDisplay.pageHTML.innerHTML = null;
        ConstructorDisplay.setColumnsRows(Client.numberOfColumns, Client.numberOfRows)

        ConstructorDisplay.showButton("Выйти", Client.requestExit, 1);

        Client.showBorrowers();
        Client.showBorrowersIncome();

        ConstructorDisplay.showButton("Добавить", Client.request, 1);
    }
    static requestExit() {
        Server.POST('unsetCookie', {name: 'token'}).then(
            response => {
                switch (response.status) {
                    case Status.OK:
                        AuthenticationDisplay.page();
                        break;
                    case Status.ERROR:
                        console.log('unsetCookie error');
                        break;
                }
            }
        )
    }

    static showBorrowers() {
        Client.borrower = new Borrower();
        Client.coBorrower = new Borrower();
        let object = {}
        let counter = 0
        let labels = []
        for (let keyElement in Client.borrower) {
            labels.push(Client.borrower.getLabels()[counter])
            labels.push(Client.borrower.getLabels()[counter])
            object[keyElement + "1"] = Client.borrower[keyElement]
            object[keyElement + "2"] = Client.coBorrower[keyElement]
            ++counter
        }
        object.getLabels = () => {return labels}
        object.span = () => {return 2};
        ConstructorDisplay.showObject(object);
    }

    static showBorrowersIncome() {
        Client.borrowersIncome = new BorrowersIncome();
        ConstructorDisplay.showObject(Client.borrowersIncome);
    }

    static request = () => {
        let borrowers = {}
        let counter = 0
        for (let keyElement in Client.borrower) {
            borrowers[keyElement + "1"] = Client.borrower[keyElement]
            borrowers[keyElement + "2"] = Client.coBorrower[keyElement]
            ++counter
        }

        let object = ConstructorDisplay.wrapObjects({borrowers: borrowers, borrowersIncome: Client.borrowersIncome});
        let borrower = {}
        let coBorrower = {}
        let i = 0;
        for (const objectKey in object.borrowers) {
            let purifiedObjectKey = objectKey.replace(/[0-9]/g, '')
            if (i % 2 === 0) {
                borrower[purifiedObjectKey] = object.borrowers[objectKey];
            } else {
                coBorrower[purifiedObjectKey] = object.borrowers[objectKey];
            }
            i++;
        }

        object = {borrower: borrower, coBorrower: coBorrower, borrowersIncome: object.borrowersIncome}
        Server.POST('client', object)
                .then(response => {
                    switch (response.status) {
                        case Status.OK:
                            console.log('YESSSSSSSSSSS');
                            break;
                        case Status.ERROR:
                            console.log('client error');
                            break;
                    }
                })
    }
}