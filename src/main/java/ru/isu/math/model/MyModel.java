package ru.isu.math.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test")
public class MyModel {

     @Id
     long id;

     @Column(name = "text")
     String text;

     public String getText() {
          return text;
     }

     public void setText(String text) {
          this.text = text;
     }

     public long getId() {
          return id;
     }

     public void setId(long id) {
          this.id = id;
     }

     @Override
     public String toString() {
          return "Model{" +
                  "id=" + id +
                  ", text='" + text + '\'' +
                  '}';
     }
}
