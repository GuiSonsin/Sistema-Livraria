import java.time.LocalDate;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Livro livro = new Livro();
        Autor autor = new Autor();
        Cliente cliente = new Cliente();
        Emprestimo emprestimo = new Emprestimo();
        Biblioteca biblioteca = new Biblioteca();

        int op = 0;
        while (op != 17){
            System.out.println("\n******* Sistema da Biblioteca do Gui *******");
            System.out.println("1: Cadastrar Livro\n2: Cadastrar Cliente\n3: Emprestar Livro\n4:" +
                    " Cadastrar Autor\n5: Mostrar Livros\n6: Mostrar Autores\n7: Buscar Livro por ID\n8: Remover Livro\n" +
                    "9: Remove Autor\n10: Atualizar Livro\n11: Mostrar Clientes\n12: Mostrar Todos Emprestimos\n13: Devolver" +
                    " Livro\n14: Buscar Emprestimo por Cliente\n15: Buscar Emprestimo por Livro\n16: Buscar livro por " +
                    "nome do autor ou titulo do livro\n17: Sair");
            System.out.print("\nSua escolha: ");
            op = scan.nextInt();
            System.out.println();
            switch (op){
                case 1:
                        biblioteca.addLivro();
                        break;
                case 2:
                        biblioteca.addCliente();
                        break;
                case 3:
                        biblioteca.emprestarLivro();
                        break;
                case 4:
                        biblioteca.addAutor();
                        break;
                case 5:
                        biblioteca.mostrarLivros();
                        break;
                case 6:
                        biblioteca.mostrarAutores();
                        break;
                case 7:
                        biblioteca.buscarLivroPeloID();
                        break;
                case 8:
                        biblioteca.removeLivro();
                        break;
                case 9:
                        biblioteca.removeAutor();
                        break;
                case 10:
                        biblioteca.attLivro();
                        break;
                case 11:
                        biblioteca.mostrarCliente();
                        break;
                case 12:
                        biblioteca.mostrarEmprestimos();
                        break;
                case 13:
                        biblioteca.devolverLivro();
                        break;
                case 14:
                    biblioteca.mostraEmprestimoPorCliente();
                    break;
                case 15:
                    biblioteca.mostraEmprestimoPorLivro();
                    break;
                case 16:
                    biblioteca.buscarLivroPorTituloOuAutor();
                    break;
                case 17:
                        System.out.println("\nFechando Sistema da Biblioteca do Gui");
                        break;
                default:
                        System.out.println("\nOpção Inexistente!");

            }
        }

    }
}