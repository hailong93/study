class SweetPotato:
    def __init__(self):
        self.cokedString="生的"
        self.cookedLevel =0
        self.condiments=[]
    def __str__(self):
        return ("%s(%d),作料：%s"%(self.cokedString,self.cookedLevel,str(self.condiments)))
    def cook(self, cooked_time):
        self.cookedLevel+=cooked_time
        if self.cookedLevel>=0 and self.cookedLevel<3:
            self.cokedString="生的"
        elif self.cookedLevel>=3 and self.cookedLevel<5:
            self.cokedString="半生不熟"
        elif self.cookedLevel>=5 and self.cookedLevel<8:
            self.cokedString="熟了"
        elif self.cookedLevel>8:
            self.cokedString="烤糊了"
    def addCondiments(self,condiment):
        self.condiments.append(condiment)
# create a object
cooke_sweet_potato = SweetPotato()
cooke_sweet_potato.cook(1)
print(cooke_sweet_potato)
cooke_sweet_potato.cook(1)
cooke_sweet_potato.addCondiments("大蒜")
print(cooke_sweet_potato)
cooke_sweet_potato.cook(1)
print(cooke_sweet_potato)
cooke_sweet_potato.cook(1)
cooke_sweet_potato.addCondiments("花椒")
print(cooke_sweet_potato)
cooke_sweet_potato.cook(1)
print(cooke_sweet_potato)
