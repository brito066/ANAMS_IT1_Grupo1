package org.Controller;

import java.util.ArrayList;
import java.util.List;

import org.Model.AssistenteVestuario;
import org.Model.Ocasiao;

/**
 * Controlador do caso de uso "Definir ocasiões" (padrão Controller).
 */
public class DefinirOcasiao_Controller
{
    private final AssistenteVestuario assistente;
    private List<Ocasiao> ocasioes;

    /**
     * @param assistente instância da aplicação
     */
    public DefinirOcasiao_Controller(AssistenteVestuario assistente)
    {
        this.assistente = assistente;
    }

    /**
     * Inicia uma nova listagem de ocasiões, ainda vazia.
     */
    public void iniciarListagem()
    {
        this.ocasioes = new ArrayList<>();
    }

    /**
     * Cria uma ocasião com os dados indicados e, se for válida, adiciona-a
     * à listagem em construção.
     *
     * @param designacao designação da ocasião
     * @return true se a ocasião foi aceite
     */
    public boolean adicionarOcasiao(String designacao)
    {
        Ocasiao ocasiao = assistente.novaOcasiao();
        ocasiao.setDados(designacao);
        if (assistente.validarOcasiao(ocasiao, ocasioes))
        {
            ocasioes.add(ocasiao);
            return true;
        }
        return false;
    }

    /**
     * @return listagem em construção, em formato de texto (vazia se não
     *         tiver ocasiões)
     */
    public String obterListagem()
    {
        StringBuilder sb = new StringBuilder();
        for (Ocasiao x : ocasioes)
        {
            sb.append(x.obterDados());
        }
        return sb.toString();
    }

    /**
     * Regista no sistema as ocasiões da listagem.
     *
     * @return true se as ocasiões foram registadas
     */
    public boolean registarOcasioes()
    {
        return assistente.registarOcasioes(ocasioes);
    }
}
