import {ConstructorDisplay} from "../ConstructorDisplay.js";
import {User} from "./entities/User.js";
import {Server} from "../Server.js";
import {Client} from "../client/Client.js";
import {Status} from "../client/enumerations/Status.js";

export class AuthorizationDisplay {
    static numberOfColumns = ConstructorDisplay.NUMBERS_OF_COLUMNS;
    static numberOfRows = ConstructorDisplay.NUMBERS_OF_ROWS;

    static user;

    static {
        AuthorizationDisplay.user = new User();
    }

    static page = () => {
        ConstructorDisplay.pageHTML.innerHTML = null;
        ConstructorDisplay.setColumnsRows(AuthorizationDisplay.numberOfColumns, AuthorizationDisplay.numberOfRows)

        ConstructorDisplay.showObject(AuthorizationDisplay.user);

        ConstructorDisplay.showButton("Авторизоваться", AuthorizationDisplay.request, 1);
    }


    static request = () => {
        let object = ConstructorDisplay.wrapObjects({user: AuthorizationDisplay.user})
        object.user.name = object.user.login;
        object.user.token = "";

        Server.POST('authorization', object.user)

            .then((response) => {
                switch (response.status) {
                    case Status.OK:
                        Server.POST('setCookie',
                            {name: "token", value: response.data[0]})
                            .then(() => Client.page())
                        break;
                    case Status.ERROR:
                        console.log('authorization error');
                        break;
                }
            })
    }
}