import java.util.*;

public class SocialMediaFollowingSystem {
    private String userName;
    private Set<String> following;
    private Set<String> followers;

    // Constructor to initialize the user's data
    public SocialMediaFollowingSystem(String userName) {
        this.userName = userName;
        following = new HashSet<>();
        followers = new TreeSet<>();  // Sorted in alphabetical order
    }

    // Method to follow another user
    public void followUser(String user) {
        following.add(user);
        System.out.println(userName + " started following " + user);
    }

    // Method to add a follower
    public void addFollower(String user) {
        followers.add(user);
        System.out.println(user + " followed " + userName);
    }

    // Method to display followers using an iterator
    public void displayFollowers() {
        System.out.println(userName + "'s Followers:");
        Iterator<String> iterator = followers.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {
        SocialMediaFollowingSystem user = new SocialMediaFollowingSystem("John");

        // User follows other users
        user.followUser("Alice");
        user.followUser("Bob");

        // Adding followers
        user.addFollower("Eve");
        user.addFollower("Charlie");

        // Display followers
        user.displayFollowers();
    }
}
/*Program 9: Social Media Following System (HashSet, TreeSet, Iterators)
Approach:
HashSet and TreeSet are useful collections in Java for storing unique elements.

HashSet does not guarantee any order of elements.

TreeSet stores elements in a sorted order.

In this social media following system:

HashSet will be used to store the list of users a person is following.

TreeSet will be used to store the list of followers sorted in alphabetical order.

Iterator will be used to iterate over the collections and display the list of followers.

Explanation:
HashSet is used to store users that the current user is following, ensuring no duplicates.

TreeSet is used to store followers in a sorted manner, automatically ordering them alphabetically.

Iterator is used to display the followers, demonstrating how to traverse the set.

The methods followUser and addFollower allow users to follow others and gain followers, respectively.*/