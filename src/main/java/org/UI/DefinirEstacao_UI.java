package org.UI;

import org.Controller.DefinirEstacao_Controller;
import org.Model.AssistenteVestuario;
import org.Utils.Data;
import org.Utils.Utils;

/**
 * Interface com o Administrador para o caso de uso "Definir estações do ano".
 */
public class DefinirEstacao_UI
{
    private final DefinirEstacao_Controller controller;

    /**
     * @param assistente instância da aplicação
     */
    public DefinirEstacao_UI(AssistenteVestuario assistente)
    {
        this.controller = new DefinirEstacao_Controller(assistente);
    }

    /**
     * Executa o caso de uso.
     */
    public void run()
    {
        System.out.println("\nDefinir estações do ano (escreva 'fim' para terminar):");
        controller.iniciarListagem();

        String designacao;
        do
        {
            designacao = Utils.readLineFromConsole("Designação da estação do ano: ");
            if (!designacao.equalsIgnoreCase("fim"))
            {
                Data dataInicio = Utils.readDataFromConsole("Data de início (dd-mm-aaaa): ");
                Data dataFim = Utils.readDataFromConsole("Data de fim (dd-mm-aaaa): ");
                if (controller.adicionarEstacao(designacao, dataInicio, dataFim))
                {
                    System.out.println("Estação do ano adicionada à listagem.");
                }
                else
                {
                    System.out.println("Estação do ano inválida ou já existente, ou com período sobreposto. Introduza outra.");
                }
            }
        }
        while (!designacao.equalsIgnoreCase("fim"));

        String listagem = controller.obterListagem();
        if (listagem.isEmpty())
        {
            System.out.println("Não foi introduzida nenhuma estação do ano. Operação terminada.");
            return;
        }

        System.out.println("\nListagem de estações do ano:\n" + listagem);

        if (Utils.confirma("Confirma os dados? (S/N)"))
        {
            if (controller.registarEstacoes())
            {
                System.out.println("Estações do ano registadas com sucesso.");
            }
            else
            {
                System.out.println("Não foi possível registar as estações do ano.");
            }
        }
    }
}
