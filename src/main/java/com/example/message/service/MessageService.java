/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.message.service;

import com.example.message.model.Message; 
import org.springframework.stereotype.Service; 

import java.time.LocalDateTime; 
import java.util.ArrayList; 
import java.util.List; 
import java.util.Optional;

/**
 *
 * @author Nadya
 */


@Service
public class MessageService {
    private List<Message> messages = new ArrayList<>();
    private Long nextId = 1L;

    public MessageService() {
        messages.add(new Message(nextId++, "Nadya Olmos", "Re-Cargando...", LocalDateTime.now()));
        messages.add(new Message(nextId++, "Mariana Soto", "Falta poco para la money ", LocalDateTime.now()));
    }

    // Get all messages
    public List<Message> getAllMessages() {
        return messages;
    }

    // Get message by ID
    public Optional<Message> getMessageById(Long id) {
        return messages.stream().filter(m -> m.getId().equals(id)).findFirst();
    }

    // Add message
    public Message addMessage(Message message) {
        message.setId(nextId++);
        message.setFechaCreacion(LocalDateTime.now());
        messages.add(message);
        return message;
    }

    // Update message
    public Message updateMessage(Long id, Message updatedMessage) {
        Optional<Message> optionalMessage = getMessageById(id);
        if (optionalMessage.isPresent()) {
            Message message = optionalMessage.get();
            message.setUser(updatedMessage.getUser());
            message.setMensaje(updatedMessage.getMensaje());
            message.setFechaCreacion(updatedMessage.getFechaCreacion());
            return message;
        }
        return null;
    }

    // Delete message
    public boolean deleteMessage(Long id) {
        return messages.removeIf(m -> m.getId().equals(id));
    }
}
