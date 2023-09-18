package ru.isu.math.model;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;

@Entity
public class Model {

     @Id
     int id;

     String text;
}
