package pokerBase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
	public void BestHandEval_Test_StraightJOKER_1() {
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
	public void BestHandEval_Test_StraightJOKER_0() {
		Deck my_deck = new Deck();
		Hand my_hand = new Hand();
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.TWO,0));
		my_hand.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,true));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.THREE,0));
		my_hand.AddCardToHand(new Card(eSuit.HEARTS,eRank.FOUR,0));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.FIVE,0));
		
		assertTrue(Hand.BestHandEval(my_hand).getHandStrength() == eHandStrength.Straight.getHandStrength());
		assertTrue(Hand.BestHandEval(my_hand).getHighPairStrength() == 0);
		assertTrue(Hand.BestHandEval(my_hand).getLowPairStrength() == 0);
	}

	@Test
	public void BestHandEval_Test_StraightJOKER_2() {
		Deck my_deck = new Deck();
		Hand my_hand = new Hand();
		my_hand.AddCardToHand(new Card(eSuit.CLUBS,eRank.KING,0));
		my_hand.AddCardToHand(new Card(eSuit.JOKER,eRank.JOKER,0));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.JACK,0));
		my_hand.AddCardToHand(new Card(eSuit.HEARTS,eRank.TEN,0));
		my_hand.AddCardToHand(new Card(eSuit.SPADES,eRank.QUEEN,0));
		
		assertTrue(Hand.BestHandEval(my_hand).getHandStrength() == eHandStrength.Straight.getHandStrength());
		assertTrue(Hand.BestHandEval(my_hand).getHighPairStrength() == eRank.ACE.getRank());
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
		System.out.println(Hand.BestHandEval(my_hand).isNatural());
		assertTrue(Hand.BestHandEval(my_hand).getHandStrength() == eHandStrength.RoyalFlush.getHandStrength());
		assertTrue(Hand.BestHandEval(my_hand).getHighPairStrength() == 0);
		assertTrue(Hand.BestHandEval(my_hand).getLowPairStrength() == 0);
		assertTrue(Hand.BestHandEval(my_hand).isNatural() == 1);
	}
	



}



