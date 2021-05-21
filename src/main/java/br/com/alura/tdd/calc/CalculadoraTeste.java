package br.com.alura.tdd.calc;

public class CalculadoraTeste {

    public static void main(String[] args) {

        // Pra cada método pode-se testar várias possibilidades por isso a importância de uma biblioteca.
        // Aí que entra o Junit.
        // Essa é a maneira manual de fazer os testes, porém é trabalhoso e leva muito tempo.
        // Deveria testar todos os cnáios possíveis pra vários métodos.

        Calculadora calc = new Calculadora();
        int soma = calc.somar(3, 7);
        System.out.println(soma);

        soma = calc.somar(3, 0);
        System.out.println(soma);

        soma = calc.somar(3, -1);
        System.out.println(soma);

        soma = calc.somar(0, 0);
        System.out.println(soma);
    }
}
