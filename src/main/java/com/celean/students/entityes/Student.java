package com.celean.students.entityes;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "name")
        private String name;

        @Column(name = "age")
        private int age;

        public Long getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public int getPrice() {
            return price;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public Product() {
        }

        public Product(String title, int price){
            this.title=title;
            this.price=price;
        }
    }

}
