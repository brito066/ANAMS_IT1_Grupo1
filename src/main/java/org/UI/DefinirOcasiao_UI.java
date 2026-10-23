package org.UI;

import org.Controller.DefinirOcasiao_Controller;
import org.Model.AssistenteVestuario;
import org.Utils.Utils;

/**
 * Interface com o Administrador para o caso de uso "Definir ocasiões".
 */
public class DefinirOcasiao_UI
{
    private final DefinirOcasiao_Controller controller;

    /**
     * @param assistente instância da aplicação
     */
    public DefinirOcasiao_UI(AssistenteVestuario assistente)
    {
        this.controller = new DefinirOcasiao_Controller(assistente);
    }

    /**
     * Executa o caso de uso.
     */
    public void run()
    {
        System.out.println("\nDefinir ocasiões (escreva 'fim' para terminar):");
        controller.iniciarListagem();

        String designacao;
        do
        {
            designacao = Utils.readLineFromConsole("Designação da ocasião: ");
            if (!designacao.equalsIgnoreCase("fim"))
            {
                if (controller.adicionarOcasiao(designacao))
                {
                    System.out.println("Ocasião adicionada à listagem.");
                }
                else
                {
                    System.out.println("Ocasião inválida ou já existente. Introduza outra.");
                }
            }
        }
        while (!designacao.equalsIgnoreCase("fim"));

        String listagem = controller.obterListagem();
        if (listagem.isEmpty())
        {
            System.out.println("Não foi introduzida nenhuma ocasião. Operação terminada.");
            return;
        }

        System.out.println("\nListagem de ocasiões:\n" + listagem);

        if (Utils.confirma("Confirma os dados? (S/N)"))
        {
            if (controller.registarOcasioes())
            {
                System.out.println("Ocasiões registadas com sucesso.");
            }
            else
            {
                System.out.println("Não foi possível registar as ocasiões.");
            }
        }
    }
}
