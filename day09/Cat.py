class Cat:
    #init object
    def __init__(self,new_name,new_age):
        self.name = new_name
        self.age = new_age
    def __str__(self):
        return "%s的年龄是：%d"%(self.name,self.age)
    def eat(self):
        print("猫吃鱼...")
    def drink(self):
        print ("猫正在喝cole")
    def introduce(self):
        print("%s的年龄是：%d"%(self.name,self.age))

# create a object
tom = Cat("汤姆",30)
lanmao = Cat("蓝猫",30)
#invoke function
tom.eat()
tom.drink()
#add two properties for tom
#tom.name="汤姆2"
#tom.age=40
tom.introduce()
print(tom)
print(lanmao)

