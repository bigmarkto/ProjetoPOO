package Entidades;

public abstract class Animal {
     // Atributos
     protected static int idStatico = 1;
     protected int id;
     private String nome;
     private int idade;
     private Dono dono;
     
     
     
     public Animal(String nome, int idade, Dono dono) {
          this.nome = nome;
          this.idade = idade;
          this.dono = dono;
          this.id = idStatico++;
          System.out.println("Animal criado com sucesso com ID: " + this.id);
     }

     public String getTipo() {
          return this.getClass().getSimpleName();
     };
    
     // Getters e Setters
     public String getNome() {
          return nome;
     }

     public void setNome(String nome) {
          this.nome = nome;
     }

     public Dono getDono() {
          return dono;
     }

     public void setDono(Dono dono) {
          this.dono = dono;
     }

     public int getIdade() {
          return idade;
     }

     public void setIdade(int idade) {
          this.idade = idade;
     }

     public int getId() {
          return id;
     }
}
