import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Autor {
    private static int aux = 0;
    private int id;
    private String nome;
    private LocalDate dataNascimento;

    public Autor(String nome, LocalDate dataNascimento) {
        this.id = aux++;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public Autor(){
        this.id = aux++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDataNascimentoFormatada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataNascimento.format(formatter);
    }
}
