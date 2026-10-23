package org.UI;

import java.io.IOException;

import org.Model.AssistenteVestuario;
import org.Utils.*;

/**
 *
 * @author Dulce Mota <mdm@isep.ipp.pt>
 */
public class MenuUtF_UI
{
    private AssistenteVestuario vesteMe;
    private String opcao;

    public MenuUtF_UI(AssistenteVestuario vesteMe)
    {
        this.vesteMe = vesteMe;
    }
    public void run() throws IOException
    {
        do
        {  // Completar/Adaptar
            System.out.println("###### MENU #####\n\n");
            System.out.println("1. Introduzir/registar peça de vestuário");
            System.out.println("2. .......");
            System.out.println("3. ........");
            System.out.println("4. ........");
            System.out.println("5. ........");

            System.out.println("0. Voltar");

            opcao = Utils.readLineFromConsole("Escolha uma opção: ");

            if( opcao.equals("1") )
            {
                // Completar
                System.out.println("Selecionou a opção 1");
            }
            else
            if( opcao.equals("2") )
            {
                // Completar
                System.out.println("Selecionou a opção 2");
            }
            else
            if( opcao.equals("3") )
            {
                // Completar
                System.out.println("Selecionou a opção 3");
            }
            else
            if( opcao.equals("4") )
            {
                // Completar
                System.out.println("Selecionou a opção 4");
            }
            else
            if( opcao.equals("5") )
            {
                // Completar
                System.out.println("Selecionou a opção 5");
            }

        }
        while (!opcao.equals("0") );
    }
}
