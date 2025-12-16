import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContaTest {

    // Testamos get e set juntos: definimos um valor e vemos se o get recupera o mesmo
    @Test
    void setNumero() {
        Conta conta = new Conta();
        conta.setNumero(12345);
        assertEquals(12345, conta.getNumero());
    }

    @Test
    void getNumero() {
        // Geralmente redundante se já temos o setNumero, mas pode servir para testar valor padrão (0)
        Conta conta = new Conta();
        assertEquals(0, conta.getNumero());
    }

    @Test
    void setAgencia() {
        Conta conta = new Conta();
        conta.setAgencia(1001);
        assertEquals(1001, conta.getAgencia());
    }

    @Test
    void getAgencia() {
        Conta conta = new Conta();
        assertEquals(0, conta.getAgencia()); // Testando valor inicial padrão
    }

    @Test
    void setNome() {
        Conta conta = new Conta();
        conta.setNome("Fulano");
        assertEquals("Fulano", conta.getNome());
    }

    @Test
    void getNome() {
        Conta conta = new Conta();
        assertNull(conta.getNome()); // String sem valor inicial é null
    }

    @Test
    void setSaldo() {
        Conta conta = new Conta();
        conta.setSaldo(500.0);
        assertEquals(500.0, conta.getSaldo());
    }

    @Test
    void getSaldo() {
        Conta conta = new Conta();
        assertEquals(0.0, conta.getSaldo());
    }

    @Test
    void depositar() {
        Conta conta = new Conta();
        conta.setSaldo(100.0);
        conta.depositar(50.0);
        assertEquals(150.0, conta.getSaldo());
    }

    @Test
    void sacar() {
        Conta conta = new Conta();
        conta.setSaldo(200.0);
        boolean conseguiuSacar = conta.sacar(100.0);

        assertTrue(conseguiuSacar);
        assertEquals(100.0, conta.getSaldo());
    }

    // --- ATENÇÃO AQUI: Teste de Transferência com Sucesso ---
    @Test
    void transferir() {
        Conta origem = new Conta();
        origem.setSaldo(100.0);

        Conta destino = new Conta();
        destino.setSaldo(0.0);

        // Transfere 50 da origem para o destino
        boolean sucesso = origem.transferir(50.0, destino);

        assertTrue(sucesso);
        assertEquals(50.0, origem.getSaldo()); // Origem deve ter diminuído
        assertEquals(50.0, destino.getSaldo()); // Destino deve ter aumentado
    }

    // --- Teste de Transferência que FALHA (Sem saldo) ---
    @Test
    void transferirSemSaldo() {
        Conta origem = new Conta();
        origem.setSaldo(10.0); // Só tem 10 reais

        Conta destino = new Conta();
        destino.setSaldo(0.0);

        // Tenta transferir 50 (não deve conseguir)
        boolean sucesso = origem.transferir(50.0, destino);

        assertFalse(sucesso);
        assertEquals(10.0, origem.getSaldo()); // Saldo não pode mudar
        assertEquals(0.0, destino.getSaldo()); // Destino não recebe nada
    }
}