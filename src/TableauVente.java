public class TableauVente {
    public static void main(String[] args) {
        int[][] ventes = saisieVentes();
        for (int i = 0; i < ventes.length; i++) {
            System.out.println(Arrays.toString(ventes[i]));
        }
    }
    public static int[][] saisieVentes() {
        int[][] ventes = new int[4][5];
        for (int i = 0; i < ventes.length; i++) {
            System.out.println("Saisie des ventes du modèle " + (i + 1));
            for (int j = 0; j < ventes[0].length; j++) {
                boolean nbVentes = false;
                do {
                    System.out.println("\tEntrez les ventes du vendeur " + (j + 1));
                    int ventesModele;
                    try {
                        ventesModele = Terminal.lireInt();
                        if (ventesModele < 0)
                            System.out.println("Erreur : le nombre de ventes ne peut pas être une valeur négative.");
                        ventes[i][j] = ventesModele;
                        nbVentes = true;
                    } catch (TerminalException te) {
                        System.out.println("Erreur : les ventes doivent être une valeur numérique non nulle.");
                    }
                } while (!nbVentes);
            }
            System.out.println();
        }
        return ventes;
    }
}