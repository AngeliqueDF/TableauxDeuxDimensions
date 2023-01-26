import java.util.Arrays;

public class TableauVente {
    public static void main(String[] args) {
        int[][] ventes = saisieVentes();
        for (int i = 0; i < ventes.length; i++) {
            System.out.println(Arrays.toString(ventes[i]));
        }
        int[] ventesParModele = calculVentesParModele(ventes);
        for (int i = 0; i < ventesParModele.length; i++) {
            System.out.println("Modèle " + (i + 1) + " : " + ventesParModele[i] + " exemplaires vendus.");
        }
        int[] prixModeles = {1, 2, 3, 4};
        int[] caParVendeur = calculCAParVendeur(ventes, prixModeles);
        System.out.println("Chiffres d'affaires par vendeur : ");
        for (int i = 0; i < caParVendeur.length; i++) {
            System.out.println("Vendeur " + (i + 1) + " : " + caParVendeur[i]);
        }
    }

    public static int[] calculCAParVendeur(int[][] ventes, int[] prixModeles) {
        int[] caParVendeur = new int[ventes[0].length];
        for (int i = 0; i < ventes[0].length; i++) {
            for (int j = 0; j < ventes.length; j++) {
                caParVendeur[i] += ventes[j][i] * prixModeles[j];
            }
        }
        return caParVendeur;
    }

    public static int[] calculVentesParModele(int[][] ventes) {
        int[] ventesParModele = new int[ventes.length];
        for (int i = 0; i < ventes.length; i++) {
            int total = 0;
            for (int j = 0; j < ventes[0].length; j++) {
                ventesParModele[i] += ventes[i][j];
            }
        }
        return ventesParModele;
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