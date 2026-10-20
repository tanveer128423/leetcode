class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result = new ArrayList<>();
        Set<String> seen = new HashSet<>();
        Set<String> repeated = new HashSet<>();

        for (int i = 0; i + 10 <= s.length(); i++) {
            String sequence = s.substring(i, i + 10);

            if (seen.contains(sequence)) {
                repeated.add(sequence);
            } else {
                seen.add(sequence);
            }
        }

        result.addAll(repeated);
        return result;
    }
}