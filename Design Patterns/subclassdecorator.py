from abc import ABC, abstractmethod

class Shape(ABC):
    @abstractmethod
    def area(self):
        pass

    @classmethod
    def __subclasshook__(cls, subclass):
        if cls is Shape:
            # Check if 'area' exists in the subclass or any of its bases
            if any("area" in B.__dict__ for B in subclass.__mro__):
                return True
        return NotImplemented

class Circle:
    def area(self):
        return 3.14 * 5**2

# Returns True despite Circle not inheriting from Shape
print(issubclass(Circle, Shape)) 
print(isinstance(Circle(), Shape))    