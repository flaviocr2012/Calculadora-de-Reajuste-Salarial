package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    // Importante deixar o nome do método mais claro possível do cenário que você está testando.
    // Não importa se é grande, quem vai rodar o teste é o Junit.
    @Test
    void BonusDeveriaSerZeroPraFuncionarioComSalarioAlto() {
        BonusService service = new BonusService();
        // pra testar a exceção. Junit vai verificar se durante a chamada do método, essa exceção aconteceu
        // Essa abordagem é mais clean.
//        assertThrows(IllegalArgumentException.class,
//                () -> service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000"))));

        // Outra maneira de testar a exception
        // Essa abordagem é útil pra comparar a mensagem da exception
        try {
            service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000")));
            fail("Não deu a exception!");
        } catch (Exception e) {
            assertEquals("Salários acima de 10.000 não tem direito a bônus", e.getMessage());
        }
    }
//        assertEquals(BigDecimal.ZERO, bonus);


    @Test
    void BonusDeveriaSerDezPorCentoDoSalario() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("5000")));

        assertEquals(new BigDecimal("500.0"), bonus);
    }

    @Test
    void BonusPraFuncionarioComSalarioDeDezMilReais() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.0"), bonus);
    }
}

/** Abordagem dos testes
 * 1) Chamar um método que devolve um retorno. Posteriomente faço um assert em cima desse retorno pra
 * saber se ele está de acordo com o cenário esperado, ou seja, valido o retorno. ex: segundo teste.
 * 2) Métodos que são void e modificam um objeto passado como parâmetro. Nesse caso, faço o assert em cima
 * desse objeto pra saber se está de acordo. ex: método concederReajuste
 * 3) Saber se a exceção está acontecendo. ex: primeiro teste.
 */