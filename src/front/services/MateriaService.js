class MateriaService {

    static async resgatarAll() {
        const response = await fetch("http://localhost:8080/materia", {
            method: "GET",
            headers: {
                "Content-Type": "application/json"
            }
        })

        return {
            json: await response.json(),
            status: response.status,
            text: response.statusText
        };
    }

}