package com.example.coursework.answer;

import com.example.coursework.authentication.enumerations.Status;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Answer<T> {

    private Status status;
    private List<T> data;

    public Answer(Status status) {
        this.status = status;
        this.data = null;
    }

    public Answer(Status status, T data) {
        this.status = status;
        this.data = new ArrayList<>();
        this.data.add(data);

    }

    public String json(Status status, Object response) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Answer<Object> answer = new Answer<>(status, response);
        return objectMapper.writeValueAsString(answer);
    }

    public String json(Status status) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Answer<String> answer = new Answer<>(status);
        return objectMapper.writeValueAsString(answer);
    }
}
