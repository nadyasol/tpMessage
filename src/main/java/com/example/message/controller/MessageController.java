/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.message.controller;

import com.example.message.model.Message; 
import com.example.message.service.MessageService; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.*; 

import java.util.List; 
import java.util.Optional;

/**
 *
 * @author Nadya
 */

@RestController 
@RequestMapping("/api/messages")
public class MessageController {
    @Autowired 
    private MessageService messageService; 
// Obtener todos los mensajes 
    @GetMapping 
    public List<Message> getAllMessages() { 
        return messageService.getAllMessages(); 
    }
    
    // Obtener mensaje por ID 
    @GetMapping("/{id}") 
    public ResponseEntity<Message> getMessageById(@PathVariable Long id) { 
        Optional<Message> message = messageService.getMessageById(id); 
        return message.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build()); 
    } 
    // Agregar un nuevo mensaje 
    @PostMapping 
    public Message addMessage(@RequestBody Message message) { 
        return messageService.addMessage(message); 
    }
    // Actualizar un mensaje existente 
    @PutMapping("/{id}") 
    public ResponseEntity<Message> updateMessage(@PathVariable Long id, @RequestBody Message updatedMessage) { 
        Message message = messageService.updateMessage(id, updatedMessage); 
        return (message != null) ? ResponseEntity.ok(message) : ResponseEntity.notFound().build(); 
    } 
    // Eliminar un mensaje 
    @DeleteMapping("/{id}") 
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) { 
        boolean deleted = messageService.deleteMessage(id); 
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build(); 
    }

}
