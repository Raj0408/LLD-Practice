from abc import ABC , abstractmethod

class Observer(ABC):
    def update(self):
        pass

class Stock():
    def __init__(self,price) -> None:
        self.current_price = price
        self.observer_list:Observer = []
        self.update_observer()

    def update_observer(self):
        for ob in self.observer_list:
            ob.update()

    def add_stock(self,prixe):
        self.current_price = prixe
        self.update_observer()

    def add_observer(self,obs:Observer):
        self.observer_list.append(obs)

class DisplayUnit(Observer):
    def update(self):
        print("hey this one got update")


stock = Stock(30)

dis = DisplayUnit()

stock.add_observer(dis)

stock.add_stock(40)

    
        