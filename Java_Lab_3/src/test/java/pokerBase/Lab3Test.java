package pokerBase;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import pokerEnums.eCardNo;
import pokerEnums.eHandStrength;
import pokerEnums.eRank;
import pokerEnums.eSuit;

public class Lab3Test {

	@Test
	public void BestHandEval_Test_HighCardWild() {
		Deck my_deck = new Deck();
		Hand my_hand = new Hand();
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		my_hand.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.KING,0));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.THREE,true));
		my_hand.AddCardToHand(new Card(eSuit.HEARTS,eRank.TWO,0));
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.ACE,0));
		
		assertTrue(Hand.BestHandEval(my_hand).getHandStrength() == eHandStrength.Pair.getHandStrength());
	}
	@Test
	public void BestHandEval_Test_HighCardJoker() {
		Deck my_deck = new Deck();
		Hand my_hand = new Hand();
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		my_hand.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.KING,0));
		my_hand.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		my_hand.AddCardToHand(new Card(eSuit.HEARTS,eRank.TWO,0));
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.ACE,0));
		
		assertTrue(Hand.BestHandEval(my_hand).getHandStrength() == eHandStrength.Pair.getHandStrength());
	}
	@Test
	public void BestHandEval_Test_PairWild() {
		Deck my_deck = new Deck();
		Hand my_hand = new Hand();
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		my_hand.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.KING,0));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		my_hand.AddCardToHand(new Card(eSuit.HEARTS,eRank.TWO,true));
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.ACE,0));
		
		assertTrue(Hand.BestHandEval(my_hand).getHandStrength() == eHandStrength.ThreeOfAKind.getHandStrength());
	}
	@Test
	public void BestHandEval_Test_PairJoker() {
		Deck my_deck = new Deck();
		Hand my_hand = new Hand();
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		my_hand.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		my_hand.AddCardToHand(new Card(eSuit.HEARTS,eRank.TWO,0));
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.ACE,0));
		
		assertTrue(Hand.BestHandEval(my_hand).getHandStrength() == eHandStrength.ThreeOfAKind.getHandStrength());
		assertTrue(Hand.BestHandEval(my_hand).getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(Hand.BestHandEval(my_hand).getLowPairStrength() == 0);
		
	}
	@Test
	public void BestHandEval_Test_TwoPairWild() {
		Deck my_deck = new Deck();
		Hand my_hand = new Hand();
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		my_hand.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.KING,0));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		my_hand.AddCardToHand(new Card(eSuit.HEARTS,eRank.TWO,true));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.KING,0));
		
		assertTrue(Hand.BestHandEval(my_hand).getHandStrength() == eHandStrength.FullHouse.getHandStrength());
		assertTrue(Hand.BestHandEval(my_hand).getHighPairStrength() == eRank.KING.getRank());
		assertTrue(Hand.BestHandEval(my_hand).getLowPairStrength() == eRank.TEN.getRank());
	}
	@Test
	public void BestHandEval_Test_TwoPairJOKER() {
		Deck my_deck = new Deck();
		Hand my_hand = new Hand();
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		my_hand.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.KING,0));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		my_hand.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.KING,0));
		
		assertTrue(Hand.BestHandEval(my_hand).getHandStrength() == eHandStrength.FullHouse.getHandStrength());
		assertTrue(Hand.BestHandEval(my_hand).getHighPairStrength() == eRank.KING.getRank());
		assertTrue(Hand.BestHandEval(my_hand).getLowPairStrength() == eRank.TEN.getRank());
	}
	@Test
	public void BestHandEval_Test_ThreeOfAKindWild() {
		Deck my_deck = new Deck();
		Hand my_hand = new Hand();
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		my_hand.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.KING,0));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		my_hand.AddCardToHand(new Card(eSuit.HEARTS,eRank.KING,true));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		
		assertTrue(Hand.BestHandEval(my_hand).getHandStrength() == eHandStrength.FourOfAKind.getHandStrength());
		assertTrue(Hand.BestHandEval(my_hand).getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(Hand.BestHandEval(my_hand).getLowPairStrength() == 0);
}
	@Test
	public void BestHandEval_Test_ThreeOfAKindJoker() {
		Deck my_deck = new Deck();
		Hand my_hand = new Hand();
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		my_hand.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.KING,0));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		my_hand.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		
		assertTrue(Hand.BestHandEval(my_hand).getHandStrength() == eHandStrength.FourOfAKind.getHandStrength());
		assertTrue(Hand.BestHandEval(my_hand).getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(Hand.BestHandEval(my_hand).getLowPairStrength() == 0);
}
	@Test
	public void BestHandEval_Test_FullHouseWILD_1() {
		Deck my_deck = new Deck();
		Hand my_hand = new Hand();
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		my_hand.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.KING,0));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		my_hand.AddCardToHand(new Card(eSuit.HEARTS,eRank.TEN,true));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.KING,0));
		
		assertTrue(Hand.BestHandEval(my_hand).getHandStrength() == eHandStrength.FullHouse.getHandStrength());
		assertTrue(Hand.BestHandEval(my_hand).getHighPairStrength() == eRank.KING.getRank());
		assertTrue(Hand.BestHandEval(my_hand).getLowPairStrength() == eRank.TEN.getRank());
}
	@Test
	public void BestHandEval_Test_FullHouseWILD_2() {
		Deck my_deck = new Deck();
		Hand my_hand = new Hand();
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		my_hand.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.KING,true));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		my_hand.AddCardToHand(new Card(eSuit.HEARTS,eRank.TEN,0));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.KING,0));
		
		assertTrue(Hand.BestHandEval(my_hand).getHandStrength() == eHandStrength.FourOfAKind.getHandStrength());
		assertTrue(Hand.BestHandEval(my_hand).getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(Hand.BestHandEval(my_hand).getLowPairStrength() == 0);
}
	@Test
	public void BestHandEval_Test_FullHouseWILD_3() {
		Deck my_deck = new Deck();
		Hand my_hand = new Hand();
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		my_hand.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.KING,true));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		my_hand.AddCardToHand(new Card(eSuit.HEARTS,eRank.TEN,0));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.KING,true));
		
		assertTrue(Hand.BestHandEval(my_hand).getHandStrength() == eHandStrength.FiveOfAKind.getHandStrength());
		assertTrue(Hand.BestHandEval(my_hand).getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(Hand.BestHandEval(my_hand).getLowPairStrength() == 0);
}
	@Test
	public void BestHandEval_Test_FourOfAKindWILD_1() {
		Deck my_deck = new Deck();
		Hand my_hand = new Hand();
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		my_hand.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.TEN,true));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		my_hand.AddCardToHand(new Card(eSuit.HEARTS,eRank.TEN,0));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.KING,0));
		
		assertTrue(Hand.BestHandEval(my_hand).getHandStrength() == eHandStrength.FourOfAKind.getHandStrength());
		assertTrue(Hand.BestHandEval(my_hand).getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(Hand.BestHandEval(my_hand).getLowPairStrength() == 0);
}
	@Test
	public void BestHandEval_Test_FourOfAKindWILD_2() {
		Deck my_deck = new Deck();
		Hand my_hand = new Hand();
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		my_hand.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.KING,true));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		my_hand.AddCardToHand(new Card(eSuit.HEARTS,eRank.TEN,0));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		
		assertTrue(Hand.BestHandEval(my_hand).getHandStrength() == eHandStrength.FiveOfAKind.getHandStrength());
		assertTrue(Hand.BestHandEval(my_hand).getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(Hand.BestHandEval(my_hand).getLowPairStrength() == 0);
}
	@Test
	public void BestHandEval_Test_FourOfAKindJOKER() {
		Deck my_deck = new Deck();
		Hand my_hand = new Hand();
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		my_hand.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		my_hand.AddCardToHand(new Card(eSuit.HEARTS,eRank.TEN,0));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		
		assertTrue(Hand.BestHandEval(my_hand).getHandStrength() == eHandStrength.FiveOfAKind.getHandStrength());
		assertTrue(Hand.BestHandEval(my_hand).getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(Hand.BestHandEval(my_hand).getLowPairStrength() == 0);
	}
	@Test
	public void BestHandEval_Test_StraightLowJOKER() {
		Deck my_deck = new Deck();
		Hand my_hand = new Hand();
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.TWO,0));
		my_hand.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.THREE,0));
		my_hand.AddCardToHand(new Card(eSuit.HEARTS,eRank.FOUR,0));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.SIX,0));
		
		assertTrue(Hand.BestHandEval(my_hand).getHandStrength() == eHandStrength.Straight.getHandStrength());
		assertTrue(Hand.BestHandEval(my_hand).getHighPairStrength() == eRank.SIX.getRank());
		assertTrue(Hand.BestHandEval(my_hand).getLowPairStrength() == 0);
	
	}
	@Test
	public void BestHandEval_Test_StraightHighJOKER() {
		Deck my_deck = new Deck();
		Hand my_hand = new Hand();
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.TWO,0));
		my_hand.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,true));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.THREE,0));
		my_hand.AddCardToHand(new Card(eSuit.HEARTS,eRank.FOUR,0));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.FIVE,0));
		
		assertTrue(Hand.BestHandEval(my_hand).getHandStrength() == eHandStrength.Straight.getHandStrength());
		assertTrue(Hand.BestHandEval(my_hand).getHighPairStrength() == eRank.SIX.getRank());
		assertTrue(Hand.BestHandEval(my_hand).getLowPairStrength() == 0);
	}
	@Test
	public void BestHandEval_Test_StraightRegJOKER() {
		Deck my_deck = new Deck();
		Hand my_hand = new Hand();
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.SIX,0));
		my_hand.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,true));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.THREE,0));
		my_hand.AddCardToHand(new Card(eSuit.HEARTS,eRank.FOUR,0));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.FIVE,0));
		
		assertTrue(Hand.BestHandEval(my_hand).getHandStrength() == eHandStrength.Straight.getHandStrength());
		assertTrue(Hand.BestHandEval(my_hand).getHighPairStrength() == eRank.SEVEN.getRank());
		assertTrue(Hand.BestHandEval(my_hand).getLowPairStrength() == 0);
	}
	@Test
	public void BestHandEval_Test_StraightLowWild() {
		Deck my_deck = new Deck();
		Hand my_hand = new Hand();
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.TWO,0));
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.EIGHT,true));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.THREE,0));
		my_hand.AddCardToHand(new Card(eSuit.HEARTS,eRank.FOUR,0));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.SIX,0));
		
		assertTrue(Hand.BestHandEval(my_hand).getHandStrength() == eHandStrength.Straight.getHandStrength());
		assertTrue(Hand.BestHandEval(my_hand).getHighPairStrength() == eRank.SIX.getRank());
		assertTrue(Hand.BestHandEval(my_hand).getLowPairStrength() == 0);
	
	}
	@Test
	public void BestHandEval_Test_StraightHighWild() {
		Deck my_deck = new Deck();
		Hand my_hand = new Hand();
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.TWO,0));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,true));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.THREE,0));
		my_hand.AddCardToHand(new Card(eSuit.HEARTS,eRank.FOUR,0));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.FIVE,0));
		
		assertTrue(Hand.BestHandEval(my_hand).getHandStrength() == eHandStrength.Straight.getHandStrength());
		assertTrue(Hand.BestHandEval(my_hand).getHighPairStrength() == eRank.SIX.getRank());
		assertTrue(Hand.BestHandEval(my_hand).getLowPairStrength() == 0);
	}
	@Test
	public void BestHandEval_Test_StraightRegWild() {
		Deck my_deck = new Deck();
		Hand my_hand = new Hand();
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.SIX,0));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,true));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.THREE,0));
		my_hand.AddCardToHand(new Card(eSuit.HEARTS,eRank.FOUR,0));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.FIVE,0));
		
		assertTrue(Hand.BestHandEval(my_hand).getHandStrength() == eHandStrength.Straight.getHandStrength());
		assertTrue(Hand.BestHandEval(my_hand).getHighPairStrength() == eRank.SEVEN.getRank());
		assertTrue(Hand.BestHandEval(my_hand).getLowPairStrength() == 0);
	}

	
	@Test
	public void BestHandEval_Test_Flush_1() {
		Deck my_deck = new Deck();
		Hand my_hand = new Hand();
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.KING,0));
		my_hand.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.JACK,0));
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.QUEEN,0));
		assertTrue(Hand.BestHandEval(my_hand).getHandStrength() == eHandStrength.RoyalFlush.getHandStrength());
		assertTrue(Hand.BestHandEval(my_hand).getHighPairStrength() == 0);
		assertTrue(Hand.BestHandEval(my_hand).getLowPairStrength() == 0);
		assertTrue(Hand.BestHandEval(my_hand).isNatural() == 1);
	}
	@Test
	public void BestHandEval_Test_StaightFlush_1() {
		Deck my_deck = new Deck();
		Hand my_hand = new Hand();
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.NINE,0));
		my_hand.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.JACK,0));
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.QUEEN,0));

		assertTrue(Hand.BestHandEval(my_hand).getHandStrength() == eHandStrength.StraightFlush.getHandStrength());
		assertTrue(Hand.BestHandEval(my_hand).getHighPairStrength() == eRank.KING.getRank());
		assertTrue(Hand.BestHandEval(my_hand).getLowPairStrength() == 0);
	}
	@Test
	public void BestHandEval_Test_StaightFlush_Wild() {
		Deck my_deck = new Deck();
		Hand my_hand = new Hand();
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.NINE,0));
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.TWO,true));
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.JACK,0));
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.QUEEN,0));

		assertTrue(Hand.BestHandEval(my_hand).getHandStrength() == eHandStrength.StraightFlush.getHandStrength());
		assertTrue(Hand.BestHandEval(my_hand).getHighPairStrength() == eRank.KING.getRank());
		assertTrue(Hand.BestHandEval(my_hand).getLowPairStrength() == 0);
	}
	@Test
	public void BestHandEval_Test_StaightFlush_2() {
		Deck my_deck = new Deck();
		Hand my_hand = new Hand();
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.NINE,0));
		my_hand.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.EIGHT,0));
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.QUEEN,0));

		assertTrue(Hand.BestHandEval(my_hand).getHandStrength() == eHandStrength.StraightFlush.getHandStrength());
		assertTrue(Hand.BestHandEval(my_hand).getHighPairStrength() == eRank.QUEEN.getRank());
		assertTrue(Hand.BestHandEval(my_hand).getLowPairStrength() == 0);
	}
	@Test
	public void BestHandEval_Test_Jokers3() {
		Deck my_deck = new Deck();
		Hand my_hand = new Hand();
		my_hand.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		my_hand.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.JACK,0));
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		my_hand.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));

		assertTrue(Hand.BestHandEval(my_hand).getHandStrength() == eHandStrength.RoyalFlush.getHandStrength());
		assertTrue(Hand.BestHandEval(my_hand).getHighPairStrength() == 0);
		assertTrue(Hand.BestHandEval(my_hand).getLowPairStrength() == 0);
	}
	//Test these at your own risk
	
	/*@Test
	public void BestHandEval_Test_Jokers4() {
		Deck my_deck = new Deck();
		Hand my_hand = new Hand();
		my_hand.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		my_hand.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		my_hand.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		my_hand.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		System.out.println(Hand.BestHandEval(my_hand).isNatural());
		assertTrue(Hand.BestHandEval(my_hand).getHandStrength() == eHandStrength.FiveOfAKind.getHandStrength());
		assertTrue(Hand.BestHandEval(my_hand).getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(Hand.BestHandEval(my_hand).getLowPairStrength() == 0);
	}*/
	
	/*@Test
	public void BestHandEval_Test_Jokers5() {
		Deck my_deck = new Deck();
		Hand my_hand = new Hand();
		my_hand.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		my_hand.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		my_hand.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		my_hand.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		my_hand.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		System.out.println(Hand.BestHandEval(my_hand).isNatural());
		assertTrue(Hand.BestHandEval(my_hand).getHandStrength() == eHandStrength.FiveOfAKind.getHandStrength());
		assertTrue(Hand.BestHandEval(my_hand).getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(Hand.BestHandEval(my_hand).getLowPairStrength() == 0);
	}*/

	@Test
	public void CompareTwoHands4ofaKind() {
		Deck d = new Deck();
		Hand h1 = new Hand();
		h1.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.HEARTS,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.CLUBS,eRank.ACE,0));
		Hand.BestHandEval(h1);
		
		Hand h2 = new Hand();
		h2.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h2.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		h2.AddCardToHand(new Card(eSuit.HEARTS,eRank.TEN,0));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.ACE,0));
		Hand.BestHandEval(h2);	
		
		ArrayList<Hand> TwoHands = new ArrayList<Hand>();
		TwoHands.add(h1);
		TwoHands.add(h2);
		Collections.sort(TwoHands,Hand.HandRank);
		
		Hand winningHand = new Hand();
		Hand losingHand = new Hand();
		winningHand = TwoHands.get(0);
		losingHand = TwoHands.get(1);
		assertTrue(winningHand.isNatural() == 1);
		assertTrue(losingHand.getIsNatural() ==0);
		
	}
	@Test
	public void CompareTwoHands4ofaKindWild() {
		Deck d = new Deck();
		Hand h1 = new Hand();
		h1.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.HEARTS,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.CLUBS,eRank.ACE,0));
		Hand.BestHandEval(h1);
		
		Hand h2 = new Hand();
		h2.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h2.AddCardToHand(new Card(eSuit.CLUBS,eRank.TWO,true));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		h2.AddCardToHand(new Card(eSuit.HEARTS,eRank.TEN,0));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.ACE,0));
		Hand.BestHandEval(h2);	
		
		ArrayList<Hand> TwoHands = new ArrayList<Hand>();
		TwoHands.add(h1);
		TwoHands.add(h2);
		Collections.sort(TwoHands,Hand.HandRank);
		
		Hand winningHand = new Hand();
		Hand losingHand = new Hand();
		winningHand = TwoHands.get(0);
		losingHand = TwoHands.get(1);
		assertTrue(winningHand.isNatural() == 1);
		assertTrue(losingHand.getIsNatural() ==0);
		
	}
	@Test
	public void CompareTwoHands5ofaKind() {
		Deck d = new Deck();
		Hand h1 = new Hand();
		h1.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.HEARTS,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		Hand.BestHandEval(h1);
		
		Hand h2 = new Hand();
		h2.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h2.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		h2.AddCardToHand(new Card(eSuit.HEARTS,eRank.TEN,0));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		Hand.BestHandEval(h2);	
		
		ArrayList<Hand> TwoHands = new ArrayList<Hand>();
		TwoHands.add(h1);
		TwoHands.add(h2);
		Collections.sort(TwoHands,Hand.HandRank);
		
		Hand winningHand = new Hand();
		Hand losingHand = new Hand();
		winningHand = TwoHands.get(0);
		losingHand = TwoHands.get(1);
		assertTrue(winningHand.isNatural() == 1);
		assertTrue(losingHand.getIsNatural() ==0);
		
	}
	@Test
	public void CompareTwoHands5ofaKindWild() {
		Deck d = new Deck();
		Hand h1 = new Hand();
		h1.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.HEARTS,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		Hand.BestHandEval(h1);
		
		Hand h2 = new Hand();
		h2.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h2.AddCardToHand(new Card(eSuit.CLUBS,eRank.TWO,true));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		h2.AddCardToHand(new Card(eSuit.HEARTS,eRank.TEN,0));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		Hand.BestHandEval(h2);	
		
		ArrayList<Hand> TwoHands = new ArrayList<Hand>();
		TwoHands.add(h1);
		TwoHands.add(h2);
		Collections.sort(TwoHands,Hand.HandRank);
		
		Hand winningHand = new Hand();
		Hand losingHand = new Hand();
		winningHand = TwoHands.get(0);
		losingHand = TwoHands.get(1);
		assertTrue(winningHand.isNatural() == 1);
		assertTrue(losingHand.getIsNatural() ==0);
		
	}
	@Test
	public void CompareTwoHandsRoyalFlush() {
		Deck d = new Deck();
		Hand h1 = new Hand();
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.JACK,0));
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.QUEEN,0));
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.KING,0));
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.ACE,0));
		Hand.BestHandEval(h1);
		
		Hand h2 = new Hand();
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		h2.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.QUEEN,0));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.KING,0));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.ACE,0));
		Hand.BestHandEval(h2);	
		
		ArrayList<Hand> TwoHands = new ArrayList<Hand>();
		TwoHands.add(h1);
		TwoHands.add(h2);
		Collections.sort(TwoHands,Hand.HandRank);
		
		Hand winningHand = new Hand();
		Hand losingHand = new Hand();
		winningHand = TwoHands.get(0);
		losingHand = TwoHands.get(1);
		assertTrue(winningHand.getHandStrength() == eHandStrength.RoyalFlush.getHandStrength());
		assertTrue(winningHand.isNatural() == 1);
		assertTrue(losingHand.isNatural() ==0);
		
	}
	@Test
	public void CompareTwoHandsRoyalFlushWild() {
		Deck d = new Deck();
		Hand h1 = new Hand();
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.JACK,0));
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.QUEEN,0));
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.KING,0));
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.ACE,0));
		Hand.BestHandEval(h1);
		
		Hand h2 = new Hand();
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		h2.AddCardToHand(new Card(eSuit.CLUBS,eRank.TWO,true));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.QUEEN,0));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.KING,0));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.ACE,0));
		Hand.BestHandEval(h2);	
		
		ArrayList<Hand> TwoHands = new ArrayList<Hand>();
		TwoHands.add(h1);
		TwoHands.add(h2);
		Collections.sort(TwoHands,Hand.HandRank);
		
		Hand winningHand = new Hand();
		Hand losingHand = new Hand();
		winningHand = TwoHands.get(0);
		losingHand = TwoHands.get(1);
		assertTrue(winningHand.getHandStrength() == eHandStrength.RoyalFlush.getHandStrength());
		assertTrue(winningHand.isNatural() == 1);
		assertTrue(losingHand.isNatural() ==0);
		
	}
	@Test
	public void CompareTwoHandsStraightFlush() {
		Deck d = new Deck();
		Hand h1 = new Hand();
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.JACK,0));
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.QUEEN,0));
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.KING,0));
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.NINE,0));
		Hand.BestHandEval(h1);
		
		Hand h2 = new Hand();
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		h2.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.QUEEN,0));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.KING,0));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.NINE,0));
		Hand.BestHandEval(h2);	
		
		ArrayList<Hand> TwoHands = new ArrayList<Hand>();
		TwoHands.add(h1);
		TwoHands.add(h2);
		Collections.sort(TwoHands,Hand.HandRank);
		
		Hand winningHand = new Hand();
		Hand losingHand = new Hand();
		winningHand = TwoHands.get(0);
		losingHand = TwoHands.get(1);
		assertTrue(winningHand.getHandStrength() == eHandStrength.StraightFlush.getHandStrength());
		assertTrue(winningHand.isNatural() == 1);
		assertTrue(losingHand.getIsNatural() ==0);
		
	}
	@Test
	public void CompareTwoHandsStraightFlushWild() {
		Deck d = new Deck();
		Hand h1 = new Hand();
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.JACK,0));
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.QUEEN,0));
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.KING,0));
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.NINE,0));
		Hand.BestHandEval(h1);
		
		Hand h2 = new Hand();
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		h2.AddCardToHand(new Card(eSuit.CLUBS,eRank.TWO,true));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.QUEEN,0));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.KING,0));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.NINE,0));
		Hand.BestHandEval(h2);	
		
		ArrayList<Hand> TwoHands = new ArrayList<Hand>();
		TwoHands.add(h1);
		TwoHands.add(h2);
		Collections.sort(TwoHands,Hand.HandRank);
		
		Hand winningHand = new Hand();
		Hand losingHand = new Hand();
		winningHand = TwoHands.get(0);
		losingHand = TwoHands.get(1);
		assertTrue(winningHand.getHandStrength() == eHandStrength.StraightFlush.getHandStrength());
		assertTrue(winningHand.isNatural() == 1);
		assertTrue(losingHand.getIsNatural() ==0);
		
	}
	@Test
	public void CompareTwoHandsFlush() {
		Deck d = new Deck();
		Hand h1 = new Hand();
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.THREE,0));
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.QUEEN,0));
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.KING,0));
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.ACE,0));
		Hand.BestHandEval(h1);
		
		Hand h2 = new Hand();
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		h2.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.QUEEN,0));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.THREE,0));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.ACE,0));
		Hand.BestHandEval(h2);	
		
		ArrayList<Hand> TwoHands = new ArrayList<Hand>();
		TwoHands.add(h1);
		TwoHands.add(h2);
		Collections.sort(TwoHands,Hand.HandRank);
		
		Hand winningHand = new Hand();
		Hand losingHand = new Hand();
		winningHand = TwoHands.get(0);
		losingHand = TwoHands.get(1);
		assertTrue(winningHand.getHandStrength() == eHandStrength.Flush.getHandStrength());
		assertTrue(winningHand.isNatural() == 1);
		assertTrue(losingHand.isNatural() ==0);
		
	}
	@Test
	public void CompareTwoHandsFlushWild() {
		Deck d = new Deck();
		Hand h1 = new Hand();
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.THREE,0));
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.QUEEN,0));
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.KING,0));
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.ACE,0));
		Hand.BestHandEval(h1);
		
		Hand h2 = new Hand();
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		h2.AddCardToHand(new Card(eSuit.CLUBS,eRank.TWO,true));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.QUEEN,0));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.THREE,0));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.ACE,0));
		Hand.BestHandEval(h2);	
		
		ArrayList<Hand> TwoHands = new ArrayList<Hand>();
		TwoHands.add(h1);
		TwoHands.add(h2);
		Collections.sort(TwoHands,Hand.HandRank);
		
		Hand winningHand = new Hand();
		Hand losingHand = new Hand();
		winningHand = TwoHands.get(0);
		losingHand = TwoHands.get(1);
		assertTrue(winningHand.getHandStrength() == eHandStrength.Flush.getHandStrength());
		assertTrue(winningHand.isNatural() == 1);
		assertTrue(losingHand.isNatural() ==0);
		
	}
	
	@Test
	public void CompareTwoHandsStraight() {
		Deck d = new Deck();
		Hand h1 = new Hand();
		h1.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.NINE,0));
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.JACK,0));
		h1.AddCardToHand(new Card(eSuit.HEARTS,eRank.EIGHT,0));
		h1.AddCardToHand(new Card(eSuit.CLUBS,eRank.SEVEN,0));
		Hand.BestHandEval(h1);
		
		Hand h2 = new Hand();
		h2.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h2.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.JACK,0));
		h2.AddCardToHand(new Card(eSuit.HEARTS,eRank.EIGHT,0));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.SEVEN,0));
		Hand.BestHandEval(h2);	
		
		ArrayList<Hand> TwoHands = new ArrayList<Hand>();
		TwoHands.add(h1);
		TwoHands.add(h2);
		Collections.sort(TwoHands,Hand.HandRank);
		
		Hand winningHand = new Hand();
		Hand losingHand = new Hand();
		winningHand = TwoHands.get(0);
		losingHand = TwoHands.get(1);
		assertTrue(winningHand.getHandStrength() == eHandStrength.Straight.getHandStrength());
		assertTrue(winningHand.isNatural() == 1);
		assertTrue(losingHand.getIsNatural() ==0);
		
	}
	@Test
	public void CompareTwoHandsStraightWild() {
		Deck d = new Deck();
		Hand h1 = new Hand();
		h1.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.NINE,0));
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.JACK,0));
		h1.AddCardToHand(new Card(eSuit.HEARTS,eRank.EIGHT,0));
		h1.AddCardToHand(new Card(eSuit.CLUBS,eRank.SEVEN,0));
		Hand.BestHandEval(h1);
		
		Hand h2 = new Hand();
		h2.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h2.AddCardToHand(new Card(eSuit.CLUBS,eRank.TWO,true));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.JACK,0));
		h2.AddCardToHand(new Card(eSuit.HEARTS,eRank.EIGHT,0));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.SEVEN,0));
		Hand.BestHandEval(h2);	
		
		ArrayList<Hand> TwoHands = new ArrayList<Hand>();
		TwoHands.add(h1);
		TwoHands.add(h2);
		Collections.sort(TwoHands,Hand.HandRank);
		
		Hand winningHand = new Hand();
		Hand losingHand = new Hand();
		winningHand = TwoHands.get(0);
		losingHand = TwoHands.get(1);
		assertTrue(winningHand.getHandStrength() == eHandStrength.Straight.getHandStrength());
		assertTrue(winningHand.isNatural() == 1);
		assertTrue(losingHand.getIsNatural() ==0);
		
	}
	@Test
	public void CompareTwoHandsFullHouse() {
		Deck d = new Deck();
		Hand h1 = new Hand();
		h1.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.HEARTS,eRank.EIGHT,0));
		h1.AddCardToHand(new Card(eSuit.CLUBS,eRank.EIGHT,0));
		Hand.BestHandEval(h1);
		
		Hand h2 = new Hand();
		h2.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h2.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		h2.AddCardToHand(new Card(eSuit.HEARTS,eRank.EIGHT,0));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.EIGHT,0));	
		Hand.BestHandEval(h2);
		
		ArrayList<Hand> TwoHands = new ArrayList<Hand>();
		TwoHands.add(Hand.BestHandEval(h2));
		TwoHands.add(Hand.BestHandEval(h1));
		Collections.sort(TwoHands,Hand.HandRank);
		
		Hand winningHand = TwoHands.get(0);
		Hand losingHand = TwoHands.get(1);
		assertTrue(winningHand.getHandStrength() == eHandStrength.FullHouse.getHandStrength());
		assertTrue(winningHand.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(losingHand.getHandStrength() == eHandStrength.FullHouse.getHandStrength());
		assertTrue(losingHand.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h1.isNatural() == 1);
		assertTrue(h2.isNatural() == 0);
	
	}
	@Test
	public void CompareTwoHandsFullHouseWild() {
		Deck d = new Deck();
		Hand h1 = new Hand();
		h1.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.HEARTS,eRank.EIGHT,0));
		h1.AddCardToHand(new Card(eSuit.CLUBS,eRank.EIGHT,0));
		Hand.BestHandEval(h1);
		
		Hand h2 = new Hand();
		h2.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h2.AddCardToHand(new Card(eSuit.CLUBS,eRank.TWO,true));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.TEN,0));
		h2.AddCardToHand(new Card(eSuit.HEARTS,eRank.EIGHT,0));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.EIGHT,0));	
		Hand.BestHandEval(h2);
		
		ArrayList<Hand> TwoHands = new ArrayList<Hand>();
		TwoHands.add(Hand.BestHandEval(h2));
		TwoHands.add(Hand.BestHandEval(h1));
		Collections.sort(TwoHands,Hand.HandRank);
		
		Hand winningHand = TwoHands.get(0);
		Hand losingHand = TwoHands.get(1);
		assertTrue(winningHand.getHandStrength() == eHandStrength.FullHouse.getHandStrength());
		assertTrue(winningHand.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(losingHand.getHandStrength() == eHandStrength.FullHouse.getHandStrength());
		assertTrue(losingHand.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h1.isNatural() == 1);
		assertTrue(h2.isNatural() == 0);
	
	}
	@Test
	public void CompareTwoHands3ofaKind() {
		Deck d = new Deck();
		Hand h1 = new Hand();
		h1.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.TWO,0));
		h1.AddCardToHand(new Card(eSuit.HEARTS,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.CLUBS,eRank.EIGHT,0));
		Hand.BestHandEval(h1);
		
		Hand h2 = new Hand();
		h2.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h2.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.TWO,0));
		h2.AddCardToHand(new Card(eSuit.HEARTS,eRank.TEN,0));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.EIGHT,0));	
		Hand.BestHandEval(h2);
		
		ArrayList<Hand> TwoHands = new ArrayList<Hand>();
		TwoHands.add(Hand.BestHandEval(h2));
		TwoHands.add(Hand.BestHandEval(h1));
		Collections.sort(TwoHands,Hand.HandRank);
		
		Hand winningHand = TwoHands.get(0);
		Hand losingHand = TwoHands.get(1);
		assertTrue(winningHand.getHandStrength() == eHandStrength.ThreeOfAKind.getHandStrength());
		assertTrue(winningHand.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(losingHand.getHandStrength() == eHandStrength.ThreeOfAKind.getHandStrength());
		assertTrue(losingHand.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h1.isNatural() == 1);
		assertTrue(h2.isNatural() == 0);
	
	}
	@Test
	public void CompareTwoHands3ofaKindWild() {
		Deck d = new Deck();
		Hand h1 = new Hand();
		h1.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.TWO,0));
		h1.AddCardToHand(new Card(eSuit.HEARTS,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.CLUBS,eRank.EIGHT,0));
		Hand.BestHandEval(h1);
		
		Hand h2 = new Hand();
		h2.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.THREE,true));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.TWO,0));
		h2.AddCardToHand(new Card(eSuit.HEARTS,eRank.TEN,0));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.EIGHT,0));	
		Hand.BestHandEval(h2);
		
		ArrayList<Hand> TwoHands = new ArrayList<Hand>();
		TwoHands.add(Hand.BestHandEval(h2));
		TwoHands.add(Hand.BestHandEval(h1));
		Collections.sort(TwoHands,Hand.HandRank);
		
		Hand winningHand = TwoHands.get(0);
		Hand losingHand = TwoHands.get(1);
		assertTrue(winningHand.getHandStrength() == eHandStrength.ThreeOfAKind.getHandStrength());
		assertTrue(winningHand.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(losingHand.getHandStrength() == eHandStrength.ThreeOfAKind.getHandStrength());
		assertTrue(losingHand.getHighPairStrength() == eRank.TEN.getRank());
		assertTrue(h1.isNatural() == 1);
		assertTrue(h2.isNatural() == 0);
	
	}
	@Test
	public void CompareTwoHandsPair() {
		Deck d = new Deck();
		Hand h1 = new Hand();
		h1.AddCardToHand(new Card(eSuit.CLUBS,eRank.ACE,0));
		h1.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.TWO,0));
		h1.AddCardToHand(new Card(eSuit.HEARTS,eRank.ACE,0));
		h1.AddCardToHand(new Card(eSuit.CLUBS,eRank.EIGHT,0));
		Hand.BestHandEval(h1);
		
		Hand h2 = new Hand();
		h2.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h2.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.TWO,0));
		h2.AddCardToHand(new Card(eSuit.HEARTS,eRank.ACE,0));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.EIGHT,0));	
		Hand.BestHandEval(h2);
		
		ArrayList<Hand> TwoHands = new ArrayList<Hand>();
		TwoHands.add(Hand.BestHandEval(h2));
		TwoHands.add(Hand.BestHandEval(h1));
		Collections.sort(TwoHands,Hand.HandRank);
		
		Hand winningHand = TwoHands.get(0);
		Hand losingHand = TwoHands.get(1);
		assertTrue(winningHand.getHandStrength() == eHandStrength.Pair.getHandStrength());
		assertTrue(winningHand.getHighPairStrength() == eRank.ACE.getRank());
		assertTrue(losingHand.getHandStrength() == eHandStrength.Pair.getHandStrength());
		assertTrue(losingHand.getHighPairStrength() == eRank.ACE.getRank());
		assertTrue(h1.isNatural() == 1);
		assertTrue(h2.isNatural() == 0);
	
	}
	@Test
	public void CompareTwoHandsPairWild() {
		Deck d = new Deck();
		Hand h1 = new Hand();
		h1.AddCardToHand(new Card(eSuit.CLUBS,eRank.ACE,0));
		h1.AddCardToHand(new Card(eSuit.DIAMONDS,eRank.TEN,0));
		h1.AddCardToHand(new Card(eSuit.SPADES,eRank.TWO,0));
		h1.AddCardToHand(new Card(eSuit.HEARTS,eRank.ACE,0));
		h1.AddCardToHand(new Card(eSuit.CLUBS,eRank.EIGHT,0));
		Hand.BestHandEval(h1);
		
		Hand h2 = new Hand();
		h2.AddCardToHand(new Card(eSuit.CLUBS,eRank.TEN,0));
		h2.AddCardToHand(new Card(eSuit.CLUBS,eRank.THREE,true));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.TWO,0));
		h2.AddCardToHand(new Card(eSuit.HEARTS,eRank.ACE,0));
		h2.AddCardToHand(new Card(eSuit.SPADES,eRank.EIGHT,0));	
		Hand.BestHandEval(h2);
		
		ArrayList<Hand> TwoHands = new ArrayList<Hand>();
		TwoHands.add(Hand.BestHandEval(h2));
		TwoHands.add(Hand.BestHandEval(h1));
		Collections.sort(TwoHands,Hand.HandRank);
		
		Hand winningHand = TwoHands.get(0);
		Hand losingHand = TwoHands.get(1);
		assertTrue(winningHand.getHandStrength() == eHandStrength.Pair.getHandStrength());
		assertTrue(winningHand.getHighPairStrength() == eRank.ACE.getRank());
		assertTrue(losingHand.getHandStrength() == eHandStrength.Pair.getHandStrength());
		assertTrue(losingHand.getHighPairStrength() == eRank.ACE.getRank());
		assertTrue(h1.isNatural() == 1);
		assertTrue(h2.isNatural() == 0);
	
	}
	
}
	
	



