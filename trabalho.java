import java.util.Scanner;
public class SistemaGestaoEscolar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Obter informações do aluno de Matemática
        System.out.print("Digite o nome do aluno de Matemática: ");
        String nomeMatematica = scanner.nextLine();
        CursoMatematica alunoMatematica = new CursoMatematica(nomeMatematica);
        System.out.print("Digite a primeira nota de Matemática: ");
        double notaMatematica1 = scanner.nextDouble();
        alunoMatematica.adicionarNota(notaMatematica1);
        System.out.print("Digite a segunda nota de Matemática: ");
        double notaMatematica2 = scanner.nextDouble();
        alunoMatematica.adicionarNota(notaMatematica2);
        // Obter informações do aluno de Literatura
        System.out.print("Digite o nome do aluno de Literatura: ");
        scanner.nextLine(); 
        String nomeLiteratura = scanner.nextLine();
        CursoLiteratura alunoLiteratura = new CursoLiteratura(nomeLiteratura);
        System.out.print("Digite a primeira nota de Literatura: ");
        double notaLiteratura1 = scanner.nextDouble();
        alunoLiteratura.adicionarNota(notaLiteratura1);
        System.out.print("Digite a segunda nota de Literatura: ");
        double notaLiteratura2 = scanner.nextDouble();
        alunoLiteratura.adicionarNota(notaLiteratura2);
        // Exibir médias
        System.out.println("Média do aluno de Matemática: " + alunoMatematica.calcularMedia());
        System.out.println("Média do aluno de Literatura: " + alunoLiteratura.calcularMedia());
        scanner.close();
    }
}

// Classe CursoLiteratura, derivada de Aluno
class CursoLiteratura extends Aluno {
    private int obrasLidas;
  //notas bonus
    public CursoLiteratura(String nome) {
        super(nome, "Literatura");
        this.obrasLidas = 5; // 
    }
  //notas bonus
    public double calcularMedia() {
        double mediaGeral = super.calcularMedia();
        return mediaGeral + (obrasLidas * 0.5); 
    }
}

class CursoMatematica extends Aluno {
    private double coeficienteDificuldade;
     //notas bonus
    public CursoMatematica(String nome) {
        super(nome, "Matemática");
        this.coeficienteDificuldade = 1.5; 
    }
  //notas bonus
    public double calcularMedia() {
        double mediaGeral = super.calcularMedia();
        return mediaGeral * coeficienteDificuldade;
    }
}
import java.util.ArrayList;
import java.util.List;
class Aluno {
    private String nome;
    private String curso;
    private List<Double> notas;
    public Aluno(String nome, String curso) {
        this.nome = nome;
        this.curso = curso;
        this.notas = new ArrayList<>();
    }
    public String getNome() {
        return nome;
    }
    public String getCurso() {
        return curso;
    }
    public List<Double> getNotas() {
        return notas;
    }
    public void adicionarNota(double nota) {
        notas.add(nota);
    }
    public double calcularMedia() {
        if (notas.isEmpty()) {
            return 0.0;
        }
        double soma = 0.0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.size();
    }
}