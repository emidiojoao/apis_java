package com.senai.crud.services.usuario;

import com.senai.crud.dtos.usuario.AtualizarUsuarioDto;
import com.senai.crud.dtos.usuario.AutenticarUsuarioDto;
import com.senai.crud.dtos.usuario.ListaUsuarioDto;
import com.senai.crud.dtos.usuario.RequisicaoUsuarioDto;
import com.senai.crud.models.usuario.UsuarioModel;
import com.senai.crud.repositories.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired

    UsuarioRepository repository;
    //--Listar Usuário
    public List<ListaUsuarioDto> obterUsuarios(){

        List<ListaUsuarioDto> listaUsuarioDto = new ArrayList<>();
        List<UsuarioModel> listaUsuarioModel = repository.findAll();

        for (UsuarioModel usuarioModel : listaUsuarioModel){
            ListaUsuarioDto usuarioDto = new ListaUsuarioDto();
            usuarioDto.setId(usuarioModel.getId());
            usuarioDto.setNome(usuarioModel.getNome());
            usuarioDto.setEmail(usuarioModel.getEmail());

            listaUsuarioDto.add(usuarioDto);
        }
        return listaUsuarioDto;
    }

    //--Criar Usuário
    public Boolean criarUsuario(RequisicaoUsuarioDto requisicaoUsuarioDto){

        Optional<UsuarioModel> buscarEmailExistente = repository.findByEmail(requisicaoUsuarioDto.getEmail());
        if(buscarEmailExistente.isPresent()){
            return false;
        }

        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setNome(requisicaoUsuarioDto.getNome());
        usuarioModel.setEmail(requisicaoUsuarioDto.getEmail());
        usuarioModel.setSenha(requisicaoUsuarioDto.getSenha());

        repository.save(usuarioModel);
        return true;
    }

    //--Autenticar Usuário
    public Boolean autenticarUsuario(AutenticarUsuarioDto dados){

        Optional<UsuarioModel> buscarEmail = repository.findByEmail(dados.getEmail());
        if(buscarEmail.isPresent()){
            if (buscarEmail.get().getSenha().equals(dados.getSenha())){
                return true;
            }
        }
        return false;
    }

    //--Atualizar Usuário
    public AtualizarUsuarioDto atualizarUsuario(Long id){

        Optional<UsuarioModel> buscarUsuario = repository.findById(id);
        if(buscarUsuario.isEmpty()){
            return new AtualizarUsuarioDto();
        }

        return new AtualizarUsuarioDto(buscarUsuario.get());
    }

    //--Excluir Usuário
    public Boolean deletarUsuario(Long id){

        Optional<UsuarioModel> buscarUsuario = repository.findById(id);
        if(buscarUsuario.isEmpty()){
            return false;
        }

        repository.delete(buscarUsuario.get());
        return true;
    }

}
