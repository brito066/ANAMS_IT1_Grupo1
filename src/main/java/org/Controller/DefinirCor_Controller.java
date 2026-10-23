package org.Controller;

import java.util.ArrayList;
import java.util.List;

import org.Model.AssistenteVestuario;
import org.Model.Cor;

/**
 * Controlador do caso de uso "Definir listagem de cores" (padrão Controller).
 */
public class DefinirCor_Controller
{
    private final AssistenteVestuario assistente;
    private List<Cor> cores;

    /**
     * @param assistente instância da aplicação
     */
    public DefinirCor_Controller(AssistenteVestuario assistente)
    {
        this.assistente = assistente;
    }

    /**
     * Inicia uma nova listagem de cores, ainda vazia.
     */
    public void iniciarListagem()
    {
        this.cores = new ArrayList<>();
    }

    /**
     * Cria uma cor com os dados indicados e, se for válida, adiciona-a
     * à listagem em construção.
     *
     * @param designacao designação da cor
     * @return true se a cor foi aceite
     */
    public boolean adicionarCor(String designacao)
    {
        Cor cor = assistente.novaCor();
        cor.setDados(designacao);
        if (assistente.validarCor(cor, cores))
        {
            cores.add(cor);
            return true;
        }
        return false;
    }

    /**
     * @return listagem em construção, em formato de texto (vazia se não
     *         tiver cores)
     */
    public String obterListagem()
    {
        StringBuilder sb = new StringBuilder();
        for (Cor x : cores)
        {
            sb.append(x.obterDados());
        }
        return sb.toString();
    }

    /**
     * Regista no sistema as cores da listagem.
     *
     * @return true se as cores foram registadas
     */
    public boolean registarCores()
    {
        return assistente.registarCores(cores);
    }
}
