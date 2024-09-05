import {ConstructorDisplay} from "../ConstructorDisplay.js";
import {User} from "./entities/User.js";
import {Server} from "../Server.js";
import {AuthorizationDisplay} from "./AuthorizationDisplay.js";
import {Status} from "../enumerations/Status.js";


export class RegistrationDisplay {
    static numberOfColumns = ConstructorDisplay.NUMBERS_OF_COLUMNS;
    static numberOfRows = ConstructorDisplay.NUMBERS_OF_ROWS;

    static user;

    static {
        RegistrationDisplay.user = new User();
    }



    static page = () => {
        ConstructorDisplay.pageHTML.innerHTML = null;
        ConstructorDisplay.setColumnsRows(RegistrationDisplay.numberOfColumns, RegistrationDisplay.numberOfRows)

        ConstructorDisplay.showObject(RegistrationDisplay.user);

        ConstructorDisplay.showButton("Зарегистрироваться", RegistrationDisplay.request, 1);
    }

    static request = () => {
        let object = ConstructorDisplay.wrapObjects({user: RegistrationDisplay.user})
        object.user.name = object.user.login;
        object.user.token = "";

        Server.POST('registration', object.user)
            .then(response => {
                switch (response.status) {
                    case Status.OK:
                        AuthorizationDisplay.page()
                        break;
                    case Status.ERROR:
                        console.log('registration error');
                        break;
                }
            })
    }
}