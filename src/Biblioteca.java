import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private ArrayList<Livro> listaDeLivros;
    private ArrayList<Autor> listaDeAutores;
    private ArrayList<Emprestimo> listaDeEmprestimo;
    private ArrayList<Cliente> listaDeCliente;

    public Biblioteca() {
        this.listaDeLivros = new ArrayList<>();
        this.listaDeAutores = new ArrayList<>();
        this.listaDeEmprestimo = new ArrayList<>();
        this.listaDeCliente = new ArrayList<>();
    }

    public void addLivro(){
        try {
            Scanner scan = new Scanner(System.in);
            Livro livro = new Livro();

            System.out.print("\nEscreva o tiutlo do livro: ");
            livro.setTitulo(scan.nextLine().toUpperCase());

            System.out.println("Lista de Autores Cadastrados");

            for (Autor autores : listaDeAutores){
                System.out.printf("ID: %d Nome: %s Data Nascimento: %s\n",
                        autores.getId(),autores.getNome(), autores.getDataNascimentoFormatada());
            }

            System.out.print("\nEscolha atraves do ID o autor do livro: ");
            int escolha = scan.nextInt();

            livro.setAutor(buscarAutorPorID(escolha));

            livro.setDisponivel(true);
            livro.setDataCadastro(LocalDate.now());
            livro.setDataAtualizacao(LocalDate.now());

            listaDeLivros.add(livro);

        }catch (Exception ex){
            ex.getMessage();
        }
    }

    public void mostrarLivros(){
        if (listaDeLivros.isEmpty()){
            System.out.println("Não há livros cadastrados!");
        }else {
            System.out.println("\n*******Livros Cadastrados na Biblioteca do Gui*******");
            for (Livro livros : listaDeLivros){
                System.out.printf("\nID: %d Livro: %s Autor: %s Data de Atualização: %s Disponivel: " + (livros.getDisponivel() ? "Sim" : "Não")
                        , livros.getId(), livros.getTitulo(), livros.getAutor().getNome(), livros.getDataAtualizacaoFormatada());
            }
            System.out.println();
        }
    }

    public void buscarLivroPeloID() {
        Scanner scan = new Scanner(System.in);
        boolean achouLivro = false;
        System.out.print("\nEntre com o ID do livro que deseja encontrar: ");
        int id = scan.nextInt();
        for (Livro livros : listaDeLivros){
            if (livros.getId() == id){
                achouLivro = true;
                System.out.println("\nNome do livro buscado: " + livros.getTitulo() +
                        " Autor: " + livros.getAutor().getNome());
            }
        }
        if (!achouLivro){
            System.out.println("Livro não existe no sistema!");
        }
    }

   public Livro buscarLivroPeloID(int id){
        for (Livro livros : listaDeLivros){
            if (livros.getId() == id){
                return livros;
            }
        }
        return null;
    }

    public Object removeLivro(){
        mostrarLivros();
        boolean achouLivro = false;
        Scanner scan = new Scanner(System.in);
        System.out.print("\nEntre com ID do livro que deseja remover: ");
        int id = scan.nextInt();

        for (Livro livro : listaDeLivros){
            if (livro.getId() == id){
                achouLivro = true;
                System.out.println("Livro removido com Sucesso!");
                return listaDeLivros.remove(livro);
            }
        }
        if (!achouLivro){
            System.out.println("Livro não existe no sistema");
        }
        return null;
    }

    public void mostraEmprestimoPorCliente(){
        Scanner scan  = new Scanner(System.in);
        boolean achouCliente = false;
        System.out.print("\nQual o cliente que deseja buscar (entre com o ID): ");
        int id = scan.nextInt();
        for(Emprestimo emprestimoClientes : listaDeEmprestimo){
            if(emprestimoClientes.getCliente().getId() == id){
                achouCliente = true;
                System.out.printf("\nEmprestimo: %d Titulo: %s Autor: %s Cliente: %s Data Emprestimo: %s Data Devolução: %s",
                        emprestimoClientes.getId(), emprestimoClientes.getLivro().getTitulo(),
                        emprestimoClientes.getLivro().getAutor().getNome(),
                        emprestimoClientes.getCliente().getNome(),
                        emprestimoClientes.getDataEmprestimoFormatada(),
                        emprestimoClientes.getDataDevolucaoFormatada());
            }
        }
        if(!achouCliente){
            System.out.println("\nCliente não existente no sistema ou não realizou nenhum emprestimo!");
        }
        System.out.println();
    }

    public void mostraEmprestimoPorLivro(){
        Scanner scan  = new Scanner(System.in);
        boolean achouLivro = false;
        System.out.print("\nQual o livro que deseja buscar (entre com o ID): ");
        int id = scan.nextInt();
        for(Emprestimo emprestimoLivros : listaDeEmprestimo){
            if(emprestimoLivros.getLivro().getId() == id){
                achouLivro = true;
                System.out.printf("\nEmprestimo: %d Titulo: %s Autor: %s Cliente: %s Data Emprestimo: %s Data Devolução: %s",
                        emprestimoLivros.getId(), emprestimoLivros.getLivro().getTitulo(),
                        emprestimoLivros.getLivro().getAutor().getNome(),
                        emprestimoLivros.getCliente().getNome(),
                        emprestimoLivros.getDataEmprestimoFormatada(),
                        emprestimoLivros.getDataDevolucaoFormatada());
            }
        }
        if(!achouLivro){
            System.out.println("\nLivro não existente no sistema ou não realizou nenhum emprestimo com ele!");
        }
        System.out.println();
    }


    public void buscarLivroPorTituloOuAutor(){
        Scanner scan  = new Scanner(System.in);
        boolean achouLivro = false;
        System.out.print("\nQual o titulo ou autor do livro que deseja buscar: ");
        String tituloAutor = scan.nextLine().toUpperCase();
        for(Livro livros : listaDeLivros){
            if(livros.getTitulo().contains(tituloAutor)  || livros.getAutor().getNome().contains(tituloAutor)){
                achouLivro = true;
                System.out.printf("\nID: %d Livro: %s Autor: %s Data de Atualização: %s Disponivel: " + (livros.getDisponivel() ? "Sim" : "Não")
                        , livros.getId(), livros.getTitulo(), livros.getAutor().getNome(), livros.getDataAtualizacaoFormatada());
            }
        }
        if(!achouLivro){
            System.out.println("\nTitulo errado ou nome autor errado!");
        }
        System.out.println();
    }

    public Object removeAutor(){
        Scanner scan = new Scanner(System.in);
        boolean achouAutor = false;
        mostrarAutores();
        System.out.print("\nEntre com ID do autor que deseja remover: ");
        int id = scan.nextInt();

        for (Autor autor : listaDeAutores){
            if (autor.getId() == id){
                achouAutor = true;
                System.out.println("Autor removido com Sucesso!");
                return listaDeAutores.remove(autor);
            }
        }
        if (!achouAutor){
            System.out.println("Autor não existe no sistema");
        }
        return null;
    }

    public void addAutor(){
        Scanner scan = new Scanner(System.in);
        Autor autor = new Autor();
        System.out.print("\nEscreva com o nome do autor: ");
        autor.setNome(scan.nextLine().toUpperCase());

        System.out.print("\nEscreva a data de nascimento do autor (dd/mm/aaaa): ");
        String dataString = scan.next();

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            LocalDate data = LocalDate.parse(dataString, formato);
            autor.setDataNascimento(data);
        } catch (DateTimeParseException e) {
            System.out.println("Data inválida: " + e.getMessage());
        }

        listaDeAutores.add(autor);
    }

    public void mostrarAutores(){
        if (listaDeAutores.isEmpty()){
            System.out.println("Não há nenhum autor cadastrado!");
        }else {
            System.out.println("\n*******Autores Cadastrados*******");
            for (Autor autores : listaDeAutores) {
                System.out.printf("\nID: %d Nome: %s Data Nascimento: %s"
                        , autores.getId(), autores.getNome(), autores.getDataNascimentoFormatada());
            }
            System.out.println();
        }
    }

    public Autor buscarAutorPorID(int id){
        for (Autor autores : listaDeAutores){
            if (autores.getId() == id){
                return autores;
            }
        }
        return null;
    }

    public Cliente buscarClientePorID(int id){
        for (Cliente clientes : listaDeCliente){
            if (clientes.getId() == id){
                return clientes;
            }
        }
        return null;
    }

    public void attLivro(){
        Scanner scan = new Scanner(System.in);
        boolean achouLivro = false;
        mostrarLivros();
        System.out.print("\nEntre com o ID do livro que deseja atualizar: ");
        int id = scan.nextInt();

        for (Livro livro : listaDeLivros){
            if (livro.getId() == id){
                achouLivro = true;
                System.out.println("O que deseja alterar do livro " + livro.getTitulo());
                System.out.println("0: Titulo\n1: Autor");
                System.out.print("\nSua escolha: ");
                int escolha = scan.nextInt();
                if (escolha == 0){
                    System.out.print("\nEscreva o novo titulo do livro: ");
                    livro.setTitulo(scan.nextLine().toUpperCase());
                    livro.setDataAtualizacao(LocalDate.now());
                } else if (escolha == 1) {
                    mostrarAutores();
                    System.out.print("\nEscolha qual o novo autor, por id, do livro: ");
                    int escolha2 = scan.nextInt();
                    livro.setAutor(buscarAutorPorID(escolha2));
                    livro.setDataAtualizacao(LocalDate.now());
                }
            }
        }
        if (!achouLivro){
            System.out.println("Livro não existe no sistema!");
        }
    }

    public void addCliente(){
        Cliente cliente = new Cliente();
        Scanner scan = new Scanner(System.in);
        System.out.print("\nEscreva o nome do cliente: ");
        cliente.setNome(scan.nextLine().toUpperCase());

        System.out.print("\nEscreva o email do cliente: ");
        cliente.setEmail(scan.next().toLowerCase());

        System.out.print("\nEscreva a data de nascimento do cliente (dd/MM/aaaa): ");
        String dataString = scan.next();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            LocalDate data = LocalDate.parse(dataString, formato);
            cliente.setDataNascimento(data);
        } catch (DateTimeParseException e) {
            System.out.println("Data inválida: " + e.getMessage());
        }

        listaDeCliente.add(cliente);
    }

    public void mostrarCliente(){
        if (listaDeCliente.isEmpty()){
            System.out.println("Não há nenhum cliente cadastrado!");
        }else {
            System.out.println("\n*******Clientes Cadastrados*******");
            for (Cliente clientes : listaDeCliente) {
                System.out.printf("\nID: %d Nome: %s Data Nascimento: %s Email %s"
                        , clientes.getId(), clientes.getNome(), clientes.getDataNascimentoFormatada(), clientes.getEmail());
            }
            System.out.println();
        }
    }

    public void emprestarLivro(){
        Scanner scan = new Scanner(System.in);
        boolean achouLivro = false;
        Emprestimo emprestimo = new Emprestimo();
        System.out.print("\nQual o ID do livro para ser emprestado: ");
        int id = scan.nextInt();
        for (Livro livros : listaDeLivros) {
            if ((livros.getId() == id)) {
                achouLivro = true;
                if (livros.getDisponivel()){

                    emprestimo.setLivro(buscarLivroPeloID(id));

                    System.out.print("Qual o ID do cliente que irá se emprestar o livro: ");
                    id = scan.nextInt();
                    emprestimo.setCliente(buscarClientePorID(id));

                    emprestimo.setDataEmprestimo(LocalDate.now());
                    livros.setDisponivel(false);

                    Emprestimo emprestimo1 = new Emprestimo(livros, buscarClientePorID(id));

                    listaDeEmprestimo.add(emprestimo1);

                    System.out.println("Emprestimo realizado com sucesso ao cliente!");
                    break;
                }else
                    System.out.println("Livro já foi emprestado!");
                    break;
            }
        }
        if (!achouLivro){
            System.out.println("Livro não existente no sistema!");
        }
    }

    public void devolverLivro(){
        Scanner scan = new Scanner(System.in);
        boolean achouLivro = false;

        System.out.print("\nQual o ID do livro para ser devolvido: ");
        int id = scan.nextInt();

        for (Livro livros : listaDeLivros) {
            if ((livros.getId() == id)) {
                 achouLivro = true;
                if (!livros.getDisponivel()){
                    for (Emprestimo emprestimo : listaDeEmprestimo) {
                        if (emprestimo.getLivro().getId() == livros.getId()) {
                            emprestimo.setDataDevolucao(LocalDate.now());
                            livros.setDisponivel(true);
                            System.out.println("Devolução realizada com sucesso !");
                        }
                    }
                }else{
                    System.out.println("Livro não foi emprestado!");
                }
            }
        }
        if (!achouLivro){
            System.out.println("Livro não existente no sistema!");
        }
    }

    public void mostrarEmprestimos(){

        if (this.listaDeEmprestimo.isEmpty()){
            System.out.println("Não há nenhum emprestimo cadastrado!");
        }else {
            System.out.println("\nEmprestimos Cadastrados");
            for (Emprestimo emprestimo : listaDeEmprestimo) {
                System.out.printf("\nID: %d Titulo: %s Autor: %s Cliente: %s Data Emprestimo: %s Data Devolução: %s",
                        emprestimo.getId(), emprestimo.getLivro().getTitulo(),
                        emprestimo.getLivro().getAutor().getNome(),
                        emprestimo.getCliente().getNome(),
                        emprestimo.getDataEmprestimoFormatada(),
                        emprestimo.getDataDevolucaoFormatada());
            }
            System.out.println();
        }
    }

    public ArrayList<Livro> getListaDeLivros() {
        return listaDeLivros;
    }

    public void setListaDeLivros(ArrayList<Livro> listaDeLivros) {
        this.listaDeLivros = listaDeLivros;
    }

    public ArrayList<Autor> getListaDeAutores() {
        return listaDeAutores;
    }

    public void setListaDeAutores(ArrayList<Autor> listaDeAutores) {
        this.listaDeAutores = listaDeAutores;
    }

    public ArrayList<Emprestimo> getListaDeEmprestimo() {
        return listaDeEmprestimo;
    }

    public void setListaDeEmprestimo(ArrayList<Emprestimo> listaDeEmprestimo) {
        this.listaDeEmprestimo = listaDeEmprestimo;
    }

    public ArrayList<Cliente> getListaDeCliente() {
        return listaDeCliente;
    }

    public void setListaDeCliente(ArrayList<Cliente> listaDeCliente) {
        this.listaDeCliente = listaDeCliente;
    }
}
