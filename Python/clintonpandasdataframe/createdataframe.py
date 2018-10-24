import pandas as pd
def strip_string(word):
    return word.strip()

def get_float(word):
    try:
        return float(strip_string(word))
    except:
        return float(0.0)

def get_int(word):
    try:
        return int(strip_string(word))
    except:
        return int(0)

path = input("Enter the file path: ")
path = strip_string(path)

name = "country name"
voting = "Percent voting for Clinton in 1992"
age = "Median Age"
saving = "Mean Savings"
income = "PerCapita Income"
poverty = "Percent in Poverty"
veteran = "Percent Veterans"
female = "Percent Female"
density = "Population Density"
nursing_home = "Percent in Nursing Homes"
crime = "Crime Index (Per capita)"

map = {
    name: [],
    voting: [],
    age: [],
    saving: [],
    income: [],
    poverty: [],
    veteran: [],
    female: [],
    density: [],
    nursing_home: [],
    crime: []
}

with open(path, encoding="utf16") as fline:
    lst = fline.readlines()

    for line in lst:
        arr = line.split('\t')
        l_name = strip_string(arr[0])
        l_voting = get_float(arr[1])
        l_age = get_float(arr[2])
        l_saving = get_int(arr[3])
        l_income = get_int(arr[4])
        l_poverty = get_float(arr[5])
        l_veteran = get_float(arr[6])
        l_female = get_float(arr[7])
        l_density = get_float(arr[8])
        l_nursing_home = get_float(arr[9])
        l_crime = get_int(arr[10])

        map[name].append(l_name)
        map[voting].append(l_voting)
        map[age].append(l_age)
        map[saving].append(l_saving)
        map[income].append(l_income)
        map[poverty].append(l_poverty)
        map[veteran].append(l_veteran)
        map[female].append(l_female)
        map[density].append(l_density)
        map[nursing_home].append(l_nursing_home)
        map[crime].append(l_crime)

        line = fline.readlines()
        # print (line)

df = pd.DataFrame(data=map)
df.to_csv('clinton1.csv', index=False)
print ("Done")
