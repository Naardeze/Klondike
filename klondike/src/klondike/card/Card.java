package klondike.card;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

final public class Card extends JLabel {
    //card width & height
    final public static int CARD_WIDTH = 45;
    final public static int CARD_HEIGHT = 60;
    
    //suits
    public enum Suit {
        SPADES, HEARTS, CLUBS, DIAMONDS;
        //suitcolors
        public enum SuitColor {
            BLACK, RED;
        }
        
        public SuitColor getSuitColor() {
            return SuitColor.values()[ordinal() % SuitColor.values().length];
        }
    }
    
    //ranks
    public enum Rank {
        ACE, TWO ,THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING;
    }
    
    //back and face images
    final private static ImageIcon BACK = new ImageIcon("back.png");
    final private static ImageIcon[][] FACE = new ImageIcon[Suit.values().length][Rank.values().length];
    
    //suit
    final private Suit suit;
    //rank
    final private Rank rank;
    
    private Card(Suit suit, Rank rank) { 
        super(BACK);//face down by default
        
        this.suit = suit;
        this.rank = rank;
        
        setSize(CARD_WIDTH, CARD_HEIGHT);
    }    

    //returns suit
    public Suit getSuit() {
        return suit;
    }

    //returns rank
    public Rank getRank() {
        return rank;
    }

    //back or face up
    public void setFaceUp(boolean faceUp) {
        if (faceUp) {
            setIcon(FACE[suit.ordinal()][rank.ordinal()]);
        } else {
            setIcon(BACK);
        }
    }
    
    //<- 52 (4x13) unshuffled cards
    public static ArrayList<Card> getCards() {
        ArrayList<Card> cards = new ArrayList();
        
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }

        return cards;
    }
    
    //4x13 faces
    static {
        try {
            BufferedImage face = ImageIO.read(new File("face.png"));
        
            for (Suit suit : Suit.values()) {
                for (Rank rank : Rank.values()) {
                    FACE[suit.ordinal()][rank.ordinal()] = new ImageIcon(face.getSubimage(rank.ordinal() * CARD_WIDTH, suit.ordinal() * CARD_HEIGHT, CARD_WIDTH, CARD_HEIGHT));
                }
            }
        } catch (Exception ex) {}
    }
    
}
