import java.util.ArrayList;
import java.util.List;

interface Figura {
  void desenha();
  void mudaCorDeFundo(int cor);
}

class Circulo implements Figura {
  public void desenha() {
    System.out.println("Desenhando circulo");
  }

  public void mudaCorDeFundo(int cor) {
    System.out.println("Mudando para cor do circulo " + cor);
  }
}

class Triangulo implements Figura {
  public void desenha() {
    System.out.println("Desenhando triangulo");
  }

  public void mudaCorDeFundo(int cor) {
    System.out.println("Mudando para cor do triangulo " + cor);
  }
}

class FiguraAgrupada implements Figura {
  private List<Figura> figuras = new ArrayList<>();

  public void adicionar(Figura fig) {
    figuras.add(fig);
  }

  public void desenha() {
    for (Figura fig : figuras) {
      fig.desenha();
    }
  }

  public void mudaCorDeFundo(int cor) {
    for (Figura fig : figuras) {
      fig.mudaCorDeFundo(cor);
    }
  }
}

class Cliente {
  void foo(Figura fig) {
    fig.desenha();
  }
}

class Main {
  public static void main(String[] args) {
    Cliente cliente = new Cliente();

    Circulo c1 = new Circulo();
    cliente.foo(c1);

    Triangulo t1 = new Triangulo();
    Triangulo t2 = new Triangulo();

    FiguraAgrupada grupo = new FiguraAgrupada();
    grupo.adicionar(c1);
    grupo.adicionar(t1);
    grupo.adicionar(t2);

    cliente.foo(grupo);
  }
}
