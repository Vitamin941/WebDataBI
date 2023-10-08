package ru.isu.math.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Arabia_population")
public class ArabData {

     @Id
     int id;

     @Column(name = "region")
     String region;

     @Column(name = "year")
     int year;

     @Column(name = "gender")
     String gender;

     @Column(name = "nationaly")
     String nationaly;

     @Column(name = "population")
     int population;

     public int getYear() {
          return year;
     }

     public void setYear(int year) {
          this.year = year;
     }

     public String getRegion() {
          return region;
     }

     public void setRegion(String text) {
          this.region = text;
     }

     public long getId() {
          return id;
     }

     public void setId(int id) {
          this.id = id;
     }

     public String getGender() {
          return gender;
     }

     public void setGender(String gender) {
          this.gender = gender;
     }

     public String getNationaly() {
          return nationaly;
     }

     public void setNationaly(String nationaly) {
          this.nationaly = nationaly;
     }

     public int getPopulation() {
          return population;
     }

     public void setPopulation(int population) {
          this.population = population;
     }

     @Override
     public String toString() {
          return "Model{" +
                  "id=" + id +
                  ", region='" + region + '\'' +
                  '}';
     }
}
