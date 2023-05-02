class OcorrenciaService {
    static async cadastrar() {
        let ocorrencia = new OcorrenciaController().createAsJson();
        let response = await fetch("http://localhost:8080/ocorrencia/registrar", {
            method: "POST",
            body: ocorrencia,
            headers: {
                'Content-Type': 'application/json'
            }
        })

        return {
            json: await response.json(),
            status: response.status,
            text: response.statusText
        };
    }
}