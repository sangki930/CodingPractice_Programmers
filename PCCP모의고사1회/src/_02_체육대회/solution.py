from itertools import permutations as per, combinations as com

def solution(ability):
    answer = 0
    r,c = len(ability), len(ability[0])
    combi = com([i for i in range(r)],c)
    # p = per([i for i in range(c)],c)
    for i in combi:
        for j in per([i for i in range(c)],c):
            s = 0
            for k in range(c):
                s+=ability[i[k]][j[k]]
            # print(s)
            answer = max(answer,s)
        # print(i)
    return answer