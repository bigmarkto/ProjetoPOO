package entidades;

public abstract class Animal {
     // Atributos
     protected static int idStatico = 1;
     protected int id;
     private String nome;
     private int idade;
     private Dono dono;
     
     // Construtor
     protected Animal(String nome, int idade, Dono dono) {
          this.nome = nome;
          this.idade = idade;
          this.dono = dono;
          this.id = idStatico++;
     }

     // Getters e Setters

     /**
      * Retorna o tipo do animal.
      * 
      * @return Uma string que representa o tipo do animal (por exemplo, "Cachorro", "Gato").
      */
     // Método abstrato que deve ser implementado pelas subclasses
     public abstract String getTipo();
    
     /**
      * Retorna o nome do animal.
      * 
      * @return O nome do animal.
      */
     public String getNome() {
          return nome;
     }

     /**
      * Define o nome do animal.
      * 
      * @param nome O novo nome do animal.
      */
     public void setNome(String nome) {
          this.nome = nome;
     }

     /**
      * Retorna o dono do animal.
      * 
      * @return O dono do animal.
      */
     public Dono getDono() {
          return dono;
     }

     /**
      * Define o dono do animal.
      *
      * @param dono O novo dono do animal.
      */
     public void setDono(Dono dono) {
          this.dono = dono;
     }

     /**
      * Retorna a idade do animal.
      * 
      * @return A idade do animal.
      */
     public int getIdade() {
          return idade;
     }

     /**
      * Altera a idade do animal.
      * 
      * @param idade A nova idade do animal.
      */
     public void setIdade(int idade) {
          this.idade = idade;
     }

     /**
      * Retorna o ID do animal.
      * 
      * @return O ID único do animal, que é gerado automaticamente
      *         pelo construtor.
      */
     public int getId() {
          return id;
     }
}
