public class Primos {

    public static void main(String[] args) {

        int limite = 0;

        try {
            limite = verificarEntrada(args);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }

        int[] primos = retornarListaNumerosPrimos(limite);

        for (int p : primos) {

            if (p != 0) {
                System.out.print(p + " ");
            }
        }
    }

    static int verificarEntrada(String[] entrada) {

        if (entrada.length == 0) {
            throw new IllegalArgumentException("Valor não pode ser nulo");
        }

        int limite = 0;

        try {
            limite = Integer.valueOf(entrada[0]);
        } catch (NumberFormatException e) {
            System.out.println("Número inválido");
        }

        if (limite <= 0) {
            throw new IllegalArgumentException("Valor tem que ser maior do que 0");
        }

        return limite;
    }

    static int[] retornarListaNumerosPrimos(int limite) {

        int[] primos = new int[limite - 1];

        for (int i = 2, j = 0; i <= limite; i++, j++) {
            primos[j] = i;
        }

        for (int i = 0, j = 0; i < primos.length && j < primos.length; i++) {

            if (primos[j] == 0 || primos[i] == 0) {
                j++;
                continue;
            }

            if (primos[i] % primos[j] == 0) {
                if (primos[i] != primos[j]) {
                    primos[i] = 0;
                }
            }

            if (i == primos.length - 1) {
                i = -1;
                j++;
            }
        }

        return primos;

    }
}