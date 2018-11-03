class Horse:
    def __init__(self,new_area,new_info,new_addr):
        self.area = new_area
        self.info = new_info
        self.addr = new_addr
        self.items = []
        self.usable_area = new_area
    def __str__(self):
        return "房子的面积是%d平米，当前可用面积为%d平米，户型是：%s，地址是：%s，包含的物品有%s"\
               %(self.area,self.usable_area,self.info,self.addr,str(self.items))
    def addItem(self,item):
        # 计算可用面积
        self.usable_area -=item.get_area()
        # 添加物品
        self.items.append(item.get_name())
class Bed:
    def __init__(self,new_name,new_area):
        self.name = new_name
        self.area = new_area
    def __str__(self):
        return "占用的面积为%d,床的名字为%s"%(self.area,self.name)
    def get_name(self):
        return self.name
    def get_area(self):
        return self.area
my_horse = Horse(129,"三室一厅","北京市朝阳区")
bed1 = Bed("席梦思",4)
my_horse.addItem(bed1)
print(my_horse)

