package Entidades;

public abstract class Animal {
     // Atributos
     private String nome;
     private int idade;
     private Dono dono;
     
     
     public Animal(String nome, int idade, Dono dono) {
          this.nome = nome;
          this.idade = idade;
          this.dono = dono;
     }     
    

}
