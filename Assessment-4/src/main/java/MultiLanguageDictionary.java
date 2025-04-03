import java.util.*;

public class MultiLanguageDictionary<T extends CharSequence> {
    private Map<String, T> dictionary;

    // Constructor to initialize the dictionary
    public MultiLanguageDictionary() {
        dictionary = new TreeMap<>();
    }

    // Method to add a translation to the dictionary
    public void addTranslation(String language, T translation) {
        dictionary.put(language, translation);
    }

    // Method to display all translations
    public void displayTranslations() {
        for (Map.Entry<String, T> entry : dictionary.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        MultiLanguageDictionary<String> dictionary = new MultiLanguageDictionary<>();

        // Adding translations
        dictionary.addTranslation("English", "Hello");
        dictionary.addTranslation("Spanish", "Hola");
        dictionary.addTranslation("French", "Bonjour");

        // Displaying translations
        dictionary.displayTranslations();
    }
}
/*Program 11: Multi-Language Dictionary (Generics, Bounded Types, TreeMap)
Approach:
Generics will allow us to create a dictionary that can store translations for multiple languages.

Bounded Types will ensure that the dictionary only accepts valid data types (such as String for languages).

TreeMap is used to store and sort the translations alphabetically by the language key.

Explanation:
Generics ensure that only CharSequence (like String) types are accepted for translations.

TreeMap stores translations in sorted order based on the language name.

The method addTranslation allows adding a language and its translation, while displayTranslations shows all the entries.
*/