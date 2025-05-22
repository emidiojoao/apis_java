package com.senai.crud.services;

import com.senai.crud.dtos.*;
import com.senai.crud.dtos.usuario.*;
import com.senai.crud.exception.InvalidOperationException;
import com.senai.crud.models.UsuarioModel;
import com.senai.crud.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private List<UsuarioModel> listaUsuarios = new ArrayList<>();

    @Autowired
    UsuarioRepository repository;

    public boolean adicionarUsuario(RequisicaoUsuarioDTO usuarioDto){

        Optional<UsuarioModel> usuarioModelOptional = repository.findByLogin(usuarioDto.getLogin());
        if(usuarioModelOptional.isPresent()){
            throw new InvalidOperationException("E-mail já cadastrado!");
        }
        UsuarioModel usuarioModel = new UsuarioModel();
        usuarioModel.setNome(usuarioDto.getNome());
        usuarioModel.setLogin(usuarioDto.getLogin());
        usuarioModel.setSenha(usuarioDto.getSenha());

        repository.save(usuarioModel);

        return true;
    }

    public boolean atualizarUsuario( Long id, AtualizarUsuarioDTO usuarioDto ){

        //--buscar no banco de dados o usuário pelo ID
        Optional<UsuarioModel> usuarioOptional = repository.findById(id);

        Optional<UsuarioModel> usuarioOptionalLogin = repository.findByLogin(usuarioDto.getLogin());

        if( usuarioOptionalLogin.isPresent() && !usuarioOptionalLogin.get().getId().equals(id) ){
            throw new InvalidOperationException("Já existe um usuário com este login!");
        }

        System.out.println("chegou no service=" + usuarioOptional.isPresent());

        //--Se encontrar o usuário
        if (usuarioOptional.isPresent()){

            //--Atualizar

            //--Obter o usuario dentro do optinal
            UsuarioModel usuario = usuarioOptional.get();

            //--atualizar valores do usuario
            usuario.setNome(usuarioDto.getNome());
            usuario.setLogin(usuarioDto.getLogin());
            if (!usuarioDto.getSenha().isEmpty()) {
                usuario.setSenha(usuarioDto.getSenha());
            }

            //--persistir usuário no banco de dados
            repository.save(usuario);

            return true;

        }

        return false;

    }

    public AtualizarUsuarioDTO buscarUsuarioId(Long id){

         Optional<UsuarioModel> usuarioOP = repository.findById(id);
         if (!usuarioOP.isPresent()){
             //--quando não encontra retorna um objeto com id ZERO
             return new AtualizarUsuarioDTO(0L);
         }
         return new AtualizarUsuarioDTO(usuarioOP.get());

    }

    public RespostaUsuarioDTO buscarUsuarioPorId(Long id){

        RespostaUsuarioDTO usuarioRetorno = new RespostaUsuarioDTO();

        //--buscar no banco de dados o usuário pelo ID
        Optional<UsuarioModel> usuarioOptional = repository.findById(id);

        //--Se encontrar o usuário
        if (usuarioOptional.isPresent()){

            //--Obter o usuario do optinal
            UsuarioModel usuario = usuarioOptional.get();

            //--Converter usuarioModel para o DTO
            usuarioRetorno.setId(usuario.getId());
            usuarioRetorno.setNome(usuario.getNome());
            usuarioRetorno.setLogin(usuario.getLogin());
            usuarioRetorno.setSenha(usuario.getSenha());

        }

        //--retornar o DTO
        return  usuarioRetorno;
    }

    public List<ListarUsuarioDTO> listarUsuarios(){

        //--Obter os usuários do banco de dados
        List<UsuarioModel> listaUsuarios = repository.findAll();

        //--Criar a lista DTO para realizar o retorno
        List<ListarUsuarioDTO> lista = new ArrayList<>();

        //--Percorre a lista de usuários do banco e converter em uma lista de DTO
        for ( UsuarioModel usuario :  listaUsuarios ){

            //--Crio UM objeto DTO
            ListarUsuarioDTO usuarioRetorno = new ListarUsuarioDTO();

            //--Converto UM objeto model em UM objeto DTO
            usuarioRetorno.setId(usuario.getId());
            usuarioRetorno.setNome(usuario.getNome());
            usuarioRetorno.setLogin(usuario.getLogin());

            //--Adciono o objeto DTO na lista de UsuarioDto
            lista.add(usuarioRetorno);
        }

        return lista;
    }

    public Boolean removerUsuario(Long id){

        //--buscar no banco de dados o usuário pelo ID
        Optional<UsuarioModel> usuarioOptional = repository.findById(id);

        //--Se encontrar o usuário
        if (usuarioOptional.isPresent()){

            repository.delete(usuarioOptional.get());
            return true;
        }

        return false;
    }

    public Boolean logar(LoginDTO loginDTO){

        Optional<UsuarioModel> usuarioOptional = repository.findByLogin(loginDTO.getLogin());
        if (usuarioOptional.isPresent()){

            if (usuarioOptional.get().getSenha().equals(loginDTO.getSenha())){
                return true;
            }
        }
        return false;
    }

    public UsuarioSessaoDTO logar2(LoginDTO loginDTO){

        UsuarioSessaoDTO usuarioSessaoDTO = new UsuarioSessaoDTO();

        Optional<UsuarioModel> usuarioOptional = repository.findByLogin(loginDTO.getLogin());

        if(usuarioOptional.isPresent()){

            if(usuarioOptional.get().getSenha().equals(loginDTO.getSenha())){

                usuarioSessaoDTO.setId(usuarioOptional.get().getId());
                usuarioSessaoDTO.setNome(usuarioOptional.get().getNome());
            }
        }

        return usuarioSessaoDTO;
    }

}
