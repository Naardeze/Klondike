package klondike.pile;

import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import klondike.card.Card;

/*
    foundation pile
*/

final public class Foundation extends Pile {

    public Foundation(String suit) {
        super(suit);
        
        setFont(getFont().deriveFont((float) Card.CARD_WIDTH));
        addContainerListener(new ContainerAdapter() {
            @Override
            public void componentAdded(ContainerEvent e) {
                e.getChild().setLocation(0, 0);
            }
        });
    }
    
    //returns the legal rank
    public Card.Rank nextRank() {
        return Card.Rank.values()[getComponentCount()];
    }

}
