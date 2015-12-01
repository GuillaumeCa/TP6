# TP6

## 3.1 Parcours en profondeur

**Pour l'arbre de la fig 2**

1. *Préfixé* : On parcours A en premier puis B et C.
2. *Postfixé* : On parcours B et C en premier puis A.
3. *Infixé* : On parcours B puis A puis C.

## 3.2 Parcours en largeur

*Exemples de parcours en largeur sur la fig 1.*

* ``(A) (BC) (DEF) (GH)``
* ``(A) (CB) (FED) (HG)``


## 3.3 Parcours Aléatoire

### Fonction Random 1

```java
public static void parcoursAleatoire(ArbreBinaire a) {
  Random r = new Random();
  if (a != null){
    System.out.println(a.nom);
    if (r.nextInt() %2 == 0) {
      parcoursAleatoire(a.filsGauche);
      parcoursAleatoire(a.filsDroit);
    } else {
      parcoursAleatoire(a.filsDroit);
      parcoursAleatoire(a.filsGauche);
    }
  }
}
```

1. Toutes les suites commençant par d'autres sommets que ``a`` sont éliminés. On garde donc ``abdeghcf``, ``acfbdegh``,  ``acfbehgd`` et ``abegdhcf``.
2. ``acfbehgd`` et ``acfbdegh`` sont éliminés car on ne peut remonter dans un arbre.

Les valeurs possibles de l'algorithme sont donc ``abdeghcf`` et ``abegdhcf``.

### Fonction Random 2

```java
public static void parcoursAleatoire2(ArbreBinaire a) {
  Random r = new Random();
  int rr = r.nextInt()%3;
  if (a != null) {
    if (rr == 0) {
      System.out.println(a.name); parcoursAleatoire2(a.filsDroit); parcoursAleatoire2(a.filsGauche);
    } else if (rr == 1) {
      parcoursAleatoire2(a.filsDroit);  System.out.println(a.name); parcoursAleatoire2(a.filsGauche);
    } else {
      parcoursAleatoire2(a.filsDroit); parcoursAleatoire2(a.filsGauche); System.out.println(a.name);
    }
  }
}
```

1. ``abdeghcf``, ``abegdhcf`` et ``bdehgafc`` sont des sorties impossibles car les lettres autour de ``a`` correspondent à un parcours de la branche de gauche puis de la branche de droite.
2.  ``cfbdegha``, ``acfbdegh`` et ``cfbdegha``  sont des sorties impossibles car le parcours n'est pas fait de droite à gauche.
3. ``cfhgeabd`` et ``fchgdbea`` sont des sorties impossibles car un enfant et ses enfants peuvent uniquement se trouver d'un côté ou de l'autre du parent.

Les valeurs possibles de l'algorithme sont donc ``acfbehgd``,
``cfbehgda``, ``cfabehgd``, ``fcabehgd``, ``fcaehgbd``, ``cfhgebda``, ``fcehgdba``, ``fchegdba``, ``fcahgebd``.
