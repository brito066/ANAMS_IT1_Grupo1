package org.Controller;

import java.util.ArrayList;
import java.util.List;

import org.Model.AssistenteVestuario;
import org.Model.Estacao;
import org.Utils.Data;

/**
 * Controlador do caso de uso "Definir estações do ano" (padrão Controller).
 */
public class DefinirEstacao_Controller
{
    private final AssistenteVestuario assistente;
    private List<Estacao> estacoes;

    /**
     * @param assistente instância da aplicação
     */
    public DefinirEstacao_Controller(AssistenteVestuario assistente)
    {
        this.assistente = assistente;
    }

    /**
     * Inicia uma nova listagem de estações do ano, ainda vazia.
     */
    public void iniciarListagem()
    {
        this.estacoes = new ArrayList<>();
    }

    /**
     * Cria uma estação do ano com os dados indicados e, se for válida, adiciona-a
     * à listagem em construção.
     *
     * @param designacao designação da estação do ano
     * @param dataInicio data de início do período
     * @param dataFim data de fim do período
     * @return true se a estação do ano foi aceite
     */
    public boolean adicionarEstacao(String designacao, Data dataInicio, Data dataFim)
    {
        Estacao estacao = assistente.novaEstacao();
        estacao.setDados(designacao, dataInicio, dataFim);
        if (assistente.validarEstacao(estacao, estacoes))
        {
            estacoes.add(estacao);
            return true;
        }
        return false;
    }

    /**
     * @return listagem em construção, em formato de texto (vazia se não
     *         tiver estações do ano)
     */
    public String obterListagem()
    {
        StringBuilder sb = new StringBuilder();
        for (Estacao x : estacoes)
        {
            sb.append(x.obterDados());
        }
        return sb.toString();
    }

    /**
     * Regista no sistema as estações do ano da listagem.
     *
     * @return true se as estações do ano foram registadas
     */
    public boolean registarEstacoes()
    {
        return assistente.registarEstacoes(estacoes);
    }
}
