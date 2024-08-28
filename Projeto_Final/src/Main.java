import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int x, cod;
        ArrayList<Musicas> listamidia = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formata = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        do {

            System.out.println("[1] - Listar Musicas\n" +
                    "[2] - Cadastrar nova música\n" +
                    "[3] - Consultar música por código\n" +
                    "{--IGNORAR--} [4] - Listas todas as músicas\n" +
                    "[5] - Alterar uma música por código\n" +
                    "[6] - Excluir música por código\n" +
                    "[7] - Limpar lista\n" +
                    "[8] - Quantidade de músicas\n" +
                    "[9] - Sair\n");

            x = Integer.parseInt(sc.nextLine());

            switch (x) {
                case 1:
                    for (Musicas msc : listamidia) {
                        System.out.println("Título: " + msc.titulo);
                        System.out.println("Código: " + msc.codigo);
                        System.out.println();
                    }
                    break;

                case 2:
                    System.out.println("---- Adicione uma música ----\n");
                    boolean codigoExistente;

                    do {
                        codigoExistente = false;
                        System.out.println("Código:");
                        cod = sc.nextInt();
                        sc.nextLine();

                        for (Musicas msc : listamidia) {
                            if (msc.codigo == cod) {
                                System.err.println("Código já existente. Por favor, insira um código diferente.\n");
                                codigoExistente = true;
                                break;
                            }
                        }
                    } while (codigoExistente);

                    Musicas musica = new Musicas();
                    musica.codigo = cod;

                    System.out.println("Título:");
                    musica.titulo = sc.nextLine();

                    System.out.println("Artista:");
                    musica.artista = sc.nextLine();

                    System.out.println("Duração:");
                    musica.duracao = Integer.parseInt(sc.nextLine());

                    System.out.println("Ano de lançamento:");
                    musica.ano = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Data de lançamento (AAAA-MM-DD):");
                    musica.data = LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
                    sc.nextLine();  // Consome a linha pendente após o input da data
                    musica.dataformatada = musica.data.format(formata);

                    System.out.println("Gênero musical:");
                    musica.genero = sc.nextLine();

                    listamidia.add(musica);
                    System.out.println("Música adicionada com sucesso!\n");
                    break;

                case 3:
                    System.out.println("--- Informe o código a ser consultado ---\n");
                    cod = sc.nextInt();
                    sc.nextLine();
                    boolean encontrado = false;

                    for (Musicas i : listamidia) {
                        if (i.codigo == cod) {
                            System.out.println("\nTítulo: " + i.titulo +
                                    "\nCódigo: " + i.codigo +
                                    "\nArtista: " + i.artista +
                                    "\nDuração: " + i.duracao +
                                    "\nAno de lançamento: " + i.ano +
                                    "\nData de lançamento: " + i.dataformatada +
                                    "\nGênero: " + i.genero);
                            encontrado = true;
                            break;
                        }
                    }
                    if (!encontrado) {
                        System.err.println("Código não encontrado\n");
                    }
                    break;

                case 5:
                    System.out.println("--- Informe o código a ser consultado ---\n");
                    cod = sc.nextInt();
                    sc.nextLine();

                    for (Musicas i : listamidia) {
                        if (i.codigo == cod) {
                            System.out.println("Título:");
                            i.titulo = sc.nextLine();

                            System.out.println("Artista:");
                            i.artista = sc.nextLine();

                            System.out.println("Duração:");
                            i.duracao = Integer.parseInt(sc.nextLine());

                            System.out.println("Ano de lançamento:");
                            i.ano = sc.nextInt();
                            sc.nextLine();

                            System.out.println("Data de lançamento (AAAA-MM-DD):");
                            i.data = LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt());
                            sc.nextLine();
                            i.dataformatada = i.data.format(formata);

                            System.out.println("Gênero musical:");
                            i.genero = sc.nextLine();
                            System.out.println("Música alterada com sucesso!\n");
                            break;

                        } else {
                            System.err.println("Código não encontrado\n");
                        }
                    }
                    break;

                case 6:
                    System.out.println("--- Informe o código a ser retirado ---\n");
                    cod = sc.nextInt();
                    sc.nextLine();

                    boolean removed = false;

                    for (Musicas i : listamidia) {
                        if (i.codigo == cod) {
                            listamidia.remove(i);
                            removed = true;
                            System.out.println("Música removida com sucesso!\n");
                            break;
                        }
                    }

                    if (!removed) {
                        System.err.println("Código não encontrado\n");
                    }
                    break;

                case 7:
                    System.out.println("Deseja limpar a lista? S/N");
                    String confirma = sc.nextLine();

                    if (confirma.equalsIgnoreCase("S")) {
                        listamidia.clear();
                        System.out.println("Lista limpa com sucesso!\n");
                    }
                    break;

                case 8:
                    int i = listamidia.size();
                    System.out.println("Quantidade de músicas: " + i + "\n");
                    break;

                default:
                    System.err.println("Opção inválida. Tente novamente.\n");
                    break;

            }
        } while (x != 9);

        sc.close();
    }
}
