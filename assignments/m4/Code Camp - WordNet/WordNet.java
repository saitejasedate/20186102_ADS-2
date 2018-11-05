import java.util.ArrayList;
import java.io.File;
import java.util.HashMap;
import java.util.Scanner;
/**
 * Class for word net.
 */
public class WordNet {
    /**
     * hash map.
     */
    private HashMap<String, ArrayList<Integer>> h = new
    HashMap<String, ArrayList<Integer>>();
    /**
     * hashmap.
     */
    private HashMap<Integer, String> h2 = new
    HashMap<Integer, String>();
    /**
     * digraph.
     */
    private Digraph dg;
    /**
     * SAP variable.
     */
    private SAP sap;
    /**
     * has cycle variable.
     */
    private boolean hasCycle = false;
    /**
     * has multiple roots variable.
     */
    private boolean hasMultipleRoots = false;
    /**
     * Gets the digraph.
     *
     * @return     The digraph.
     */
    public Digraph getDigraph() {
        return this.dg;
    }
    /**
     * get hasCycle.
     *
     * @return   boolean.
     */
    public boolean gethasCycle() {
        return this.hasCycle;
    }
    /**
     * hasmultipleroots.
     *
     * @return  boolean.
     */
    public boolean gethasMultipleRoots() {
        return this.hasMultipleRoots;
    }
    /**
     * Constructs the object.
     *
     * @param      synsets    The synsets
     * @param      hypernyms  The hypernyms
     */
    public WordNet(final String synsets, final String hypernyms) {
        try {
            File fileOne = new File(
                "Files/" + synsets);
            Scanner fOne = new Scanner(fileOne);
            File fileTwo = new File("Files/" + hypernyms);
            Scanner fTwo = new Scanner(fileTwo);
            while (fOne.hasNextLine()) {
                String[] tokens = fOne.nextLine().split(",");
                h2.put(Integer.parseInt(tokens[0]), tokens[1]);
                String[] words = tokens[1].split(" ");
                for (int i = 0; i < words.length; i++) {
                    if (h.containsKey(words[i])) {
                        ArrayList<Integer> arraylist = h.get(words[i]);
                        arraylist.add(Integer.parseInt(tokens[0]));
                    } else {
                        ArrayList<Integer> arraylist = new ArrayList<Integer>();
                        arraylist.add(Integer.parseInt(tokens[0]));
                        h.put(words[i], arraylist);
                    }
                }
            }
            dg = new Digraph(h.size());
            while (fTwo.hasNextLine()) {
                String[] tokens = fTwo.nextLine().split(",");
                for (int i = 1; i < tokens.length; i++) {
                    dg.addEdge(Integer.parseInt(tokens[0]),
                               Integer.parseInt(tokens[i]));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        DirectedCycle dc = new DirectedCycle(dg);
        if (dc.hasCycle()) {
            hasCycle = true;
        }
    }
    /**
     * check multiple roots method.
     */
    public void checkMultipleRoots() {
        int roots = 0;
        for (int i = 0; i < dg.v(); i++) {
            if (dg.outdegree(i) == 0) {
                roots++;
            }
        }
        if (roots != 1) {
            hasMultipleRoots = true;
            System.out.println("Multiple roots");
        }
    }
    /**
     * Determines if noun.
     *
     * @param      word  The word
     *
     * @return     True if noun, False otherwise.
     */
    public boolean isNoun(final String word) {
        // for (String s : h.getKeys()) {
        //     if (s.equals(word)) {
        //         return true;
        //     }
        // }
        return true;
    }
    /**
     * distance.
     *
     * @param      nounA  The noun a
     * @param      nounB  The noun b
     *
     * @return distance between nouns.
     */
    public int distance(final String nounA, final String nounB) {
        ArrayList id1 = h.get(nounA);
        ArrayList id2 = h.get(nounB);
        sap = new SAP(dg);
        return sap.length(id1, id2);
    }
    /**
     * sap method.
     *
     * @param      nounA  The noun a
     * @param      nounB  The noun b
     *
     * @return string.
     */
    public String sap(final String nounA, final String nounB) {
        ArrayList<Integer> id1 = h.get(nounA);
        ArrayList<Integer> id2 = h.get(nounB);
        sap = new SAP(dg);
        // System.out.println(id1);
        // System.out.println(id2);
        int ans = sap.ancestor(id1, id2);
        return h2.get(ans);
    }

}

