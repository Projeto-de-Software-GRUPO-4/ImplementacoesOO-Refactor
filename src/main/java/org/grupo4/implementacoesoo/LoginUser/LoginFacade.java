package org.grupo4.implementacoesoo.LoginUser;

import org.grupo4.implementacoesoo.Repository.AdministradorRepository;
import org.grupo4.implementacoesoo.Repository.AlunoRepository;
import org.grupo4.implementacoesoo.Repository.ProfessorRepository;
import org.grupo4.implementacoesoo.Domain.ResponseMessage;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginFacade {

    public ResponseMessage verifyAdmin(LoginDTO loginAdminDTO) {
        String senha = loginAdminDTO.getSenha();
        String id = loginAdminDTO.getId();

        AdministradorRepository adminRepository = new AdministradorRepository();
        LoginDTO administrador = adminRepository.getCredentials(id);

        ResponseMessage response = new ResponseMessage();

        if (administrador.getId().equals(id) && administrador.getSenha().equals(senha)) {
            response.setCode(200);
            response.setMessage("Login bem-sucedido");
        } else {
            response.setCode(400);
            response.setMessage("Não existe usuário com essas credenciais");
        }

        return response;

    }

    public ResponseMessage verifyAluno(LoginDTO loginAdminDTO) {
        String senha = loginAdminDTO.getSenha();
        String id = loginAdminDTO.getId();

        AlunoRepository alunoRepository = new AlunoRepository();
        LoginDTO credentials = alunoRepository.getCredentials(id);
        ResponseMessage response = new ResponseMessage();

        if (!credentials.getId().equals("false")) {
            response.setCode(200);

            if (credentials.getSenha().equals(senha)) {
                response.setMessage("Login bem-sucedido");
            } else {
                response.setMessage("Senha incorreta");
            }

        } else {
            response.setCode(400);
            response.setMessage("Não existe usuário com essas credenciais");
        }

        return response;

    }

    public ResponseMessage verifyProfessor(LoginDTO loginAdminDTO) {
        String senha = loginAdminDTO.getSenha();
        String id = loginAdminDTO.getId();

        ProfessorRepository professorRepository = new ProfessorRepository();
        LoginDTO credentials = professorRepository.getCredentials(id);
        ResponseMessage response = new ResponseMessage();

        if (!credentials.getId().equals("false")) {
            response.setCode(200);

            if (credentials.getSenha().equals(senha)) {
                response.setMessage("Login bem-sucedido");
            } else {
                response.setMessage("Senha incorreta");
            }

        } else {
            response.setCode(400);
            response.setMessage("Não existe usuário com essas credenciais");
        }

        return response;

    }

}
