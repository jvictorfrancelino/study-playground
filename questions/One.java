package questions;

import java.util.*;

public class One {

    static class Pessoa {
        final String nome;
        Pessoa(String n) {
            this.nome = n;
        }
        @Override public boolean equals(Object o) {
            if (!(o instanceof Pessoa p)) return false;
            return Objects.equals(this.nome, p.nome);
        }
        @Override public int hashCode() {
            return Objects.hash(nome);
        }
    }
    static class Cliente extends Pessoa {
        Cliente(String n) {
            super(n);
        }
    }

    static class Q1 {
        public static void main(String[] args) {
            Set<Pessoa> s = new HashSet<>();
            s.add(new Pessoa("Ana"));
            s.add(new Pessoa("Ana"));
            s.add(new Cliente("Ana"));
            System.out.println(s.size());
        }
    }
}
