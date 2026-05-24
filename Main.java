import java.util.Map;
import java.util.StringJoiner;
import java.util.TreeMap;

/**
 * The TokenAnalyzer class is responsible for processing an array of string tokens,
 * normalizing them, calculating their frequency, and returning a formatted result.
 */
class TokenAnalyzer {
    // TreeMap automatically sorts the keys in alphabetical (natural) order
    private final Map<String, Integer> tokenFrequencyMap;

    public TokenAnalyzer() {
        this.tokenFrequencyMap = new TreeMap<>();
    }

    /**
     * Processes the input arguments, tokenizes, normalizes (lowercase), 
     * and counts the frequencies.
     *
     * @param args The input string array from the command line
     */
    public void processTokens(String[] args) {
        for (String arg : args) {
            // Split by non-word characters to handle punctuations (optional but good practice)
            // If strict basic split is needed, we just lowercase the arg directly.
            String[] words = arg.toLowerCase().split("\\W+");
            
            for (String word : words) {
                if (!word.isEmpty()) {
                    // Get current count, default to 0 if not exists, then add 1
                    tokenFrequencyMap.put(word, tokenFrequencyMap.getOrDefault(word, 0) + 1);
                }
            }
        }
    }

    /**
     * Formats the sorted map into the required output format: token1=2, token2=1...
     *
     * @return Formatted string of token frequencies
     */
    public String getFormattedResult() {
        // StringJoiner handles the comma and space between elements gracefully
        StringJoiner joiner = new StringJoiner(", ");
        
        for (Map.Entry<String, Integer> entry : tokenFrequencyMap.entrySet()) {
            joiner.add(entry.getKey() + "=" + entry.getValue());
        }
        
        return joiner.toString();
    }
}

/**
 * The Main class to handle command-line execution.
 */
public class Main {
    public static void main(String[] args) {
        // Handle empty input case
        if (args.length == 0) {
            System.out.println("No input provided. Please provide a string argument.");
            return;
        }

        // Initialize the analyzer
        TokenAnalyzer analyzer = new TokenAnalyzer();
        
        // Process the command line arguments
        analyzer.processTokens(args);
        
        // Output the results
        System.out.println(analyzer.getFormattedResult());
    }
}