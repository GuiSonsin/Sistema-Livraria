import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Emprestimo {
    private int id;
    private static int aux = 0;
    private Livro livro;
    private Cliente cliente;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(Livro livro, Cliente cliente) {
        this.id = aux++;
        this.livro = livro;
        this.cliente = cliente;
        this.dataEmprestimo = LocalDate.now();
    }

    public Emprestimo(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static int getAux() {
        return aux;
    }

    public static void setAux(int aux) {
        Emprestimo.aux = aux;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public String getDataEmprestimoFormatada() {
        DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataEmprestimo.format(formatacao);
    }

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public String getDataDevolucaoFormatada() {
        DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if (dataDevolucao == null){
            return "Não foi devolvido!";
        }
        return dataDevolucao.format(formatacao);
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}