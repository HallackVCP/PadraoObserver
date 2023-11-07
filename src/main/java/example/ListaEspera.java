package example;

import java.util.Observable;

public class ListaEspera extends Observable {

    private String nomeMedico;

    private String nomeClinica;

    public ListaEspera(String nomeMedico, String nomeClinica) {
        this.nomeMedico = nomeMedico;
        this.nomeClinica = nomeClinica;
    }

    public void agendarPacienteEmEspera() {
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "{" +
                "Nome do medico=" + nomeMedico +
                ", Nome da clinica=" + nomeClinica +
                '}';
    }
}
