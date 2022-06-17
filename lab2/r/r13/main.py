from operations import add

print("Введите 2 числа")
num_1 = int(input())
num_2 = int(input())
print(f"{num_1} + {num_2} = ", end='')
print(add(num_1, num_2))
