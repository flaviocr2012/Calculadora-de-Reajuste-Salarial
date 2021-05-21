package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach // antes de executar cada método, chame o inicializar
    public void inicializar() {
        System.out.println("INÍCIO");
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Leonardo", LocalDate.now(), new BigDecimal("1000.00"));
    }

    @AfterEach
    public void finalizar(){
        System.out.println("FIM");
    }

    @BeforeAll
    public static void antesDeTodos(){
        System.out.println("Antes de todos");
    }

    @AfterAll
    public static void depoisDeTodos(){
        System.out.println("Depois de todos");
    }

    @Test
    public void reajusteTresPorCentoDesempenhoAdesejar() {
        service.concederReajuste(funcionario, Desempenho.A_Desejar);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteQuinzePorCentoDesempenhoBom() {
        service.concederReajuste(funcionario, Desempenho.Bom);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteVintePorCentoDesempenhoOtimo() {
        service.concederReajuste(funcionario, Desempenho.Otimo);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
