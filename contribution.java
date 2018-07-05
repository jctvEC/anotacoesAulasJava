https://www.caelum.com.br/apostila-java-orientacao-objetos/#null
//https://sites.google.com/a/cin.ufpe.br/if686ec/
//--------------------AULA_2-------------------
@jctv 


public class Conta {

    private String numero = "318620";
    private double saldo;

    
//    public Conta(String numero, double saldo) {//construtor
// 			  numero = numero; regra de escopo vai atribuir o valor a ela mesma pois existe essa var local... so se nao existesse aqui que iria buscar no escopo mais acima que seria a var do objeto.
//        this.numero = numero;
//        this.saldo = saldo;
//    }
//    
//     public Conta(double saldo) {//construtor
//         this.saldo = saldo;
//    }

//     public Conta() {} //construtor default

    
    public void creditar (double valor){
        this.saldo += valor;
    }
    
    public void debitar (double valor){
        this.saldo -= valor;
    }
    
    public String getNumero() {
        return this.numero;
    }

    public double getSaldo() {
        return this.saldo;
    }

    // pode ta em outroa arquivo num mesmo pacote mas roda se tiver aqui embaixo também.
  
     public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Oiee Java!");
        Conta contaDudu = new Conta(); //construtor default
        //Conta contaDudu  = new Conta ("21323", 2320);
        // Conta contaDuduRico  = new Conta (2320);
        contaDudu.debitar(20);
        System.out.println(contaDudu.getSaldo());
        contaDudu.creditar(240);
        System.out.println(contaDudu.getSaldo());
        //System.out.println("numero é " + contaDuduRico.getNumero());


        }
    
    
}

//--------------------FIM_AULA__2----------------


//----=--------AP4-----juliano--------------------------
/*
Implemente a classe Texto que é a representação de um texto
qualquer com algumas operações básicas. A forma de implementar
essa classe ficará a sua escolha (desde que você respeite os
princípios da programação orientada a objetos, principalmente os de
encapsulamento), entretanto a classe deverá possuir métodos:

1. Imprimir o texto completo na tela do console,

2. Informar o número total de palavras do texto,

3. informar a frequência de uma determinada palavra dentro do texto;

4. Substituir todas as ocorrências de uma palavra no texto por 
uma outra palavraqualquer. 

Considere que uma palavra é uma sequência de caracteres
alfanuméricos, separadas por espaços, tabs ou pontuação. Crie também
uma aplicação simples que utilize ao menos uma vez cada um dos
métodos propostos para essa classe.
 */
package texto;

/**
 * if686ec - PLC - Paradigmas e Linguagens Computacionais
 * @author jctv - Juliano Cezar Teles Vaz - Cin UFPE 
 */
public class Texto {
    
    private String texto;

    public Texto(String texto) { //construtor
        this.texto = texto;
    }
    
    public String getTexto() {
        return texto;
    }
  
    public int informaNumeroTotalDePalavrasNoTexto(){
    int words;

    String [] sentence = this.texto.split("[^a-zA-Z0-9]+");

    words = sentence.length;

    return words;

}
    //    public void setTexto(String texto) {
    //        this.texto = texto;
    //    }
 
   public void imprime(){ //1
       System.out.println(getTexto()); 
   }
   
   public int informaTotalDaPalavra(String plv){
       String baseTexto = this.texto.toLowerCase();
       int cont = 0, controle = 0, indexDaPalavraEncontrada = 0;
      
       if(!(this.texto.contains(plv))) return 0;
       
   
       
       while (indexDaPalavraEncontrada != -1) {           
           indexDaPalavraEncontrada = baseTexto.indexOf(plv);
           if(indexDaPalavraEncontrada != -1){
            cont++;             
            controle = indexDaPalavraEncontrada + plv.length();
            baseTexto = baseTexto.substring(controle, baseTexto.length());
         }
       }
       if (cont == 0 && (this.texto.contains(plv)) == true ) return 1;
       
       return cont ;
  
   } 

  
    public void substituiOcorrenciasDaPalavra(String plvOcorrente, String plvAserSubstituida){
        this.texto = this.texto.replaceAll("(?i)" + plvOcorrente, plvAserSubstituida); //funcinou bem ignorar os casos de letra maiuscula aqui..   
    }

      public static void main (String [] args) {
          
          //aplicacao
         
        Texto artigo =  new Texto("Neverland unfortunately cannot be open for public visitation. We wish it could.  Its location and the applicable zoning regulations prohibit opening it up to the public. During his lifetime, Michael explored this possibility and was faced with the fact that it could not be done.");
        
        System.out.println("Artigo:");
        artigo.imprime();
       System.out.println("Trocando a palavra many por HUEHUEHEU:");
        artigo.substituiOcorrenciasDaPalavra("many", "HUEHUEHEU");
        artigo.imprime();
        System.out.println("O numero total de palavras ~be~ é:" + artigo.informaTotalDaPalavra("be"));
        System.out.println("O numero total de palavras ~Neverland~ é:" + artigo.informaTotalDaPalavra("Neverland"));
        System.out.println("O numero total de palavras no texto é:" + artigo.informaNumeroTotalDePalavrasNoTexto());
      }
}

//------------------fim---------------------------
