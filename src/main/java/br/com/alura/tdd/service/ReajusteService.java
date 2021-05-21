package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {

    public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {

        // Havia vários if elses, tiramos e colocamos no Enum.
        // Técnica de refatoração. Deixe ele mais simples e mais fácil de dar manutenção.
        // TDD -> teste, implementação e refatoração. O teste deve ser escrito pensando no comportamento
        // e não na implementação.
        BigDecimal percentual = desempenho.percentualReajuste();
        BigDecimal reajuste = funcionario.getSalario().multiply(percentual);
        funcionario.reajustarSalario(reajuste);
    }
}

/** Test Driven Development
 * Vantagens:
 * Código já sai testado;
 * Evita testes viciados na implementação;
 * Refatoração faz parte do processo;
 * Ajuda a manter o foco;
 * Temos uma tendência em escrever um código mais simples.
 *
 * Quando implementar?
 * Quando você não souber direito a estrutura do projeto. Aquele código que é mais complexo de escrever.
 * (algoritmos e validações por exemplo). O TDD ajuda a rascunhar.
 */
