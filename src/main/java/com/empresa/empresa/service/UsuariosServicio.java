package com.empresa.empresa.service;

import java.util.*;

import com.empresa.empresa.model.Usuarios;
import com.empresa.empresa.model.reportes.EmailPassword;
import com.empresa.empresa.repository.UsuarioRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosServicio 
{
    @Autowired
    UsuarioRepositorio usuarioRepositorio;
    
    public List<Usuarios>getAll()
    {
        return usuarioRepositorio.getAll();
    }

    public Usuarios save(Usuarios usuarios)
    {
        //Verificar si el id es nulo, si es nulo se guarda
        if(usuarios.getId()==null)
        {
            return usuarioRepositorio.save(usuarios); 
        }
        else
        {
            Optional<Usuarios>consulta = usuarioRepositorio.getUsuario(usuarios.getId());
            if(consulta.isEmpty())
            {
                return usuarioRepositorio.save(usuarios);
            }
            else
            {
                return usuarios;
            }
        }
        
    }

    public Usuarios update (Usuarios usuario)
    {
        if(usuario.getId()!=null)
        {
            Optional<Usuarios>consulta = usuarioRepositorio.getUsuario(usuario.getId());
            if(!consulta.isEmpty())
            {
                if(usuario.getIdentification()!=null)
                {
                    consulta.get().setIdentification(usuario.getIdentification());
                }
                if(usuario.getName()!=null)
                {
                    consulta.get().setName(usuario.getName());
                }
                /* if(usuario.getBirthtDay()!=null)
                {
                    consulta.get().setBirthtDay(usuario.getBirthtDay());
                }
                if(usuario.getMonthBirthtDay()!=null)
                {
                    consulta.get().setMonthBirthtDay(usuario.getMonthBirthtDay());
                } */
                if(usuario.getAddress()!=null)
                {
                    consulta.get().setAddress(usuario.getAddress());
                }
                if(usuario.getCellPhone()!=null)
                {
                    consulta.get().setCellPhone(usuario.getCellPhone());
                }
                if(usuario.getEmail()!=null)
                {
                    consulta.get().setEmail(usuario.getEmail());
                }
                if(usuario.getPassword()!=null)
                {
                    consulta.get().setPassword(usuario.getPassword());
                }
                if(usuario.getZone()!=null)
                {
                    consulta.get().setZone(usuario.getZone());
                }
                if(usuario.getType()!=null)
                {
                    consulta.get().setType(usuario.getType());
                }
                return usuarioRepositorio.save(consulta.get());
            }
        }
        return usuario;
    }

    public void deleteUsuario(int id)
    {
        Optional<Usuarios>consulta = usuarioRepositorio.getUsuario(id);
        if(!consulta.isEmpty())
        {
            usuarioRepositorio.delete(consulta.get());
        }
    }

    public boolean getEmail(String email)
    {
        Optional <Usuarios>consulta = usuarioRepositorio.getEmail(email);
        if(!consulta.isEmpty())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public EmailPassword getEmailPassword(String email,String password)
    {
        Optional<Usuarios>consulta = usuarioRepositorio.getEmailPassword(email, password);
        if(!consulta.isEmpty())
        {
            /* EmailPassword reporteEP = new EmailPassword(consulta.get().getId(),consulta.get().getIdentification(),consulta.get().getName(),consulta.get().getBirthtDay(),consulta.get().getMonthBirthtDay(),consulta.get().getAddress(),consulta.get().getCellPhone(),consulta.get().getEmail(),consulta.get().getPassword(),consulta.get().getZone(),consulta.get().getType()); */
            EmailPassword reporteEP = new EmailPassword(consulta.get().getId(),consulta.get().getIdentification(),consulta.get().getName(),consulta.get().getAddress(),consulta.get().getCellPhone(),consulta.get().getEmail(),consulta.get().getPassword(),consulta.get().getZone(),consulta.get().getType());
            return reporteEP;
        }
        else
        {
            EmailPassword reporteEP = new EmailPassword(null,null,null,null,null,null,null,null,null);
            return reporteEP;
        }
    }
    
    public Optional<Usuarios> getUsuario(int id)
    {
        return usuarioRepositorio.getUsuario(id);
    }
}
