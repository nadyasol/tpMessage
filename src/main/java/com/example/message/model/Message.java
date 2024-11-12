/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.message.model;

import java.time.LocalDateTime;

/**
 *
 * @author Nadya
 */
public class Message {
    private Long id; 
    private String user; 
    private String mensaje; 
    private LocalDateTime fechaCreacion;
    
    // Constructor 
    public Message(Long id, String user, String mensaje, LocalDateTime fechaCreacion) { 
        this.id = id; 
        this.user = user; 
        this.mensaje = mensaje; 
        this.fechaCreacion = fechaCreacion; 
    }
    // Getters y Setters 
    public Long getId() { 
        return id; 
    } 
    public void setId(Long id) {
        this.id = id; 
    }
    public String getUser() {
        return user; 
    }
    public void setUser(String user) { 
        this.user = user; 
    }
    public String getMensaje() { 
        return mensaje; 
    }
    public void setMensaje(String mensaje) { 
        this.mensaje = mensaje; 
    }
    public LocalDateTime getFechaCreacion() { 
        return fechaCreacion; 
    }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { 
        this.fechaCreacion = fechaCreacion; 
    }
}
