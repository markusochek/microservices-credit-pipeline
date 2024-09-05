export class User {
    login
    password

    constructor(login, password) {
        this.login = login || "";
        this.password = password || "";
    }

    getLabels() {
        return ["Логин", "Пароль"]
    }

    span = () => {
        return 1;
    }
}