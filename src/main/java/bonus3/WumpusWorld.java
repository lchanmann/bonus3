package bonus3;

import aima.core.logic.propositional.kb.KnowledgeBase;

public class WumpusWorld {

    public static void main(String[] args) {
        WumpusWorld ww = new WumpusWorld();

        ww.print_7_3_a();
        ww.print_7_3_b();
        ww.print_7_4_a();
    }

    public void print_7_3_a() {
        KnowledgeBase kb = new KnowledgeBase();

        kb.tell("B11 <=> P12 | P21");
        kb.tell("OK11 <=> ~P11");
        kb.tell("OK12 <=> ~P12");
        kb.tell("OK21 <=> ~P21");

        kb.tell("OK11");
        kb.tell("~B11");

        printEntailments(kb, "OK12", "OK21");
    }

    public void print_7_3_b() {
        KnowledgeBase kb = new KnowledgeBase();

        kb.tell("B21 <=> P11 | P31 | P22");
        kb.tell("OK11 <=> ~P11");
        kb.tell("OK12 <=> ~P12");
        kb.tell("OK21 <=> ~P21");

        kb.tell("B21");
        kb.tell("OK11");

        printEntailments(kb, "P31", "P22");
    }
    
    public void print_7_4_a() {
        KnowledgeBase kb = new KnowledgeBase();

        kb.tell("S12 <=> W11 | W22 | W13");
        kb.tell("B21 <=> P11 | P31 | P22");
        kb.tell("OK11 <=> ~W11 & ~P11");
        kb.tell("OK12 <=> ~W12 & ~P12");
        kb.tell("OK21 <=> ~W21 & ~P21");
        kb.tell("OK22 <=> ~W22 & ~P22");

        kb.tell("S12");
        kb.tell("B21");
        kb.tell("OK11");
        kb.tell("OK12");
        kb.tell("OK21");
        kb.tell("OK22");

        printEntailments(kb, "W13", "OK22", "P31");
    }
    
    private void printEntailments(KnowledgeBase kb, String... queries) {
        StringBuilder sb = new StringBuilder();

        sb.append("KB: ").append(kb.toString()).append("\n");
        for (String queryString : queries) {
            boolean valid = kb.askWithTTEntails(queryString);
            boolean invalid = kb.askWithTTEntails("~" + queryString);

            sb.append("  -> ")
              .append(queryString)
              .append(" = ")
              .append(valid == invalid ? "?" : valid ? "Yes" : "No");
            sb.append("\n");
        }
        sb.append("\n");

        System.out.println(sb.toString());
    }
}
