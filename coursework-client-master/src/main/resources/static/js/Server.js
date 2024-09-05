export class Server {

    static async POST(path, object) {
        let request = await fetch(`api/${path}`,
            {method: "POST",
            headers: {'Content-Type': 'application/json;charset=utf-8'},
            body: JSON.stringify(object)
        });
        return await request.json();
    }

    static async GET(path) {
        let request = await fetch(`api/${path}`);
        return await request.json();
    }
}