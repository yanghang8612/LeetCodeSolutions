import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        if (words == null) {
            return result;
        }
        int startIndex = 0;
        int totalWidth = 0;
        for (int i = 0; i < words.length; i++) {
            int curWidth = totalWidth + words[i].length() + (startIndex == i ? 0 : 1);
            if (curWidth <= maxWidth) {
                totalWidth = curWidth;
            }
            else {
                String justifiedString = "";
                int spaceCount = i - 1 - startIndex + maxWidth - totalWidth;
                int spaceSlot = i - 1 - startIndex;
                if (spaceSlot == 0) {
                    justifiedString = words[startIndex];
                    for (int j = 0; j < spaceCount; j++) {
                        justifiedString += " ";
                    }
                }
                else {
                    int spacePerSlot = spaceCount / spaceSlot;
                    int spaceLeft = spaceCount % spaceSlot;
                    String spaceString = "";
                    for (int j = 0; j < spacePerSlot; j++) {
                        spaceString += " ";
                    }
                    for (int j = startIndex; j < i - 1; j++) {
                        justifiedString += (words[j] + spaceString + (spaceLeft-- > 0 ? " " : ""));
                    }
                    justifiedString += words[i - 1];
                }
                result.add(justifiedString);
                startIndex = i;
                totalWidth = words[i].length();
            }
        }
        String justifiedString = "";
        for (int i = startIndex; i < words.length - 1; i++) {
            justifiedString += (words[i] + " ");
        }
        justifiedString += words[words.length - 1];
        for (int i = justifiedString.length(); i < maxWidth; i++) {
            justifiedString += " ";
        }
        result.add(justifiedString);
        return result;
    }

    public static void main(String[] args) {
        //System.out.println(new TextJustification().fullJustify(new String[]{"This", "is", "an", "example", "oof", "text", "justification."}, 14));
        File oldFolder = new File("D:/PalmTouchServer/18511838505/");
        File newFolder = new File("D:/PalmTouchServer/18511838506/");
        if (oldFolder.exists() && oldFolder.isDirectory()) {
            oldFolder.renameTo(newFolder);
        }
    }
}

class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> list = new LinkedList<String>();

        for (int i = 0, w; i < words.length; i = w) {
            int len = -1;
            for (w = i; w < words.length && len + words[w].length() + 1 <= L; w++) {
                len += words[w].length() + 1;
            }

            StringBuilder strBuilder = new StringBuilder(words[i]);
            int space = 1, extra = 0;
            if (w != i + 1 && w != words.length) { // not 1 char, not last line
                space = (L - len) / (w - i - 1) + 1;
                extra = (L - len) % (w - i - 1);
            }
            for (int j = i + 1; j < w; j++) {
                for (int s = space; s > 0; s--) strBuilder.append(' ');
                if (extra-- > 0) strBuilder.append(' ');
                strBuilder.append(words[j]);
            }
            int strLen = L - strBuilder.length();
            while (strLen-- > 0) strBuilder.append(' ');
            list.add(strBuilder.toString());
        }

        return list;
    }
}
