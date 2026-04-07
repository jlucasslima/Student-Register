package visao;

import controle.CadastroAlunos;
import modelo.Aluno;
import java.util.Scanner;

/**
 * Implementação da interface em modo Texto (Console).
 */
public class MenuTexto implements IMenu {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void exibirMenu(CadastroAlunos cadastro) {
        boolean executando = true;

        while (executando) {
            System.out.println("\n=== SISTEMA DE CADASTRO ===");
            System.out.println("1 - Inserir novo aluno");
            System.out.println("2 - Remover aluno");
            System.out.println("3 - Listar alunos");
            System.out.println("4 - Atualizar aluno");
            System.out.println("5 - Sair");
            System.out.print("Selecione a opção: ");

            String opcaoStr = scanner.nextLine().trim();

            switch (opcaoStr) {
                case "1": // RF01 - INSERIR
                    if (cadastro.isCheio()) {
                        exibirErro("Não é possível inserir. O cadastro atingiu a capacidade máxima!");
                        break;
                    }

                    String ra = lerApenasNumeros("Digite a matrícula (RA) do aluno (ou deixe em branco para cancelar):");
                    if (ra == null) break;
                    
                    if (cadastro.matriculaExiste(ra)) {
                        exibirErro("Matrícula já cadastrada! Não é permitido duplicatas.");
                        break;
                    }

                    String nome = lerApenasLetras("Digite o nome completo do aluno (ou deixe em branco para cancelar):", false);
                    if (nome == null) break;

                    int idade = lerInteiro("Digite a idade do aluno (ou deixe em branco para cancelar):");
                    if (idade == -1) break; 
                    
                    if (!cadastro.isIdadeValida(idade)) {
                        exibirErro("Idade inválida. A idade deve estar entre 16 e 80 anos.");
                        break;
                    }

                    String curso = lerApenasLetras("Digite o curso do aluno (ou deixe em branco para cancelar):", false);
                    if (curso == null) break;

                    Aluno novoAluno = new Aluno(nome, idade, ra, curso);
                    if (cadastro.inserir(novoAluno)) {
                        exibirSucesso("Aluno inserido com sucesso!");
                    }
                    break;

                case "2": // RF02 - REMOVER
                    String raRemover = lerApenasNumeros("Digite o RA do aluno que deseja remover (ou deixe vazio para cancelar):");
                    if (raRemover == null) break;

                    if (!cadastro.matriculaExiste(raRemover)) {
                        exibirErro("Operação cancelada: Matrícula inexistente.");
                        break;
                    }

                    if (cadastro.remover(raRemover)) {
                        exibirSucesso("Aluno removido com sucesso!");
                    }
                    break;

                case "3": // RF03 - LISTAR
                    Aluno[] lista = cadastro.listar();
                    if (lista.length == 0) {
                        exibirSucesso("Nenhum aluno cadastrado no momento.");
                        break;
                    }

                    System.out.println("\nComo deseja listar os alunos?");
                    System.out.println("1 - Formato Normal");
                    System.out.println("2 - Formato Bibliografia");
                    System.out.print("Escolha (1 ou 2): ");
                    String escolha = scanner.nextLine().trim();

                    if (!escolha.equals("1") && !escolha.equals("2")) {
                        exibirErro("Escolha inválida. Listagem cancelada.");
                        break;
                    }

                    System.out.println("\n" + (escolha.equals("2") ? "LISTA DE ALUNOS (Formato Bibliografia):" : "LISTA DE ALUNOS (Formato Padrão):"));
                    for (Aluno a : lista) {
                        if (escolha.equals("2")) {
                            System.out.println("RA: " + a.getRa() + " | Aluno: " + a.getNomeBiblio() + " | Idade: " + a.getIdade() + " | Curso: " + a.getCurso());
                        } else {
                            System.out.println(a.toString());
                        }
                    }
                    break;

                case "4": // RF04 - ATUALIZAR
                    String raAtualizar = lerApenasNumeros("Digite o RA do aluno que deseja atualizar (ou deixe vazio para cancelar):");
                    if (raAtualizar == null) break;

                    Aluno alunoExistente = cadastro.buscar(raAtualizar);
                    if (alunoExistente == null) {
                        exibirErro("Operação cancelada: Matrícula inexistente.");
                        break;
                    }

                    String novoNome = lerApenasLetras("Digite o novo nome (ou deixe vazio para manter '" + alunoExistente.getNome() + "'):", true);
                    if (novoNome == null) break; 
                    if (!novoNome.isEmpty()) alunoExistente.setNome(novoNome);

                    int novaIdade = lerInteiroOpcional("Digite a nova idade (ou deixe vazio para manter " + alunoExistente.getIdade() + "):");
                    if (novaIdade != -1) {
                        if (cadastro.isIdadeValida(novaIdade)) {
                            alunoExistente.setIdade(novaIdade);
                        } else {
                            exibirErro("Idade inválida. Operação abortada.");
                            break;
                        }
                    }

                    String novoCurso = lerApenasLetras("Digite o novo curso (ou deixe vazio para manter '" + alunoExistente.getCurso() + "'):", true);
                    if (novoCurso == null) break; 
                    if (!novoCurso.isEmpty()) alunoExistente.setCurso(novoCurso);

                    cadastro.atualizar(alunoExistente);
                    exibirSucesso("Dados do aluno atualizados com sucesso!");
                    break;

                case "5":
                    executando = false;
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    exibirErro("Opção inválida. Digite um número de 1 a 5.");
            }
        }
    }

    private String lerApenasLetras(String mensagem, boolean permiteVazio) {
        while (true) {
            System.out.println(mensagem);
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            
            if (input.equalsIgnoreCase("cancelar")) return null;
            
            if (input.isEmpty()) {
                if (permiteVazio) return ""; 
                else return null; // Interpreta vazio como cancelamento em modo texto
            }
            
            if (input.matches("^[a-zA-ZÀ-ÿ\\s]+$")) return input;
            else exibirErro("Entrada inválida! APENAS letras e espaços são permitidos.");
        }
    }

    private String lerApenasNumeros(String mensagem) {
        while (true) {
            System.out.println(mensagem);
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            
            if (input.isEmpty() || input.equalsIgnoreCase("cancelar")) return null; 
            
            if (input.matches("^[0-9]+$")) return input;
            else exibirErro("Entrada inválida! APENAS números.");
        }
    }

    private int lerInteiro(String mensagem) {
        while (true) {
            System.out.println(mensagem);
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty() || input.equalsIgnoreCase("cancelar")) return -1;
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                exibirErro("Entrada inválida! Digite um número inteiro.");
            }
        }
    }

    private int lerInteiroOpcional(String mensagem) {
        while (true) {
            System.out.println(mensagem);
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) return -1; // -1 indica manter o valor antigo
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                exibirErro("Entrada inválida! Digite um número inteiro.");
            }
        }
    }

    private void exibirErro(String mensagem) {
        System.out.println("[ERRO] " + mensagem);
    }

    private void exibirSucesso(String mensagem) {
        System.out.println("[SUCESSO] " + mensagem);
    }
}