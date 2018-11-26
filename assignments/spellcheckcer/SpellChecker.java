public class SpellChecker {

    private class BlackFilter {

        public HashSet<String> filterUsingTrie(String dictionaryFileName, String warFileName) {
            HashSet<String> filteredWords = new HashSet<>();

            // The value field is not used, but it is required by the trieST
            TrieST<Boolean> trieST = new TrieST<>();

            In in = new In(dictionaryFileName);
            while (!in.isEmpty()) {
                trieST.put(in.readString(), true);
            }

            String[] allWords = toReadFile(warFileName);

            if (allWords == null) {
                return filteredWords;
            }

            for(String word : allWords) {
                if (!trieST.contains(word)) {
                    filteredWords.add(word);
                }
            }

            return filteredWords;
        }

        public String[] toReadFile(final String file) {
            In in = new In(file);
            return in.readAllStrings();
        }

        public HashSet<String> filterUsingTST(String dictionaryFileName, String warFileName) {
            HashSet<String> filteredWords = new HashSet<>();

            // The value field is not used, but it is required by the ternary search trieST
            TST<Boolean> TST = new TST<>();

            In in = new In(dictionaryFileName);
            while (!in.isEmpty()) {
                TST.put(in.readString(), true);
            }

            String[] allWords = toReadFile(warFileName);

            if (allWords == null) {
                return filteredWords;
            }

            for(String word : allWords) {
                if (!TST.contains(word)) {
                    filteredWords.add(word);
                }
            }

            return filteredWords;
        }
    }


    private void doExperiment(String[] args) {
        String dictionaryFileName =  "D:/MSIT/20186102_ADS2/assignments/spellcheckcer/" + args[0];

        String warFileName = "D:/MSIT/20186102_ADS2/assignments/spellcheckcer/" + args[1];

        BlackFilter blackFilter = new BlackFilter();

        Stopwatch stopwatch = new Stopwatch();
        blackFilter.filterUsingTrie(dictionaryFileName, warFileName);
        double timeSpentWithTrie = stopwatch.elapsedTime();

        stopwatch = new Stopwatch();
        blackFilter.filterUsingTST(dictionaryFileName, warFileName);
        double timeSpentWithTST = stopwatch.elapsedTime();

        StdOut.printf("%s %s\n", "Time spent TrieST | ", "Time spent TST");
        printResults(timeSpentWithTrie, timeSpentWithTST);
    }

    private void printResults(double trieTime, double ternarySearchTrieTime) {
        StdOut.printf("%16.2f %17.2f\n", trieTime, ternarySearchTrieTime);
    }

    public static void main(String[] args) {
        new SpellChecker().doExperiment(args);
    }

}
