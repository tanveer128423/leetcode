class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        Set<String> dict = new HashSet<>(wordDict);
        backtrack(s, 0, dict, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, Set<String> dict,
                           List<String> path, List<String> result) {
        if (start == s.length()) {
            result.add(String.join(" ", path));
            return;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);

            if (dict.contains(word)) {
                path.add(word);
                backtrack(s, end, dict, path, result);
                path.remove(path.size() - 1);
            }
        }
    }
}