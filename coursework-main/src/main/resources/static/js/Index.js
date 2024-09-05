import {Server} from "./Server.js";
import {AuthorizationDisplay} from "./authentication/AuthorizationDisplay.js";
import {RegistrationDisplay} from "./authentication/RegistrationDisplay.js";
import {AuthenticationDisplay} from "./authentication/AuthenticationDisplay.js";
import {NewAnalysis} from "./newAnalysis/NewAnalysis.js";
import {Status} from "./enumerations/Status.js";

export class Index {
    static {
        AuthorizationDisplay.numberOfColumns = 36;
        AuthorizationDisplay.numberOfRows = 6;

        RegistrationDisplay.numberOfColumns = 36;
        RegistrationDisplay.numberOfRows = 6;

        AuthenticationDisplay.numberOfColumns = 36;
        AuthenticationDisplay.numberOfRows = 6;

        NewAnalysis.numberOfColumns = 36;
        NewAnalysis.numberOfRows = 18;
    }

    static page = () => {
        Server.POST(
            'checkCookie',
            {name: "token"})
            .then(response => {
                switch (response.status) {
                    case Status.OK:
                        NewAnalysis.page();
                        break;
                    case Status.ERROR:
                        AuthenticationDisplay.page();
                        break;
                }
            })
    }
}

Index.page()
