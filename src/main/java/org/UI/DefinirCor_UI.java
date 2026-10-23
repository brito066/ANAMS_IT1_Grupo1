package org.UI;

import org.Controller.DefinirCor_Controller;
import org.Model.AssistenteVestuario;
import org.Utils.Utils;

/**
 * Interface com o Administrador para o caso de uso "Definir listagem de cores".
 */
public class DefinirCor_UI
{
    private final DefinirCor_Controller controller;

    /**
     * @param assistente instância da aplicação
     */
    public DefinirCor_UI(AssistenteVestuario assistente)
    {
        this.controller = new DefinirCor_Controller(assistente);
    }

    /**
     * Executa o caso de uso.
     */
    public void run()
    {
        System.out.println("\nDefinir listagem de cores (escreva 'fim' para terminar):");
        controller.iniciarListagem();

        String designacao;
        do
        {
            designacao = Utils.readLineFromConsole("Designação da cor: ");
            if (!designacao.equalsIgnoreCase("fim"))
            {
                if (controller.adicionarCor(designacao))
                {
                    System.out.println("Cor adicionada à listagem.");
                }
                else
                {
                    System.out.println("Cor inválida ou já existente. Introduza outra.");
                }
            }
        }
        while (!designacao.equalsIgnoreCase("fim"));

        String listagem = controller.obterListagem();
        if (listagem.isEmpty())
        {
            System.out.println("Não foi introduzida nenhuma cor. Operação terminada.");
            return;
        }

        System.out.println("\nListagem de cores:\n" + listagem);

        if (Utils.confirma("Confirma os dados? (S/N)"))
        {
            if (controller.registarCores())
            {
                System.out.println("Cores registadas com sucesso.");
            }
            else
            {
                System.out.println("Não foi possível registar as cores.");
            }
        }
    }
}
