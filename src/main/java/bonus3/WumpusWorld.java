package bonus3;

import aima.core.logic.propositional.kb.KnowledgeBase;

public class WumpusWorld {
    
    private KnowledgeBase kb = new KnowledgeBase();
    
    public void print_7_3_a() {
        kb.tell("B11 <=> P12 | P21");
        kb.tell("OK12 <=> ~P12");
        kb.tell("OK21 <=> ~P21");

        kb.tell("~B11");
        infer(new String[] { "OK12", "OK21" });
    }
    
    private void infer(String[] queries) {
        StringBuilder sb = new StringBuilder();

        sb.append("KB: ").append(kb.toString()).append("\n");
        for (String queryString : queries) {
            boolean valid = kb.askWithTTEntails(queryString);

            sb.append("  -> ")
              .append(queryString)
              .append(" = ")
              .append(valid ? "Yes" : "No");
            sb.append("\n");
        }
        sb.append("\n");

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        WumpusWorld ww = new WumpusWorld();
        
        ww.print_7_3_a();
    }
}
