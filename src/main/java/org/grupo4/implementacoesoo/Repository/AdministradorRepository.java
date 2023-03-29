package org.grupo4.implementacoesoo.Repository;

import org.grupo4.implementacoesoo.AdicionarAtualizarUsuario.AdicionarDTO;
import org.grupo4.implementacoesoo.Domain.Administrador;
import org.grupo4.implementacoesoo.Domain.User;
import org.grupo4.implementacoesoo.LoginUser.LoginDTO;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class AdministradorRepository implements UserRepository {

    @Override
    public Administrador getInfo(String id) {
        return new Administrador();
    }

    @Override
    public boolean saveCredentials(AdicionarDTO adicionarDTO) {

        return true;
    }


    @Override
    public boolean saveInfo(User user) {

        return false;
    }

    @Override
    public LoginDTO getCredentials(String id) {
        LoginDTO administrador = new LoginDTO();

        try {
            FileReader fileReader = new FileReader("archives/admins.json");
            try {
                Object adminObject = new JSONParser().parse(fileReader);

                JSONObject adminObjectJSON = (JSONObject) adminObject;

                administrador.setId((String) adminObjectJSON.get("id"));
                administrador.setSenha((String) adminObjectJSON.get("senha"));

                System.out.println(administrador.getId());
                System.out.println(administrador.getSenha());

            } catch (final ParseException e) {
                System.out.println("Não foi possível ler os dados do admin.");
            }

        } catch (final IOException e) {
            System.out.println(e.getClass().getName());
        }

        return administrador;
    }


}
