class Animal:
    def eat(self):
        print("----吃----")
    def drink(self):
        print("----喝----")
    def sleep(self):
        print("----睡----")
    def run(self):
        print("----跑----")
class Dog(Animal):
    def bark(self):
        print("----汪汪叫----")
class Xiaotq(Dog):
    def bark(self):
        print("---狂吠---")
        #调用被重写的方法
       # Dog.bark(self)
        super().bark()
xtq = Xiaotq()
xtq.bark()