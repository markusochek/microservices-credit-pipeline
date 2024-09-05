import {Client} from "./client/Client.js";
import {AuthenticationDisplay} from "./authentication/AuthenticationDisplay.js";
import {AuthorizationDisplay} from "./authentication/AuthorizationDisplay.js";
import {RegistrationDisplay} from "./authentication/RegistrationDisplay.js";
import {Status} from "./client/enumerations/Status.js";
import {Server} from "./Server.js";

export class Index {
    static {
        AuthorizationDisplay.numberOfColumns = 12;
        AuthorizationDisplay.numberOfRows = 6;

        RegistrationDisplay.numberOfColumns = 12;
        RegistrationDisplay.numberOfRows = 6;

        AuthenticationDisplay.numberOfColumns = 12;
        AuthenticationDisplay.numberOfRows = 6;

        Client.numberOfColumns = 36;
        Client.numberOfRows = 12;
    }

     static page = () => {
        Server.POST(
            'checkCookie',
            {name: "token"})
            .then(response => {
                switch (response.status) {
                    case Status.OK:
                        Client.page();
                        break;
                    case Status.ERROR:
                        AuthenticationDisplay.page();
                        break;
                }
            })
     }
}

Index.page()
