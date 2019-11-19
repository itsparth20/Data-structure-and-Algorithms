from operator import itemgetter
class Solution:
    def reorderLogFiles(self, logs: List[str]) -> List[str]:
        letter_log = []
        digit_log = []

        for log in logs:
            if self._is_letter(log):
                letter_log.append(log)
            else:
                digit_log.append(log)

        letter_log = self._sort_letter_log(letter_log)
        return letter_log + digit_log
    
    def _is_letter(self, log: str) -> bool:
        ch = log.split()[1][0] 
        return ch >= 'a' and ch <= 'z'

    def  _sort_letter_log(self, letter_log: List[str]) -> None:
        # print (letter_log)
        return sorted(letter_log, key = lambda x: (x.split()[1:], x.split()[0]))
