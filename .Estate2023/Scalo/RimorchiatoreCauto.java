// import java.util.Objects;

// // public class RimorchiatoreCauto implements Rimorchiatore {

// // public final int pesoMassimo;

// // public RimorchiatoreCauto(int pesoMassimo) {
// // if (pesoMassimo <= 0)
// // throw new IllegalArgumentException("Il peso massimo deve essere un valore
// positivo");
// // this.pesoMassimo = pesoMassimo;
// // }

// // @Override
// // public void sposta(int numeroNavi, Molo partenza, Molo arrivo) {
// // Objects.requireNonNull(partenza, "Il molo di partenza non può essere
// nullo");
// // Objects.requireNonNull(arrivo, "Il molo di arrivo non può essere nullo");
// // Nave salpata = partenza.salpa();
// // for (int i = 1; i < numeroNavi; i++) {
// // int pesoTotale = salpata.getPeso();
// // if (pesoTotale > pesoMassimo) {
// // arrivo.attracca(salpata);
// // pesoTotale = 0;
// // }
// // if (pesoTotale + partenza.getProssimoPeso() > pesoMassimo) {
// // salpata = partenza.salpa();
// // arrivo.attracca(salpata);
// // }
// // }
// // }

// // }

// public class RimorchiatoreCauto implements Rimorchiatore {
// private int caricoMassimo;

// public RimorchiatoreCauto(int caricoMassimo) {
// super();
// this.caricoMassimo = caricoMassimo;
// }

// @Override
// public void sposta(final int numeroNavi, Molo partenza, Molo arrivo) {
// int n = numeroNavi;
// if (n > numeroNavi) throw new IllegalArgumentException("Il numero di navi da
// spostare non può essere maggiore di " + numeroNavi);
// int viaggi = 0;
// int caricoCorrente = 0;
// Nave primaNave = partenza.salpa();
// if (primaNave != null) {
// caricoCorrente += primaNave.getPeso();
// arrivo.attracca(primaNave);
// n--;
// viaggi++;
// }

// while (n > 0 && caricoCorrente <= caricoMassimo) {
// Nave nave = partenza.salpa();
// if (nave != null) {
// if (caricoCorrente + nave.getPeso() <= caricoMassimo) {
// caricoCorrente += nave.getPeso();
// arrivo.attracca(nave);
// n--;
// } else {
// break;
// }
// } else {
// break;
// }
// }

// System.out.println("Numero di viaggi compiuti: " + viaggi);
// }
// }
