import java.util.*;

class Bid {
    private String bidderName;
    private int amount;

    public Bid(String bidderName, int amount) {
        this.bidderName = bidderName;
        this.amount = amount;
    }

    public String getBidderName() {
        return bidderName;
    }

    public int getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return bidderName + ": $" + amount;
    }
}

class BidComparator implements Comparator<Bid> {
    @Override
    public int compare(Bid bid1, Bid bid2) {
        return Integer.compare(bid2.getAmount(), bid1.getAmount()); // Sorting by highest bid
    }
}

public class OnlineAuctionSystem {
    public static void main(String[] args) {
        // Creating a PriorityQueue with a custom comparator for sorting bids
        Queue<Bid> auctionQueue = new PriorityQueue<>(new BidComparator());

        // Adding bids to the queue
        auctionQueue.add(new Bid("Alice", 300));
        auctionQueue.add(new Bid("Bob", 500));
        auctionQueue.add(new Bid("Charlie", 450));

        // Processing and displaying the highest bids
        System.out.println("Auction Winner: " + auctionQueue.poll());
        System.out.println("Next Highest Bidder: " + auctionQueue.poll());
        System.out.println("Third Highest Bidder: " + auctionQueue.poll());
    }
}
/*Program 12: Online Auction System (Queue, Generics, PriorityQueue, Comparator)
Approach:
Queue is used to hold bids that are waiting to be processed.

PriorityQueue is used to prioritize bids based on the highest amount.

Comparator will be used to define the custom sorting logic for bids.
Explanation:
Bid Class: Represents a bid with a bidder's name and bid amount.

BidComparator: Used to compare bids based on the amount, prioritizing higher bids.

PriorityQueue: Automatically orders bids so that the highest bid is processed first.
*/