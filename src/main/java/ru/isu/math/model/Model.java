package ru.isu.math.model;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;

@Entity
public class Model {

     @Id
     int id;

     String text;

     public String getText() {
          return text;
     }

     public void setText(String text) {
          this.text = text;
     }

     @Override
     public String toString() {
          return "Model{" +
                  "id=" + id +
                  ", text='" + text + '\'' +
                  '}';
     }
}
