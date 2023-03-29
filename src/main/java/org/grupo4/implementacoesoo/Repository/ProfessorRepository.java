package org.grupo4.implementacoesoo.Repository;

import org.grupo4.implementacoesoo.AdicionarAtualizarUsuario.AdicionarDTO;
import org.grupo4.implementacoesoo.AdicionarAtualizarUsuario.AdicionarProfessorDTO;
import org.grupo4.implementacoesoo.Domain.*;
import org.grupo4.implementacoesoo.LoginUser.LoginDTO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class ProfessorRepository implements UserRepository {
    @Override
    public Professor getInfo(String cpf) {

        Professor professor = new Professor();

        try {
            FileReader fileReader = new FileReader("professores/" + cpf + ".json");

            try {
                Object professorObject = new JSONParser().parse(fileReader);

                JSONObject professorObjectJSON = (JSONObject) professorObject;

                professor.setNome((String) professorObjectJSON.get("nome"));
                professor.setCpf((String) professorObjectJSON.get("cpf"));
                professor.setDataNasc((String) professorObjectJSON.get("dataNasc"));
                professor.setPayDay((Long) professorObjectJSON.get("dataPagamento"));
                professor.setSalarioHora((Double) professorObjectJSON.get("salarioHora"));
                professor.setCargaHoraria((Long) professorObjectJSON.get("cargaHoraria"));
                JSONArray professorTurmasArray = (JSONArray) professorObjectJSON.get("turmas");

                for (Object tur : professorTurmasArray) {
                    JSONObject turmaJSON = (JSONObject) tur;
                    Turma turma = new Turma((String) turmaJSON.get("nome"));
                    professor.addTurma(turma);
                }

            } catch (final ParseException e) {
                System.out.println("Não foi possível ler os dados do professor.");
            }

        } catch (final IOException e) {
            System.out.println("Não existe professor com esse número de matrícula!");
        }

        return professor;
    }
    @Override
    public boolean saveInfo(User user) {
        Professor professor = (Professor) user;
        JSONObject professorJSONObject = new JSONObject();

        boolean results = true;

        professorJSONObject.put("nome", professor.getNome());
        professorJSONObject.put("dataNasc", professor.getDataNasc());
        professorJSONObject.put("cpf", professor.getCpf());
        professorJSONObject.put("dataPagamento", professor.getPayDay());
        professorJSONObject.put("salarioHora", professor.getSalarioHora());
        professorJSONObject.put("cargaHoraria", professor.getCargaHoraria());
        professorJSONObject.put("turmas", professor.getTurmasAsJSON());

        try {
            PrintWriter pw = new PrintWriter("professores/" + professor.getCpf() + ".json");
            pw.write(professorJSONObject.toJSONString());
            pw.flush();
            pw.close();
        } catch (IOException e) {
            results = false;
            System.out.println("Não foi possível salvar os dados do professor.");
        }

        return results;

    }

    @Override
    public boolean saveCredentials(AdicionarDTO adicionarDTO) {
        AdicionarProfessorDTO adicionarProfessorDTO = (AdicionarProfessorDTO) adicionarDTO;
        JSONObject professorJSONObject = new JSONObject();
        professorJSONObject.put("id", adicionarProfessorDTO.getCpf());
        professorJSONObject.put("senha", adicionarProfessorDTO.getSenha());

        boolean result = true;

        try {
            FileReader fileReader = new FileReader("archives/professores.json");
            try {
                Object professorObject = new JSONParser().parse(fileReader);
                JSONArray professorObjectJSON = (JSONArray) professorObject;

                JSONArray jsonArray = new JSONArray();
                for (Object o : professorObjectJSON) {
                    JSONObject jo = (JSONObject) o;
                    jsonArray.add(jo);
                }

                jsonArray.add(professorJSONObject);


                try {
                    PrintWriter pw = new PrintWriter("archives/professores.json");
                    pw.write(jsonArray.toJSONString());
                    pw.flush();
                    pw.close();
                } catch (IOException e) {
                    System.out.println("Não foi possível salvar as credenciais do professor.");
                    result = false;
                }


            } catch (ParseException e) {
                System.out.println("Não foi possível acessar as credenciais do professor.");
                System.out.println(e.getMessage());
                System.out.println(e.getClass());
                result = false;
            }
        } catch (IOException e) {
            System.out.println("Não foi possível acessar as credenciais de professor.");
            result = false;
        }



        return result;


    }

    @Override
    public LoginDTO getCredentials(String id) {

        LoginDTO loginObject = new LoginDTO();

        try {
            FileReader fileReader = new FileReader("archives/professores.json");

            try {
                Object alunosObject = new JSONParser().parse(fileReader);
                JSONArray professores = (JSONArray) alunosObject;

                loginObject.setSenha("false");
                loginObject.setId("false");

                for (Object alunoObject : professores) {
                    JSONObject professor = (JSONObject) alunoObject;
                    String professorJSONId = (String) professor.get("id");

                    if (professorJSONId.equals(id)) {
                        loginObject.setId((String) professor.get("id"));
                        loginObject.setSenha((String) professor.get("senha"));
                        break;
                    }

                }

            } catch (final ParseException e) {
                System.out.println("Não foi possível ler os dados do professor.");
            }


        } catch (final IOException e) {
            System.out.println("Não existe professor com esse identificador");
        }

        return loginObject;
    }
}
