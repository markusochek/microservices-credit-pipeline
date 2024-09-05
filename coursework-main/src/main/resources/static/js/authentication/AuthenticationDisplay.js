import {ConstructorDisplay} from "../ConstructorDisplay.js";
import {AuthorizationDisplay} from "./AuthorizationDisplay.js";
import {RegistrationDisplay} from "./RegistrationDisplay.js";

export class AuthenticationDisplay {
    static numberOfColumns = ConstructorDisplay.NUMBERS_OF_COLUMNS;
    static numberOfRows = ConstructorDisplay.NUMBERS_OF_ROWS;

    static page = () => {
        ConstructorDisplay.pageHTML.innerHTML = null;
        ConstructorDisplay.setColumnsRows(AuthenticationDisplay.numberOfColumns, AuthenticationDisplay.numberOfRows)

        let buttonNames = ["Авторизация", "Регистрация"]
        let buttonFunctions = [AuthorizationDisplay.page, RegistrationDisplay.page]

        for(let i = 0; i < buttonNames.length; i++) {
            ConstructorDisplay.showButton(buttonNames[i], buttonFunctions[i], 1);
        }
    }
}