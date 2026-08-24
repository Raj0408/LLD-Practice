from abc import ABC,abstractmethod
from typing import TYPE_CHECKING
# from __future__ import annotations
# if TYPE_CHECKING:
#     from __future__ import annotations



class VendingMachineState(ABC):

    @abstractmethod
    def insert_coin(self):
        pass

  

class NoCoinState(VendingMachineState):

    def insert_coin(self,machine:'VendingMachine'):
        print("MOved to NO coing")
        machine.set_state(HashCoinState())
    

class HashCoinState(VendingMachineState):

    def insert_coin(self,machine:'VendingMachine'):
        print("Coin is Added")
    
    def remove_coin(self,machine:'VendingMachine'):
        print("Coin is removed")
        machine.set_state(NoCoinState())

class VendingMachine():

    def __init__(self) -> None:
        self.curr_state = NoCoinState()
    def insert_coin(self):
        self.curr_state.insert_coin(self)
    def set_state(self,state:VendingMachineState):
        self.curr_state = state


vnd = VendingMachine()
vnd.insert_coin()
vnd.insert_coin()