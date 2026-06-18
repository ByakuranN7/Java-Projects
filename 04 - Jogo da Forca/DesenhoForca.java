public class DesenhoForca {

    private static final String MARGEM = "                    "; // 20 espaços

    private static void imprimir(String desenho) {

        for (String linha : desenho.split("\n")) {
            System.out.println(MARGEM + linha);
        }

    }

    public static void desenhar(int erros) {

        switch (erros) {

            case 0:
                imprimir("""
                        +---+
                        |   |
                            |
                            |
                            |
                            |
                        =========
                        """);
                break;

            case 1:
                imprimir("""
                        +---+
                        |   |
                        O   |
                            |
                            |
                            |
                        =========
                        """);
                break;

            case 2:
                imprimir("""
                        +---+
                        |   |
                        O   |
                        |   |
                            |
                            |
                        =========
                        """);
                break;

            case 3:
                imprimir("""
                        +---+
                        |   |
                        O   |
                       /|   |
                            |
                            |
                        =========
                        """);
                break;

            case 4:
                imprimir("""
                        +---+
                        |   |
                        O   |
                       /|\\  |
                            |
                            |
                        =========
                        """);
                break;

            case 5:
                imprimir("""
                        +---+
                        |   |
                        O   |
                       /|\\  |
                       /    |
                            |
                        =========
                        """);
                break;

            case 6:
                imprimir("""
                        +---+
                        |   |
                        O   |
                       /|\\  |
                       / \\  |
                            |
                        =========
                        """);
                break;
        }
    }
}