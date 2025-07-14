import java.util.ArrayList;
import java.util.Scanner;

public class Pessoa {
    private int id;
    private String nome;
    private String email;
    private int idade;

    public Pessoa(int id, String nome, String email, int idade) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.idade = idade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getIdade() {
        return idade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "ID:" + getId() + "\n" + "Nome:" + getNome() + "\n" + "Email:" + getEmail() + "\n" + "Idade:"
                + getIdade();
    }
}

class Main {
    static ArrayList<Pessoa> lista = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op;
        do {
            System.out.println("====================");
            System.out.println("Menu");
            System.out.println("====================");
            System.out.println("1-Cadastrar");
            System.out.println("2-Filtrar por ID");
            System.out.println("3-Listar todos");
            System.out.println("4-Atualizar a idade por ID");
            System.out.println("5-Remover usuário por ID");
            System.out.println("6-Sair");
            System.out.print("Digite sua opção:");
            op = sc.nextInt();
            switch (op) {
                case 1 -> cadastrar(sc);
                case 2 -> filtrar(sc);
                case 3 -> listarTodos();
                case 4 -> atualizar(sc);
                case 5 -> remover(sc);
                case 6 -> System.out.println("Programa encerrado");
                default -> System.out.println("Opção inválida");
            }
        } while (op != 6);
        sc.close();
    }

    public static void cadastrar(Scanner sc) {
        System.out.println("====================");
        System.out.println("Informações do Usuário");
        System.out.println("=====================");

        System.out.println("Digite o ID:");
        int id = sc.nextInt();
        if (id <= 0) {
            System.out.println("ID inválido");
            return;
        }
        sc.nextLine();
        System.out.println("Digite o nome:");
        String nome = sc.nextLine();
        if (nome.isEmpty() || nome.length() <= 0) {
            System.out.println("Preencha o campo");
            return;
        }
        System.out.println("Digite o email:");
        String email = sc.nextLine();
        if (email.isEmpty()) {
            System.out.println("Preencha o campo");
            return;
        } else if (!email.contains("@gmail.com")) {
            System.out.println("Email inválido. Digite um email com @gmail.com");
            return;
        }
        System.out.println("Digite a idade:");
        int idade = sc.nextInt();
        if (idade <= 0) {
            System.out.println("Idade inválida");
            return;
        }

        Pessoa pessoas = new Pessoa(id, nome, email, idade);
        lista.add(pessoas);
          System.out.println("====================");
        System.out.println("Cadastro Realizado com sucesso");
          System.out.println("====================");

    }

    public static void filtrar(Scanner sc) {
        System.out.println("====================");
        System.out.println("Filtrar por id ");
        System.out.println("=====================");

        if (lista.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado realizado");
             return;
        }
        System.out.println("Digite o ID:");
        int id = sc.nextInt();

        lista.stream().filter(p -> id == p.getId()).forEach(System.out::println);
    }

    public static void listarTodos() {
          System.out.println("====================");
        System.out.println("Listar todos os Usuários  ");
        System.out.println("=====================");
        if (lista.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado realizado");
             return;
        }
        for (Pessoa pessoa : lista) {
            System.out.println(pessoa);
            System.out.println("====================");
        }
    }

    public static void atualizar(Scanner sc) {
        System.out.println("====================");
        System.out.println("Atualizar a idade  por id  ");
        System.out.println("=====================");
        if (lista.isEmpty()) {
            System.out.println("Nenhum cadastrado realizado");
             return;
        }
        System.out.println("Digite o ID:");
        int id = sc.nextInt();
        if(id <= 0){
            System.out.println("ID inválido");
             return;
        }
        sc.nextLine();
        System.out.println("Digite a idade:");
        int idade = sc.nextInt();
        if(idade <= 0){
            System.out.println("Idade inválida");
             return;
        }
        for (Pessoa pessoa : lista) {
            if (id == pessoa.getId()) {
                pessoa.setIdade(idade);
                System.out.println("Idade  atualizada");
            }
        }
    }

    public static void remover(Scanner sc) {
        System.out.println("====================");
        System.out.println("Remover por ID ");
        System.out.println("=====================");
        if (lista.isEmpty()) {
            System.out.println("Nenhum cadastrado realizado");
        }
        System.out.println("Digite o ID");
         int id = sc.nextInt();   
     
        lista.removeIf(p -> id == p.getId());
        System.out.println("Usuário Removido com sucesso!");
    }
}