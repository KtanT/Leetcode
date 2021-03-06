import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 */

/**
 * @author Kyran
 */
public class SubstringWithConcatenation {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        if (s == null || words == null || words.length == 0) {
            return res;
        }

        int len = words[0].length();
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String w : words) {
            map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);
        }

        for (int i = 0; i <= s.length() - len * words.length; i++) {
            Map<String, Integer> copy = new HashMap<String, Integer>(map);

            for (int j = 0; j < words.length; j++) { // check if match
                String str = s.substring(i + j * len, i + j * len + len);

                if (copy.containsKey(str)) { // is in remaining words
                    int count = copy.get(str);
                    if (count == 1) {
                        copy.remove(str);
                    } else {
                        copy.put(str, count - 1);
                    }

                    if (copy.isEmpty()) { // matches
                        res.add(i);
                        break;
                    }
                } else {
                    break; // not in L
                }
            }
        }
        return res;
    }
}
