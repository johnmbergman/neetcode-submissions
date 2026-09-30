class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        anagrams = defaultdict(list)
        for s in strs:
            k = ''.join(sorted(s))
            anagrams[k].append(s)
        return list(anagrams.values())