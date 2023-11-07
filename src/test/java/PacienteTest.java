import example.ListaEspera;
import example.Paciente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PacienteTest {

    @Test
    void deveNotificarUmAluno() {
        ListaEspera listaEspera = new ListaEspera("Joao", "Clinica A");
        Paciente paciente = new Paciente("Paciente 1");
        paciente.cadastrarListaEspera(listaEspera);
        listaEspera.agendarPacienteEmEspera();
        assertEquals("Paciente 1, atendimento agendado com {Nome do medico=Joao, Nome da clinica=Clinica A}", paciente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarAlunos() {
        ListaEspera listaEspera = new ListaEspera("Joao", "Clinica A");
        Paciente paciente = new Paciente("Paciente 1");
        Paciente paciente2 = new Paciente("Paciente 2");
        paciente.cadastrarListaEspera(listaEspera);
        paciente2.cadastrarListaEspera(listaEspera);
        listaEspera.agendarPacienteEmEspera();
        System.out.println(paciente.getUltimaNotificacao());
        assertEquals("Paciente 1, atendimento agendado com {Nome do medico=Joao, Nome da clinica=Clinica A}", paciente.getUltimaNotificacao());
        assertEquals("Paciente 2, atendimento agendado com {Nome do medico=Joao, Nome da clinica=Clinica A}", paciente2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarAluno() {
        ListaEspera listaEspera = new ListaEspera("Joao", "Clinica A");
        Paciente paciente = new Paciente("Paciente 1");
        listaEspera.agendarPacienteEmEspera();
        assertEquals(null, paciente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarAlunoTurmaA() {
        ListaEspera listaEspera = new ListaEspera("Joao", "Clinica A");
        Paciente paciente = new Paciente("Paciente 1");
        ListaEspera listaEsperaB = new ListaEspera("Ze", "Clinica B");
        Paciente paciente2 = new Paciente("Paciente 2");
        paciente.cadastrarListaEspera(listaEspera);
        paciente2.cadastrarListaEspera(listaEsperaB);
        listaEspera.agendarPacienteEmEspera();
        assertEquals("Paciente 1, atendimento agendado com {Nome do medico=Joao, Nome da clinica=Clinica A}", paciente.getUltimaNotificacao());
        assertEquals(null, paciente2.getUltimaNotificacao());
    }
}
