def quicksort(l):
    size = len(l)
    if size<=1:
        return l
    lesser = []
    greater = []

    index = int(size/2)
    pivot = l[index]
    l.remove(pivot)
    for i in l:
        if i >= pivot:
            greater.append(i)
        else:
            lesser.append(i)
    lesser =  quicksort1(lesser)
    lesser.append(pivot)
    return lesser + quicksort1(greater)


