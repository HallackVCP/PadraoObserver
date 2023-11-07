package example;

import java.util.Observable;
import java.util.Observer;

public class Paciente implements Observer {

    private String nome;
    private String ultimaNotificacao;


    public Paciente(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }

    public void cadastrarListaEspera(ListaEspera listaEspera){
        listaEspera.addObserver(this);
    }

    @Override
    public void update(Observable listaEspera, Object arg) {
        this.ultimaNotificacao = this.nome + ", atendimento agendado com " + listaEspera.toString();
    }
}
