'''

Word Ladder

A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words such that:

The first word in the sequence is beginWord.
The last word in the sequence is endWord.
Only one letter is different between each adjacent pair of words in the sequence.
Every word in the sequence is in wordList.
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

 

Example 1:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog" with 5 words.
Example 2:

Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no possible transformation.
 

Constraints:

1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the strings in wordList are unique.

'''

from collections import deque
from collections import namedtuple

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        
        if endWord not in wordList:
            return 0
        
        q = deque()
        Element = namedtuple('Element',['word','lst','count']) 
        q.append(Element(beginWord, wordList, 1))
        visited = set()
        
        while len(q) > 0:
            element = q.popleft()
            word = element.word
            if word in visited:
                continue
            for possible in element.lst:
                if possible not in visited and self._single_change(word, possible):
                    if possible == endWord:
                        return element.count + 1
                    q.append(Element(possible, [x for x in element.lst if x != possible], element.count + 1))
            visited.add(word)
        
        return 0
    
    def _single_change(self, word1, word2):
        changed = False
        for x, y in zip(word1, word2):
            if changed and x != y:
                return False
            
            if x != y:
                changed = True
        
        return True
        
