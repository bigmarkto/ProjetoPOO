package Entidades;

public abstract class Animal {
     private String nome;
     private int idade;
     private String especie;
    
     public Animal(String nome, int idade, String especie) {
          this.nome = nome;
          this.idade = idade;
          this.especie = especie;
     }
    
     public String getNome() {
          return nome;
     }
    
     public void setNome(String nome) {
          this.nome = nome;
     }
    
     public int getIdade() {
          return idade;
     }
    
     public void setIdade(int idade) {
          this.idade = idade;
     }
    
     public String getEspecie() {
          return especie;
     }
    
     public void setEspecie(String especie) {
          this.especie = especie;
     }    
}
