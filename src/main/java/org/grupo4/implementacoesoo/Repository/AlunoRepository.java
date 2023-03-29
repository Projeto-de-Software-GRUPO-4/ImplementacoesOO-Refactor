package org.grupo4.implementacoesoo.Repository;

import org.grupo4.implementacoesoo.AdicionarAtualizarUsuario.AdicionarAlunoDTO;
import org.grupo4.implementacoesoo.AdicionarAtualizarUsuario.AdicionarDTO;
import org.grupo4.implementacoesoo.AdicionarAtualizarUsuario.AdicionarProfessorDTO;
import org.grupo4.implementacoesoo.Domain.Aluno;
import org.grupo4.implementacoesoo.Domain.Responsavel;
import org.grupo4.implementacoesoo.Domain.User;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.grupo4.implementacoesoo.LoginUser.LoginDTO;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class AlunoRepository implements UserRepository {


    @Override
    public boolean saveCredentials(AdicionarDTO adicionarDTO) {
        AdicionarAlunoDTO adicionarAlunoDTO = (AdicionarAlunoDTO) adicionarDTO;
        JSONObject professorJSONObject = new JSONObject();
        professorJSONObject.put("id", adicionarAlunoDTO.getCpf());
        professorJSONObject.put("senha", adicionarAlunoDTO.getSenha());

        boolean result = true;

        try {
            FileReader fileReader = new FileReader("archives/alunos.json");
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
                    PrintWriter pw = new PrintWriter("archives/alunos.json");
                    pw.write(jsonArray.toJSONString());
                    pw.flush();
                    pw.close();
                } catch (IOException e) {
                    System.out.println("Não foi possível salvar as credenciais do aluno.");
                    result = false;
                }


            } catch (ParseException e) {
                System.out.println("Não foi possível acessar as credenciais do aluno.");
                System.out.println(e.getMessage());
                System.out.println(e.getClass());
                result = false;
            }
        } catch (IOException e) {
            System.out.println("Não foi possível acessar as credenciais de aluno.");
            result = false;
        }



        return result;


    }

    @Override
    public LoginDTO getCredentials(String id) {

        LoginDTO loginObject = new LoginDTO();

        try {
            FileReader fileReader = new FileReader("archives/alunos.json");

            try {
                Object alunosObject = new JSONParser().parse(fileReader);
                JSONArray alunos = (JSONArray) alunosObject;

                loginObject.setSenha("false");
                loginObject.setId("false");

                for (Object alunoObject : alunos) {
                    JSONObject aluno = (JSONObject) alunoObject;
                    String alunoJSONId = (String) aluno.get("id");

                    if (alunoJSONId.equals(id)) {
                        loginObject.setId((String) aluno.get("id"));
                        loginObject.setSenha((String) aluno.get("senha"));
                        break;
                    }

                }

            } catch (final ParseException e) {
                System.out.println("Não foi possível ler os dados do aluno.");
            }


        } catch (final IOException e) {
            System.out.println("Não existe aluno com esse número de matrícula!");
        }

        return loginObject;
    }
    @Override
    public Aluno getInfo(String cpf) {
        Aluno aluno = new Aluno();

        try {
            FileReader fileReader = new FileReader("alunos/" + cpf + ".json");

            try {
                Object alunoObject = new JSONParser().parse(fileReader);

                JSONObject alunoObjectJSON = (JSONObject) alunoObject;

                aluno.setNome((String) alunoObjectJSON.get("nome"));
                aluno.setCpf((String) alunoObjectJSON.get("cpf"));
                aluno.setDataNasc((String) alunoObjectJSON.get("dataNasc"));
                aluno.setSerie((Long) alunoObjectJSON.get("serie"));
                aluno.setEnsino((String) alunoObjectJSON.get("tipoDeEnsino"));
                aluno.setTurno((String) alunoObjectJSON.get("turno"));
                aluno.setNumeroDeMatricula((Long) alunoObjectJSON.get("numeroMatricula"));
                aluno.setMensalidade((String) alunoObjectJSON.get("valorMensalidade"));
                aluno.setPayDay((Long) alunoObjectJSON.get("dataVencFatura"));
                aluno.setSuspenso((Boolean) alunoObjectJSON.get("suspenso"));
                JSONArray alunoResponsaveisArray = (JSONArray) alunoObjectJSON.get("responsaveis");

                for (Object resp : alunoResponsaveisArray) {
                    JSONObject respJSON = (JSONObject) resp;
                    Responsavel responsavel = new Responsavel((String) respJSON.get("nome"), (String) respJSON.get("telefone"));
                    aluno.addResponsavel(responsavel);
                }

            } catch (final ParseException e) {
                System.out.println("Não foi possível ler os dados do aluno.");
            }

        } catch (final IOException e) {
            System.out.println(e.getClass());
            System.out.println("Não existe aluno com esse número de matrícula!");
       }

        return aluno;
    }

    @Override
    public boolean saveInfo(User user) {
        Aluno aluno = (Aluno) user;
        JSONObject alunoJSONObject = new JSONObject();

        boolean results = true;

        alunoJSONObject.put("numeroMatricula", aluno.getNumeroDeMatricula());
        alunoJSONObject.put("nome", aluno.getNome());
        alunoJSONObject.put("cpf", aluno.getCpf());
        alunoJSONObject.put("dataNasc", aluno.getDataNasc());
        alunoJSONObject.put("responsaveis", aluno.getResponsaveisAsJSON());
        alunoJSONObject.put("serie", aluno.getSerie());
        alunoJSONObject.put("tipoDeEnsino", aluno.getEnsino());
        alunoJSONObject.put("turno", aluno.getTurno());
        alunoJSONObject.put("valorMensalidade", aluno.getMensalidade());
        alunoJSONObject.put("dataVencFatura", aluno.getPayDay());
        alunoJSONObject.put("suspenso", aluno.getSuspenso());

        try {
            PrintWriter pw = new PrintWriter("alunos/" + aluno.getCpf() + ".json");
            pw.write(alunoJSONObject.toJSONString());
            pw.flush();
            pw.close();
        } catch (IOException e) {
            results = false;
            System.out.println("Não foi possível salvar os dados do aluno.");
        }

        return results;

    }
}
