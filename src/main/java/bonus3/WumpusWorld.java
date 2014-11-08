package bonus3;

import aima.core.logic.propositional.kb.KnowledgeBase;

public class WumpusWorld {

    public static void main(String[] args) {
        KnowledgeBase kb = new KnowledgeBase();
        
        kb.tell("B11 <=> P12 | P21");
        kb.tell("~B11");
        
        if (kb.askWithTTEntails("~P12")) {
            System.out.println("[1,2] = OK");
        } else {
            System.out.println("[1,2] = NO");
        }
    }
}
