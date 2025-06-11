package db;

import java.time.LocalDateTime;
import java.util.Objects;

public class PessoasDb {
    private Integer id;
    private String nome;
    private String dt_nascimento;
    private String documento;
    private String email;
    private LocalDateTime dt_criacao;

    public PessoasDb(){
    }
    public PessoasDb(Integer id, String nome, String dt_nascimento, String documento, String email, LocalDateTime dt_criacao) {
        this.id = id;
        this.nome = nome;
        this.dt_nascimento = dt_nascimento;
        this.documento = documento;
        this.email = email;
        this.dt_criacao = dt_criacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDt_nascimento() {
        return dt_nascimento;
    }

    public void setDt_nascimento(String dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getDt_criacao() {
        return dt_criacao;
    }

    public void setDt_criacao(LocalDateTime dt_criacao) {
        this.dt_criacao = dt_criacao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PessoasDb pessoasDb = (PessoasDb) o;
        return Objects.equals(id, pessoasDb.id) && Objects.equals(nome, pessoasDb.nome) && Objects.equals(dt_nascimento, pessoasDb.dt_nascimento) && Objects.equals(documento, pessoasDb.documento) && Objects.equals(email, pessoasDb.email) && Objects.equals(dt_criacao, pessoasDb.dt_criacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, dt_nascimento, documento, email, dt_criacao);
    }

    @Override
    public String toString() {
        return "pessoasDb{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dt_nascimento='" + dt_nascimento + '\'' +
                ", documento='" + documento + '\'' +
                ", email='" + email + '\'' +
                ", dt_criacao=" + dt_criacao +
                '}';
    }
}
