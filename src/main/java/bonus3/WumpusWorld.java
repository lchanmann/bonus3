package bonus3;

import aima.core.logic.propositional.kb.KnowledgeBase;

public class WumpusWorld {
    
    public void print_7_3_a() {
        KnowledgeBase kb = new KnowledgeBase();

        kb.tell("B11 <=> P12 | P21");
        kb.tell("OK11 <=> ~P11");
        kb.tell("OK12 <=> ~P12");
        kb.tell("OK21 <=> ~P21");

        kb.tell("OK11");
        kb.tell("~B11");
        infer(kb, new String[] { "OK12", "OK21"});
    }
    
    public void print_7_3_b() {
        KnowledgeBase kb = new KnowledgeBase();

        kb.tell("B21 <=> P11 | P31 | P22");
        kb.tell("OK11 <=> ~P11");
        kb.tell("OK12 <=> ~P12");
        kb.tell("OK21 <=> ~P21");
        
        kb.tell("B21");
        kb.tell("OK11");
        infer(kb, new String[] { "P31", "P22" });
    }
    
    private void infer(KnowledgeBase kb, String[] queries) {
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

    public static void main(String[] args) {
        WumpusWorld ww = new WumpusWorld();
        
        ww.print_7_3_a();
        ww.print_7_3_b();
    }
}
