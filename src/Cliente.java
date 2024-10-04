import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Cliente {
    private static int aux = 0;
    private int id;
    private String nome;
    private String email;
    private LocalDate dataNascimento;

    public Cliente(String nome, String email, LocalDate dataNascimento) {
        this.id = aux++;
        this.nome = nome;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public Cliente(){
        this.id = aux++;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
