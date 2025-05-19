package com.senai.crud.sessao;

import com.senai.crud.dtos.usuario.UsuarioSessaoDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class ControleSessao {

    public static void registrar(HttpServletRequest requiciao, UsuarioSessaoDTO usuarioSessaoDTO){
        HttpSession sessao = requiciao.getSession(true);
        sessao.setAttribute("codigoUsuario", usuarioSessaoDTO.getId());
        sessao.setAttribute("nomeUsuario", usuarioSessaoDTO.getNome());


    }

    public static UsuarioSessaoDTO obter(HttpServletRequest requesicao){
        HttpSession sessao = requesicao.getSession(false);
        UsuarioSessaoDTO usuarioSessaoDTO = new UsuarioSessaoDTO();
        if(sessao != null){
            usuarioSessaoDTO.setId((long) sessao.getAttribute("codigoUsuario"));
            usuarioSessaoDTO.setNome((String) sessao.getAttribute("nomeUsuario"));
        }
        return usuarioSessaoDTO;
    }

    public static void encerrar(HttpServletRequest requisicao){
        HttpSession sessao = requisicao.getSession(false);
        if(sessao != null){
            sessao.invalidate();
        }
    }
}
